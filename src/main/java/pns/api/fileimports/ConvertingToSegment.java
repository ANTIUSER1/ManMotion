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
                            ptPoint9.setMoment(mmoment);
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
                    segment.getPoint9TreeSet().add(ptPoint9);

                }
            }
            System.out.println(" Converting   DONE! " + segment.getPoint9TreeSet().size());
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
                List<Segment> segmentLST = segmentFromLine(qs);
                if (segmentLST != null) {
                    res.add(segmentLST);
                }
                // System.out.println(segmentLST);
            }
            k++;
        }
        System.out.println(res);
        return res;

    }

    private List<Segment> segmentFromLine(String qs) {
        System.out.println("   QS" + qs);
        List<Segment> res = new ArrayList<>();
        String[] ss = qs.split(" ");
        if (ss.length == 0) {
            return null;
        }

        Point9 ptPoint9 = new Point9();
        double mmoment = 0;
        double a1 = 0, a2 = 0, a3 = 0, v1 = 0, v2 = 0, v3 = 0;
        double t0 = 0;
        for (int k = 0; k < ss.length; k++) {

            Segment segment = new Segment();
            String dataLine = ss[k].trim();
            if (dataLine.length() > 0) {
                if (k == 0) {
                    try {
                        mmoment = Double.parseDouble(dataLine.trim());
                        ptPoint9.setMoment(mmoment);
                    } catch (NumberFormatException e) {
                        System.out.println("MM " + k + "     M " + mmoment + "  ss[0] " + ss[0]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    System.out.println("  ---------  moment  " + mmoment);
                }
                String[] lineParts = dataLine.split(" ");
                System.out.println(k + "   dataLine   " + dataLine);
                if (k > 0) {
                    //   parsing string  "D{v1;v2;..........}"
                    String dName = dataLine.split("\\{")[0];
                    String dContent = dataLine.split("\\}")[0];
                    dContent = dContent.substring(dName.length()); //                    String[] dct = dContent.split(";");
                    dContent = dContent.replace('{', ' ').trim();
                    String[] dct = dContent.split(";");
                    System.out.println(dName.length() + "     " + k + " -++- " + "    " + dName + "  dContent " + dContent + "    frag  " + dataLine);
                    segment.setId(dName);
                    /*
                    Speed
                     */
                    try {
                        v1 = Double.parseDouble(dct[0].trim());
                        ptPoint9.setV1(v1);
                        //  System.out.println("k=" + k + "   " + ptPoint9);
                    } catch (NumberFormatException e) {
                        System.out.println("   V1   " + k + "  V  " + v1 + "  dct[0] " + dct[0]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        ptPoint9.setV1(v1);
                    }
                    try {
                        v2 = Double.parseDouble(dct[1].trim());
                        ptPoint9.setV2(v2);
                        //  System.out.println("k=" + k + "   " + ptPoint9);
                    } catch (NumberFormatException e) {
                        System.out.println("   V2  " + k + "  A  " + v2 + "  dct[1] " + dct[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        ptPoint9.setV2(v2);
                    }
                    try {
                        v3 = Double.parseDouble(dct[2].trim());
                        ptPoint9.setV3(v3);
                        //  System.out.println("k=" + k + "   " + ptPoint9);
                    } catch (NumberFormatException e) {
                        System.out.println("   V3  " + k + "  V  " + v3 + "  dct[2] " + dct[2]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        ptPoint9.setV3(v3);
                    }

                    /*
                Accseleration
                     */
                    try {
                        a1 = Double.parseDouble(dct[3].trim());
                        ptPoint9.setA1(a1);
                        //  System.out.println("k=" + k + "   " + ptPoint9);
                    } catch (NumberFormatException e) {
                        System.out.println("   A1   " + k + "  A  " + a1 + "  dct[3] " + dct[3]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        ptPoint9.setA1(a1);
                    }
                    try {
                        a2 = Double.parseDouble(dct[4].trim());
                        ptPoint9.setA1(a2);
                        //  System.out.println("k=" + k + "   " + ptPoint9);
                    } catch (NumberFormatException e) {
                        System.out.println("   A2  " + k + "  A  " + a2 + "  dct[4] " + ss[4]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        ptPoint9.setA2(a2);
                    }
                    try {
                        a3 = Double.parseDouble(dct[5].trim());
                        ptPoint9.setA3(a3);
                        //  System.out.println("k=" + k + "   " + ptPoint9);
                    } catch (NumberFormatException e) {
                        System.out.println("   A3  " + k + "  A  " + a2 + "  dct[5] " + dct[5]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        ptPoint9.setA3(a3);
                    }
                    /*
                Temperature
                     */
                    try {
                        t0 = Double.parseDouble(dct[5].trim());
                        ptPoint9.setT0(t0);
                        //  System.out.println("k=" + k + "   " + ptPoint9);
                    } catch (NumberFormatException e) {
                        System.out.println("   T0  " + k + "  T  " + a2 + "  dct[5] " + dct[6]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        ptPoint9.setA3(a3);
                    }
                    segment.getPoint9TreeSet().add(ptPoint9);

                }
//                System.out.println(segment);
                res.add(segment);

            }

        }
        return res;
    }
}
