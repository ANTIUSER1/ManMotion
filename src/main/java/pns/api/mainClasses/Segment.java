/**
 * Класс, описывающий расположения сегмента
 */
package pns.api.mainClasses;

import java.io.Serializable;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Movement
 */
public class Segment implements Serializable, Runnable {

    private int size = 3;
    private Point9 fixedPoint;
    private SortedSet<Point9> point9TreeSet = new TreeSet<Point9>();

    public Segment() {
        fixedPoint = new Point9();
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

    @Override
    public String toString() {
        return "Segment{" + "size=" + size + ", " + System.lineSeparator()
                + "point9TreeSet=" + point9TreeSet + System.lineSeparator() + " point9TreeSet.size() " + point9TreeSet.size() + "  " + System.lineSeparator() + '}';
    }

}
