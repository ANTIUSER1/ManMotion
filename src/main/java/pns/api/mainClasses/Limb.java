/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.mainClasses;

import java.io.Serializable;

/**
 *
 * @author Movement
 */
public class Limb implements Serializable, ISteps {

    private Segment segmentTop;
    private Segment segmentBottom;

    public Limb() {
        segmentBottom = new Segment();
        segmentTop = new Segment();
    }

    public Segment getSegmentTop() {
        return segmentTop;
    }

    public Segment getSegmentBottom() {
        return segmentBottom;
    }

    @Override
    public void runSteps(int steps) throws InterruptedException {
        segmentBottom.setSize(steps);
        segmentTop.setSize(steps);
        Thread tb = new Thread(segmentBottom, "Segment Bottom");
        tb.start();
        tb.join();
        Thread tt = new Thread(segmentTop, "Segment Top");
        tt.start();
        tb.join();
    }

    @Override
    public String toString() {
        return "Limb{" + "segmentTop=" + segmentTop + "," + System.lineSeparator()
                + " segmentBottom=" + segmentBottom + '}';
    }

}
