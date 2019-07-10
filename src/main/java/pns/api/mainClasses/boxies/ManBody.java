/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.mainClasses.boxies;

import java.util.SortedSet;
import pns.api.mainClasses.Segment;

/**
 *
 * @author Movement
 */
public class ManBody extends SegmentBox {

    public void setSegment(SortedSet<Segment> segment) {
        this.segment = segment;
    }

}
