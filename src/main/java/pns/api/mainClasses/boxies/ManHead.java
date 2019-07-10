/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.mainClasses.boxies;

import pns.api.mainClasses.boxies.SegmentBox;
import java.util.SortedSet;
import pns.api.mainClasses.Segment;

/**
 *
 * @author Movement
 */
public class ManHead extends SegmentBox {

    public SortedSet<Segment> getSegment() {
        return segment;
    }

    public void setSegment(SortedSet<Segment> segment) {
        this.segment = segment;
    }

}
