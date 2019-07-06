/**
 * Класс, описывающий расположения сегмента
 */
package pns.api.mainClasses;

import java.io.Serializable;
import java.util.Objects;
import pns.api.interfaces.ISegm;

/**
 *
 * @author Movement
 */
public class Segment implements Serializable, Runnable, Comparable, ISegm {

    protected double length = 0;
    protected Point9 fixedPoint;
    //protected Set<Point9> point9TreeSet = new HashSet<Point9>();
    protected String id = "";
    protected double moment;
    protected boolean iniUse = false;

    private String startDate = "";
    private String endDate = "";

    public Segment() {
        moment = Math.random() * Math.random() * Math.random() * Math.random();

        fixedPoint = new Point9();
        id = pns.utils.strings.RStrings.rndLetterStringRNDLen(5);
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isIniUse() {
        return iniUse;
    }

    public void setIniUse(boolean iniUse) {
        this.iniUse = iniUse;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getMoment() {
        return moment;
    }

    public void setMoment(double moment) {
        this.moment = moment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFixedPoint(Point9 fixedPoint) {
        this.fixedPoint = fixedPoint;
    }

    public Point9 getFixedPoint() {
        return fixedPoint;
    }

//    public Set<Point9> getPoint9TreeSet() {
//        return point9TreeSet;
//    }
    @Override
    public void run() {
        int k = 0;
//        while (point9TreeSet.size() < length) {
////            System.out.println("k=" + k);
////            k++;
//            generatePointSet();
//            try {
//                Thread.sleep(3);
//            } catch (InterruptedException ex) {
////                Logger.getLogger(Segment.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

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
    }

    public void calcData(double from, double to) {

    }

//    public double calcData() throws SegmentExeption {
//        List<Point9> pts = new ArrayList<Point9>(point9TreeSet);
//        double[] mms = new double[pts.size()];
//        double[] vvs1 = new double[mms.length];
//        double[] vvs2 = new double[mms.length];
//        double[] vvs3 = new double[mms.length];
//        for (int k = 0; k < mms.length; k++) {
//            mms[k] = pts.get(k).getMoment();
//            vvs1[k] = pts.get(k).getV1();
//            vvs2[k] = pts.get(k).getV3();
//            vvs3[k] = pts.get(k).getV3();
//        }
//        System.out.println("     ##############   mms.length     " + mms.length);
//        try {
//            Interpolate interpolate = new Interpolate();
//            UnivariateFunction f = interpolate.interpolate(mms, vvs1);
//            Integral integral = new Integral();
//            double[] XX1 = integral.doIntegrate(f, mms);
//            for (int k = 0; k < XX1.length - 1; k++) {
//                pts.get(k).setX1(XX1[k]);
//            }
//            double res = pns.utils.array.ArrayNumberUtils.makeSumm(XX1);
//            System.out.println(id + "    CALC:  res   " + res);
//            return res;
//        } catch (NumberIsTooSmallException e) {
//
//        }
//        return 0;
//    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.length) ^ (Double.doubleToLongBits(this.length) >>> 32));
        hash = 11 * hash + Objects.hashCode(this.fixedPoint);
//        hash = 11 * hash + Objects.hashCode(this.point9TreeSet);
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.moment) ^ (Double.doubleToLongBits(this.moment) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Segment other = (Segment) obj;
        if (Double.doubleToLongBits(this.length) != Double.doubleToLongBits(other.length)) {
            return false;
        }
        if (Double.doubleToLongBits(this.moment) != Double.doubleToLongBits(other.moment)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fixedPoint, other.fixedPoint)) {
            return false;
        }
//        if (!Objects.equals(this.point9TreeSet, other.point9TreeSet)) {
//            return false;
//        }
        return true;
    }

    @Override
    public String toString() {
        return "Segment{  " + "id=" + id + ",  inUse=" + iniUse + " ,      length=" + length + ", " + System.lineSeparator()
                + "  startDate=" + startDate + "  , endDate=" + endDate + System.lineSeparator()
                + " ,  fixedPoint  " + fixedPoint + System.lineSeparator()
                // + point9TreeSet=" + point9TreeSet + System.lineSeparator() + " point9TreeSet.size() " + point9TreeSet.size() + " , " + System.lineSeparator()
                + " moment=" + moment + '}' + System.lineSeparator() + "   " + System.lineSeparator();
    }

    @Override
    public int compareTo(Object o) {
        if (getClass() != o.getClass()) {
            return -Integer.MAX_VALUE;
        }
        final Segment other = (Segment) o;

        return (int) (1000000000 * (moment - other.moment));
    }

}
