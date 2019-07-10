/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.mainClasses.boxies;

import java.io.Serializable;
import java.util.SortedSet;
import pns.api.mainClasses.Segment;

/**
 *
 * @author Movement
 */
public class SegmentBox implements Serializable, Comparable {

    protected SortedSet<Segment> segment;

    protected double X = 0, Y = 0, Z = 0;

    public SortedSet<Segment> getSegment() {
        return segment;
    }

    public void setSegment(SortedSet<Segment> segment) {
        this.segment = segment;
    }

    public double getX() {
        return X;
    }

    public void setX(double X) {
        this.X = X;
    }

    public double getY() {
        return Y;
    }

    public void setY(double Y) {
        this.Y = Y;
    }

    public double getZ() {
        return Z;
    }

    public void setZ(double Z) {
        this.Z = Z;
    }

    @Override
    public int compareTo(Object o) {
        if (getClass() != o.getClass()) {
            return -Integer.MAX_VALUE;
        }
        final SegmentBox other = (SegmentBox) o;
        double diff = this.Z - other.Z;
        if (diff > 0) {
            return 1;
        } else if (diff < 0) {
            return -1;
        }

        return 0;
    }

}
