/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.fileimports;

import java.util.ArrayList;
import java.util.List;
import pns.api.mainClasses.Point9;
import pns.api.mainClasses.Segment;

/**
 *
 * @author Movement
 */
public class ConvertingToSegment {

    public Segment convert(String data, boolean useMomentField) {
        System.out.println("Converting!!");
        double a1 = 0, a2 = 0, a3 = 0, v1 = 0, v2 = 0, v3 = 0;
        double mmoment = 0;
        Segment segment = new Segment();
        data = data.replace(',', '.');
        int k = 0;
        String[] lines = data.split(System.lineSeparator());
        System.out.println("Working with   lines length  " + lines.length + " lines");
        for (String s : lines) {
            String[] ss = s.split(";");
            System.out.print("         Splitting line by`;` symbol -- result " + ss.length + "  pieces ");
            Point9 ptPoint9 = new Point9();

            if (s.length() > 0) {

                if (ss.length == 1) {
                    segment.setId(ss[0]);
                }
                if (ss.length > 1) {
                    if (useMomentField) {
                        try {
                            mmoment = Double.parseDouble(ss[0].trim());
                            segment.setMoment(mmoment);
                        } catch (NumberFormatException e) {
                            System.out.println("MM " + k + "     M " + mmoment + "  ss[0] " + ss[0]);
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                    }
                    try {
                        v1 = Double.parseDouble(ss[1].trim());
                        ptPoint9.setV1(v1);
                        //  System.out.println("k=" + k + "   " + ptPoint9);
                    } catch (NumberFormatException e) {
                        System.out.println("   V   " + k + "  V  " + v1 + "  ss[1] " + ss[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        a1 = Double.parseDouble(ss[2].trim());
                        ptPoint9.setA1(a1);
                        //  System.out.println("k=" + k + "   " + ptPoint9);
                    } catch (NumberFormatException e) {
                        System.out.println("   A   " + k + "  A  " + a1 + "  ss[1] " + ss[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    k++;
                    segment.setFixedPoint(ptPoint9);
                    //segment.getPoint9TreeSet().add(ptPoint9);

                }
            }
        }
        //  System.out.println("      segment.getPoint9TreeSet().size()  " + segment.getPoint9TreeSet().size());
        //    System.out.println(segment);
        return segment;
    }

    public List<List<Segment>> convertNEW(String s) {
        s = s.trim();
        int k = 0;
        List<List<Segment>> res = new ArrayList<>();
        String[] ssTMP = s.split(System.lineSeparator());
        for (String qs : ssTMP) {
            if (k > 0) {
                List<Segment> segmentLST = segmentFromLine(qs, ssTMP[0]);
                if (segmentLST != null) {
                    res.add(segmentLST);
                }
            }
            k++;
        }
        return res;

    }

    /**
     * Производится вычисление остальных параметров в сегментах списка сегментов
     *
     * @param sgm
     * @param segmNo
     * @param total
     * @return
     */
    public static List<Segment> mkSimpleSegmList(String s) {
        ConvertingToSegment cts = new ConvertingToSegment();
        List<List<Segment>> segmentList = cts.convertNEW(s);

        List<Segment> simpleSegmentList = cts.mkSimpleSegmentList(segmentList);
        return simpleSegmentList;
    }

    /**
     * Из 2-мерного списка сегментов, сгенерированного из строки вида 4 D0{40;0.1;3.2;5.2;400.2;0.2} D1{0.12;0.2;0.1;3.2;5.2;4.2;0.2} изготавливается 1-мерный список
     * сегментов
     */
    public static List<Segment> mkSimpleSegmentList(List<List<Segment>> data) {

        System.out.println("          data.size()   " + data.size());
        System.out.println("  data.get(0).size()   " + data.get(0).size());
        List<Segment> res = new ArrayList<>();
        for (int p = 0; p < data.size(); p++) {
            for (int k = 0; k < data.get(p).size(); k++) {
                res.add(data.get(p).get(k));
            }
        }

        return res;
    }

    /**
     * Формируется список сегментов, сгруппированных по номерам сегментов в строке вида 4 D0{40;0.1;3.2;5.2;400.2;0.2} D1{0.12;0.2;0.1;3.2;5.2;4.2;0.2}
     *
     * @param ssl
     * @return
     */
    public static List<Segment> outputSimpleSegmentList(List<Segment> ssl) {
        List<Segment> res = new ArrayList<>();
        for (int s = 0; s < ssl.size(); s++) {
            //System.out.println(s + "  " + ssl.get(s).getId() + "   " + ssl.get(s).getFixedPoint().getV1());
            res.add(ssl.get(s));
        }
        return res;
    }

    /**
     * Формируется список сегментов по указанному номеру сегмента в строке вида 4 D0{40;0.1;3.2;5.2;400.2;0.2} D1{0.12;0.2;0.1;3.2;5.2;4.2;0.2}
     *
     * @param ssl
     * @param k
     * @param total
     * @return
     */
    public static List<Segment> outputSimpleSegmentList(List<Segment> ssl, int k, int total) {
        List<Segment> res = new ArrayList<>();
        for (int s = 0; s < ssl.size(); s++) {
            if (s % total == k) {
                res.add(ssl.get(s));
            }
        }
        return res;
    }

    private List<Segment> segmentFromLine(String qs, String hd) {

        List<Segment> res = new ArrayList<>();
        String[] ss = qs.split(" ");
        if (ss.length == 0) {
            return null;
        }
//        System.out.println("   QS:::  " + qs + "   ss.length  " + ss.length);
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

        return res;
    }

    private double calcData(List<Segment> data) {
        System.out.println(data);
        double res = 0;
        double[] speedArray = new double[data.size()];

        return res;

    }

    private List<Segment> segmentListGenerator(List<String> sgl, String hd, double m) {
        List<Segment> res = new ArrayList<>();
        for (int k = 0; k < sgl.size(); k++) {
            Segment segment = segmentGenerator(sgl.get(k), hd, m);
            res.add(segment);
        }
        return res;
    }

    private Segment segmentGenerator(String sg, String hd, double m) {
        Segment res = new Segment();
        sg = sg.replace('}', ' ').trim();
        res.setId(sg.split("\\{")[0]);
        res.setMoment(m);
        String startDate = hd.split(" ")[0];
        String endDate = hd.split(" ")[1];

        res.setStartDate(startDate);
        res.setEndDate(endDate);

        String ptString = sg.split("\\{")[1];
        Point9 pt = pointFromStr(ptString);
        res.setFixedPoint(pt);
        res.setIniUse(true);
        //  System.out.println(res);
        return res;
    }

    private Point9 pointFromStr(String ptString) {
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

    private List<Double> speedFromStrArr(String[] ptValues) {
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

    private List<Double> accelerationFromStrArr(String[] ptValues) {
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
