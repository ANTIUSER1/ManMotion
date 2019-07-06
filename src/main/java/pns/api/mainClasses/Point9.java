/**
 *
 * Класс, указывающий направление движения, ускорение, координаты
 * Содержит информацию о моменте создания
 *
 */
package pns.api.mainClasses;

import java.io.Serializable;

/**
 *
 * @author Movement
 */
public class Point9 implements Serializable {

    protected double x1, x2, x3, // коодинаты
            v1, v2, v3, // скорость
            a1, a2, a3 // ускорение
            ;

    private double t0;
    protected boolean iniUse = false;

    public Point9() {
    }

    public boolean isIniUse() {
        return iniUse;
    }

    public void setIniUse(boolean iniUse) {
        this.iniUse = iniUse;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getV1() {
        return v1;
    }

    public void setV1(double v1) {
        this.v1 = v1;
    }

    public double getV2() {
        return v2;
    }

    public void setV2(double v2) {
        this.v2 = v2;
    }

    public double getV3() {
        return v3;
    }

    public void setV3(double v3) {
        this.v3 = v3;
    }

    public double getA1() {
        return a1;
    }

    public void setA1(double a1) {
        this.a1 = a1;
    }

    public double getA2() {
        return a2;
    }

    public void setA2(double a2) {
        this.a2 = a2;
    }

    public double getA3() {
        return a3;
    }

    public void setA3(double a3) {
        this.a3 = a3;
    }

    public double getT0() {
        return t0;
    }

    public void setT0(double t0) {
        this.t0 = t0;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.x1) ^ (Double.doubleToLongBits(this.x1) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.x2) ^ (Double.doubleToLongBits(this.x2) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.x3) ^ (Double.doubleToLongBits(this.x3) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.v1) ^ (Double.doubleToLongBits(this.v1) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.v2) ^ (Double.doubleToLongBits(this.v2) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.v3) ^ (Double.doubleToLongBits(this.v3) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.a1) ^ (Double.doubleToLongBits(this.a1) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.a2) ^ (Double.doubleToLongBits(this.a2) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.a3) ^ (Double.doubleToLongBits(this.a3) >>> 32));

        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point9 other = (Point9) obj;
        if (Double.doubleToLongBits(this.x1) != Double.doubleToLongBits(other.x1)) {
            return false;
        }
        if (Double.doubleToLongBits(this.x2) != Double.doubleToLongBits(other.x2)) {
            return false;
        }
        if (Double.doubleToLongBits(this.x3) != Double.doubleToLongBits(other.x3)) {
            return false;
        }
        if (Double.doubleToLongBits(this.v1) != Double.doubleToLongBits(other.v1)) {
            return false;
        }
        if (Double.doubleToLongBits(this.v2) != Double.doubleToLongBits(other.v2)) {
            return false;
        }
        if (Double.doubleToLongBits(this.v3) != Double.doubleToLongBits(other.v3)) {
            return false;
        }
        if (Double.doubleToLongBits(this.a1) != Double.doubleToLongBits(other.a1)) {
            return false;
        }
        if (Double.doubleToLongBits(this.a2) != Double.doubleToLongBits(other.a2)) {
            return false;
        }
        if (Double.doubleToLongBits(this.a3) != Double.doubleToLongBits(other.a3)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        System.out.println("   this= " + this);
        return true;
    }

    @Override
    public String toString() {
        return "Point9={" + "x1=" + x1 + ", x2=" + x2 + ", x3=" + x3 + "," + System.lineSeparator()
                + " v1=" + v1 + ", v2=" + v2 + ", v3=" + v3 + "," + System.lineSeparator()
                + " a1=" + a1 + ", a2=" + a2 + ", a3=" + a3 + "," + System.lineSeparator()
                + " t0=" + t0 + ","
                + " iniUse=" + iniUse + System.lineSeparator();
    }

}
