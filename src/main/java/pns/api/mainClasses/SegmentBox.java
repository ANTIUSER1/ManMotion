/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.mainClasses;

import java.util.SortedSet;

/**
 *
 * @author Movement
 */
public class SegmentBox {

    protected SortedSet<Segment> segment;

    public SortedSet<Segment> getSegment() {
        return segment;
    }

    public void setSegment(SortedSet<Segment> segment) {
        this.segment = segment;
    }
}
