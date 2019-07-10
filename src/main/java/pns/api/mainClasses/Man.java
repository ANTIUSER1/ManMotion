/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.mainClasses;

import pns.api.mainClasses.boxies.ManHead;
import pns.api.mainClasses.boxies.SegmentBox;
import java.io.Serializable;

/**
 *
 * @author Movement
 */
public class Man implements Serializable {

    private ManHead head;
    private SegmentBox body;
    private Limb handRight;
    private Limb handLeft;
    private Limb legRight;
    private Limb legLeft;

    public ManHead getHead() {
        return head;
    }

    public void setHead(ManHead head) {
        this.head = head;
    }

    public SegmentBox getBody() {
        return body;
    }

    public void setBody(SegmentBox body) {
        this.body = body;
    }

    public Limb getHandRight() {
        return handRight;
    }

    public void setHandRight(Limb handRight) {
        this.handRight = handRight;
    }

    public Limb getHandLeft() {
        return handLeft;
    }

    public void setHandLeft(Limb handLeft) {
        this.handLeft = handLeft;
    }

    public Limb getLegRight() {
        return legRight;
    }

    public void setLegRight(Limb legRight) {
        this.legRight = legRight;
    }

    public Limb getLegLeft() {
        return legLeft;
    }

    public void setLegLeft(Limb legLeft) {
        this.legLeft = legLeft;
    }
//
//    public void runSteps(int steps) throws InterruptedException {
////        head.setLength(steps);
////        int k = 0;
////        for (Map.Entry<String, Limb> entry : mapLimb.entrySet()) {
////            Limb limb = entry.getValue();
////            limb.getSegmentBottom().generatePointSet();
////            limb.getSegmentTop().generatePointSet();
////            limb.getSegmentBottom().setLength(steps);
////            limb.getSegmentTop().setLength(steps);
////            Thread tb = new Thread(limb.getSegmentBottom(), "Limb Segment Bottom " + k);
////            tb.start();
////            tb.join();
////            Thread tt = new Thread(limb.getSegmentTop(), "Limb Segment Top " + k);
////            tt.start();
////            tb.join();
////            System.out.println("");
////            tb.join();
////            System.out.println("");
////            tb.join();
////
////            k++;
////        }
//}

    @Override
    public String toString() {
        return "Man{" + "head=" + head + ","
                + " body=" + body + ","
                + " handRight=" + handRight + ","
                + " handLeft=" + handLeft + ","
                + " legRight=" + legRight + ","
                + " legLeft=" + legLeft + '}';
    }

}
