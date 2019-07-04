/**
 * Класс, описывающий расположения сегмента
 */
package pns.api.mainClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import pns.api.exeptions.SegmentExeption;
import pns.api.interfaces.ISegm;
import pns.tools.Integral;
import pns.tools.Interpolate;

/**
 *
 * @author Movement
 */
public class Segment implements Serializable, Runnable, ISegm {

    private int size = 3;
    private Point9 fixedPoint;
    private SortedSet<Point9> point9TreeSet = new TreeSet<Point9>();
    private String id = "";

    public Segment() {
        fixedPoint = new Point9();
        id = pns.utils.strings.RStrings.rndLetterStringRNDLen(5);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setFixedPoint(Point9 fixedPoint) {
        this.fixedPoint = fixedPoint;
    }

    public int getSize() {
        return size;
    }

    public Point9 getFixedPoint() {
        return fixedPoint;
    }

    public SortedSet<Point9> getPoint9TreeSet() {
        return point9TreeSet;
    }

    @Override
    public void run() {
        int k = 0;
        while (point9TreeSet.size() < size) {
//            System.out.println("k=" + k);
//            k++;
            generatePointSet();
            try {
                Thread.sleep(3);
            } catch (InterruptedException ex) {
//                Logger.getLogger(Segment.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(" s SIZE:   " + size);
        // System.out.println(point9TreeSet);

    }

    protected void generatePointSet() {
        Point9 point9 = new Point9();
        point9.setA1(Math.random());
        point9.setA2(Math.random());
        point9.setA3(Math.random());
        point9.setV1(Math.random());
        point9.setV2(Math.random());
        point9.setV3(Math.random());
        point9.setX1(Math.random());
        point9.setX2(Math.random());
        point9.setX3(Math.random());
        point9TreeSet.add(point9);
    }

    public void calcData(double from, double to) {

    }

    public double calcData() throws SegmentExeption {
        List<Point9> pts = new ArrayList<Point9>(point9TreeSet);
        double[] mms = new double[pts.size()];
        double[] vvs1 = new double[mms.length];
        double[] vvs2 = new double[mms.length];
        double[] vvs3 = new double[mms.length];
        for (int k = 0; k < mms.length; k++) {
            mms[k] = pts.get(k).getMoment();
            vvs1[k] = pts.get(k).getV1();
            vvs2[k] = pts.get(k).getV3();
            vvs3[k] = pts.get(k).getV3();
        }
        try {
            Interpolate interpolate = new Interpolate();
            UnivariateFunction f = interpolate.interpolate(mms, vvs1);
            Integral integral = new Integral();
            double[] XX1 = integral.doIntegrate(f, mms);
            for (int k = 0; k < XX1.length - 1; k++) {
                pts.get(k).setX1(XX1[k]);
            }
            double res = pns.utils.array.ArrayNumberUtils.makeSumm(XX1);
            return res;
        } catch (NumberIsTooSmallException e) {
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Segment{" + "id=" + id + ", " + "size=" + size + ", " + System.lineSeparator()
                + "point9TreeSet=" + point9TreeSet + System.lineSeparator() + " point9TreeSet.size() " + point9TreeSet.size() + "  " + System.lineSeparator() + '}';
    }

}
