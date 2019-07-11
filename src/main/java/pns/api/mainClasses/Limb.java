/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.mainClasses;

import java.io.Serializable;
import java.util.SortedSet;
import pns.api.interfaces.ISteps;

/**
 *
 * @author Movement
 */
public class Limb implements Serializable, ISteps {

    protected SortedSet<Segment> segmentSetTop;
    protected SortedSet<Segment> segmentSetBottom;

    public Limb() {
    }

    public SortedSet<Segment> getSegmentSetTop() {
        return segmentSetTop;
    }

    public void setSegmentSetTop(SortedSet<Segment> segmentSetTop) {
        this.segmentSetTop = segmentSetTop;
    }

    public SortedSet<Segment> getSegmentSetBottom() {
        return segmentSetBottom;
    }

    public void setSegmentSetBottom(SortedSet<Segment> segmentSetBottom) {
        this.segmentSetBottom = segmentSetBottom;
    }

    @Override
    public void runSteps(int steps) throws InterruptedException {
//        segmentBottom.setLength(steps);
//        segmentTop.setLength(steps);
//        Thread tb = new Thread(segmentBottom, "Segment Bottom");
//        tb.start();
//        tb.join();
//        Thread tt = new Thread(segmentTop, "Segment Top");
//        tt.start();
//        tb.join();
    }

    @Override
    public String toString() {
        return "Limb{" + "segmentTop=" + segmentSetTop + "," + System.lineSeparator()
                + " segmentBottom=" + segmentSetBottom + '}';
    }

}
