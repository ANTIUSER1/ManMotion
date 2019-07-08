/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.fileimports;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import pns.api.mainClasses.Segment;
import pns.tools.Integral;
import pns.tools.Interpolate;

/**
 *
 * @author Movement
 */
public class FileCalculator {

    public static List<Segment> mkSimpleSegmentList(List<List<Segment>> data) {
        List<Segment> res = new ArrayList<>();
        for (int p = 0; p < data.size(); p++) {
            for (int k = 0; k < data.get(p).size(); k++) {
                res.add(data.get(p).get(k));
            }
        }

        return res;
    }

    public static List<Segment> outputSimpleSegmentList(List<Segment> ssl) {
        List<Segment> res = new ArrayList<>();
        for (int s = 0; s < ssl.size(); s++) {
            //System.out.println(s + "  " + ssl.get(s).getId() + "   " + ssl.get(s).getFixedPoint().getV1());
            res.add(ssl.get(s));
        }
        return res;
    }

    public static List<Segment> outputSimpleSegmentList(List<Segment> ssl, int k, int total) {
        List<Segment> res = new ArrayList<>();
        for (int s = 0; s < ssl.size(); s++) {
            if (s % total == k) {
                //        System.out.println(s + "  " + ssl.get(s).getId() + "   " + ssl.get(s).getFixedPoint().getV1());
                res.add(ssl.get(s));
            }
        }
        return res;
    }

    public static List<Segment> integrateSegmList(List<Segment> sgm, int segmNo, int total) {
        List<Segment> sgmToCalc = outputSimpleSegmentList(sgm, segmNo, total);
        int N = sgmToCalc.size();

        double[] mm = new double[N];
        double[] vv1 = new double[N];
        double[] vv2 = new double[N];
        double[] vv3 = new double[N];
        double[] xx1 = new double[N];
        double[] xx2 = new double[N];
        double[] xx3 = new double[N];

        for (int k = 0; k < mm.length; k++) {
            mm[k] = sgmToCalc.get(k).getMoment();
            vv1[k] = sgmToCalc.get(k).getFixedPoint().getV1();
            vv2[k] = sgmToCalc.get(k).getFixedPoint().getV3();
            vv3[k] = sgmToCalc.get(k).getFixedPoint().getV3();
        }

        try {
            Interpolate interpolate = new Interpolate();
            UnivariateFunction f1 = interpolate.interpolate(mm, vv1);
            UnivariateFunction f2 = interpolate.interpolate(mm, vv2);
            UnivariateFunction f3 = interpolate.interpolate(mm, vv3);
            Integral integral = new Integral();

            double[] XX1 = integral.doIntegrate(f1, mm);
            double[] XX2 = integral.doIntegrate(f2, mm);
            double[] XX3 = integral.doIntegrate(f3, mm);

            for (int k = 0; k < XX1.length - 1; k++) {
                sgmToCalc.get(k).getFixedPoint().setX1(XX1[k]);
                sgmToCalc.get(k).getFixedPoint().setX2(XX2[k]);
                sgmToCalc.get(k).getFixedPoint().setX3(XX3[k]);
            }

        } catch (NumberIsTooSmallException e) {
            System.out.println("   errrrrroorrrrr");
        }

        return sgmToCalc;
    }

}
