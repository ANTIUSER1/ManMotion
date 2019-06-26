/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.fileimports;

import pns.api.mainClasses.Point9;
import pns.api.mainClasses.Segment;

/**
 *
 * @author Movement
 */
public class ConvertingToSegment {

    public Segment convert(String data) {
        System.out.println("Converting!!");
        double v1 = 0;
        double mmoment = 0;
        Segment segment = new Segment();
        data = data.replace(',', '.');
        int k = 0;
        String[] lines = data.split(System.lineSeparator());
        System.out.println("   lines.length  " + lines.length);
        for (String s : lines) {
            String[] ss = s.split(";");
            Point9 ptPoint9 = new Point9();
            if (s.length() > 0) {
                try {
                    try {
                        mmoment = Double.parseDouble(ss[0].trim());
                        ptPoint9.setMoment(mmoment);
                    } catch (NumberFormatException e) {
                        System.out.println("MM " + k + "     mmoment " + mmoment + "  ss[0] " + ss[0]);
                    }
                    try {
                        v1 = Double.parseDouble(ss[1].trim());
                        ptPoint9.setV1(v1);
                        //  System.out.println("k=" + k + "   " + ptPoint9);
                    } catch (NumberFormatException e) {
                        System.out.println("   VV   " + k + "  VV  " + v1 + "  ss[1] " + ss[1]);
                    }
                    k++;
                    segment.getPoint9TreeSet().add(ptPoint9);

                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }
        //  System.out.println("      segment.getPoint9TreeSet().size()  " + segment.getPoint9TreeSet().size());
        //System.out.println(segment);
        return segment;
    }

    /*
    public double[] extractVelocityFromSegment(Segment segment) {
        List<Point9> pts = new ArrayList<Point9>(segment.getPoint9TreeSet());
        double[] res = new double[pts.size()];
        for (int k = 0; k < res.length; k++) {
            res[k] = pts.get(k).getV1();
        }
        return res;
    }

    public double[] extractMomentFromSegment(Segment segment) {
        List<Point9> pts = new ArrayList<Point9>(segment.getPoint9TreeSet());
        double[] res = new double[pts.size()];
        for (int k = 0; k < res.length; k++) {
            res[k] = pts.get(k).getMoment();
        }
        return res;
    }
     */
}
