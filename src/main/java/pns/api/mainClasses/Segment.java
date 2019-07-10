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
        double diff = 10000000 * this.moment - 10000000 * other.moment;
        if (diff > 0) {
            return 1;
        } else if (diff < 0) {
            return -1;
        }

        return 0;// (int) diff;

    }

}
