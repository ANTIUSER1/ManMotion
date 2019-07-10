/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.fileimports;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import pns.api.mainClasses.Point9;
import pns.api.mainClasses.Segment;

/**
 *
 * @author Movement
 */
public class ConvertorUtil {

    public static SortedSet<Segment> convertData(String s) {
        s = s.trim();
        int k = 0;

        List<SortedSet<Segment>> res = new ArrayList<>();
        SortedSet<Segment> result = new TreeSet();
        String[] ssTMP = s.split(System.lineSeparator());

        for (String qs : ssTMP) {
            if (qs.trim().length() > 0) {
                if (k > 0) {
                    SortedSet<Segment> segmentLST = segmentFromLine(qs, ssTMP[0]);
                    if (segmentLST != null) {
                        res.add(segmentLST);
                    }
                }
                k++;
            }
        }
        result = mkSimpleSegmentList(res);
        //    SetArrayUtil.setDisplay(result);

        return result;
    }

    private static SortedSet<Segment> segmentFromLine(String qs, String hd) {

        SortedSet<Segment> res = new TreeSet<>();
        String[] ss = qs.split(" ");

        if (ss.length == 0) {
            return null;
        }
        //System.out.println("   QS:::  " + qs + "   ss.length  " + ss.length);
        double mmoment = 0;
        try {
            mmoment = Double.parseDouble(ss[0].trim());
        } catch (NumberFormatException e) {
            System.out.println("MM    M " + mmoment + "  ss[0] " + ss[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        List<String> segmString = new ArrayList<>();

        for (int p = 1; p < ss.length; p++) {
            segmString.add(ss[p].trim());
        }

        res = segmentListGenerator(segmString, hd, mmoment);
        //  SetArrayUtil.setDisplay(res);

        return res;
    }

    /**
     * Из 2-мерного списка сегментов, сгенерированного из строки вида 4 D0{40;0.1;3.2;5.2;400.2;0.2} D1{0.12;0.2;0.1;3.2;5.2;4.2;0.2} изготавливается 1-мерный список
     * сегментов
     */
    public static SortedSet<Segment> mkSimpleSegmentList(List<SortedSet<Segment>> data) {
        SortedSet<Segment> ss = new TreeSet<>();
        List<Segment> res = new ArrayList<>(ss);
        for (int p = 0; p < data.size(); p++) {
            for (int k = 0; k < data.get(p).size(); k++) {
                List<Segment> tmp = new ArrayList<>(data.get(p));
                res.add(tmp.get(k));
            }
        }
        ss.clear();
        ss.addAll(res);
        return ss;
    }

    private static SortedSet<Segment> segmentListGenerator(List<String> sgList, String hd, double m) {
        SortedSet<Segment> res = new TreeSet();
        for (int k = 0; k < sgList.size(); k++) {
            double mmm = m + k * .000000000001 * Math.random() * Math.random() * Math.random();
            Segment segment = segmentGenerator(sgList.get(k), hd, mmm);
            System.out.println("k=" + k + "  |  " + segment.getId());
            res.add(segment);
        }
        return res;
    }

    private static Segment segmentGenerator(String sg, String hd, double m) {
        Segment res = new Segment();
        sg = sg.replace('}', ' ').trim();
        String[] sss = sg.split("\\{");

        res.setId(sss[0]);
        res.setMoment(m);
        String startDate = hd.split(" ")[0];
        String endDate = hd.split(" ")[1];

        res.setStartDate(startDate);
        res.setEndDate(endDate);
        String ptString = sss[1];

        Point9 pt = pointFromStr(ptString);
        res.setFixedPoint(pt);
        res.setIniUse(true);
        //  System.out.println(res);
        return res;
    }

    private static Point9 pointFromStr(String ptString) {
        Point9 res = new Point9();

        String[] ptValues = ptString.split(";");

        double t;
        try {
            t = Double.parseDouble(ptValues[ptValues.length - 1].trim());
            res.setT0(t);
        } catch (NumberFormatException e) {
        }

        List<Double> speedList = speedFromStrArr(ptValues);
        List<Double> accelertionList = accelerationFromStrArr(ptValues);
        res.setV1(speedList.get(0));
        res.setV2(speedList.get(1));
        res.setV3(speedList.get(2));
        res.setA1(accelertionList.get(0));
        res.setA2(accelertionList.get(1));
        res.setA3(accelertionList.get(2));

        res.setIniUse(true);
//        System.out.println(res);
        return res;
    }

    private static List<Double> speedFromStrArr(String[] ptValues) {
        List<Double> res = new ArrayList<>();
        for (int p = 0; p < 3; p++) {

            if (p < ptValues.length) {

                try {
                    double v = Double.parseDouble(ptValues[p].trim());
                    res.add(v);
                } catch (NumberFormatException e) {
                }
            }
        }
        return res;
    }

    private static List<Double> accelerationFromStrArr(String[] ptValues) {
        List<Double> res = new ArrayList<>();
        for (int p = 3; p < 6; p++) {
            if (p < ptValues.length) {
                try {
                    double a = Double.parseDouble(ptValues[p].trim());
                    res.add(a);
                } catch (NumberFormatException e) {
                }
            }
        }
        return res;
    }

}
