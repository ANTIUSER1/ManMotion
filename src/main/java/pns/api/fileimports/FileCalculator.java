/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.fileimports;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
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
        SortedSet<Segment> ss = new TreeSet<>();

        List<Segment> res = new ArrayList<>();
        for (int p = 0; p < data.size(); p++) {
            for (int k = 0; k < data.get(p).size(); k++) {
                ss.add(data.get(p).get(k));
            }
        }
        res.addAll(ss);
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

    public static SortedSet<Segment> outputSimpleSegmentList(Collection<Segment> ssl, int k, int total) {

        System.out.println("   ssl.size()" + ssl.size());
        SortedSet<Segment> res = new TreeSet<>();
        System.out.println("   res.size()" + res.size());

        List<Segment> tmp = new ArrayList<>(ssl);
        for (int s = 0; s < ssl.size(); s++) {
            if (s % total == k) {
                res.add(tmp.get(s));
            }
        }
        return res;
    }

    public static SortedSet<Segment> integrate(SortedSet<Segment> sgm, int segmNo, int total) {
        SortedSet<Segment> sgmToCalcSet = outputSimpleSegmentList(sgm, segmNo, total);
        List<Segment> sgmToCalc = new ArrayList<>(sgmToCalcSet);
        int N = sgmToCalc.size();

        double[] mm = new double[N];
        double[] vv1 = new double[N];
        double[] vv2 = new double[N];
        double[] vv3 = new double[N];
        double[] xx1 = new double[N];
        double[] xx2 = new double[N];
        double[] xx3 = new double[N];

        for (int n = 0; n < N; n++) {
//            System.out.println(n + "   sgmToCalc.get(n).getId()  " + sgmToCalc.get(n).getId() + "   ==========  getMoment()  " + sgmToCalc.get(n).getMoment());
        }
        for (int k = 0; k < mm.length; k++) {
            // System.out.println(k + "     mm[k] " + mm[k] + "   ==========  getMoment()  " + sgmToCalc.get(k).getMoment());
            mm[k] = sgmToCalc.get(k).getMoment();
            // System.out.println(k + "     mm[k] " + mm[k]);
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
            System.out.println(" Integration  error  :   Too small Number step ........ ");
        } catch (NonMonotonicSequenceException e) {
            System.out.println(" Integration  error  :   Non Monotonic sequence ........ ");
        }
        sgmToCalcSet.clear();
        sgmToCalcSet.addAll(sgmToCalc);
        return sgmToCalcSet;
    }

    public static SortedSet<Segment> integrate(SortedSet<Segment> sgm) {
        if (sgm.size() < 2) {
            System.out.println("The data has les then 2 points to iterate.  Integration is unavailable .......");

            return null;
        }
        List<Segment> sgmToCalc = new ArrayList<>(sgm);
        SortedSet<Segment> sgmToCalcSet = new TreeSet<>();

        int N = sgmToCalc.size();

        double[] mm = new double[N];
        double[] vv1 = new double[N];
        double[] vv2 = new double[N];
        double[] vv3 = new double[N];
        double[] xx1 = new double[N];
        double[] xx2 = new double[N];
        double[] xx3 = new double[N];

        for (int n = 0; n < N; n++) {
//            System.out.println(n + "   sgmToCalc.get(n).getId()  " + sgmToCalc.get(n).getId() + "   ==========  getMoment()  " + sgmToCalc.get(n).getMoment());
        }
        for (int k = 0; k < mm.length; k++) {
            // System.out.println(k + "     mm[k] " + mm[k] + "   ==========  getMoment()  " + sgmToCalc.get(k).getMoment());
            mm[k] = sgmToCalc.get(k).getMoment();
            // System.out.println(k + "     mm[k] " + mm[k]);
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
            System.out.println(" Integration  error  :   Too small Number step ........ ");
        } catch (NonMonotonicSequenceException e) {
            System.out.println(" Integration  error  :   Non Monotonic sequence ........ ");
        }
        sgmToCalcSet.clear();
        sgmToCalcSet.addAll(sgmToCalc);
        return sgmToCalcSet;
    }

    public static  Map<String, SortedSet<Segment>> integrate( Map<String, SortedSet<Segment>> segmMap) {
        for (Map.Entry<String, SortedSet<Segment>> entry : segmMap.entrySet()) {
            SortedSet<Segment> data = entry.getValue();
            SortedSet<Segment> rdata = integrate(data);
            entry.setValue(rdata);
        }
        return segmMap;
    }

}
