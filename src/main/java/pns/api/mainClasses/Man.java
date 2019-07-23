/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.mainClasses;

import java.io.Serializable;
import pns.api.mainClasses.boxies.ManBody;
import pns.api.mainClasses.boxies.ManHead;
import pns.api.mainClasses.boxies.SegmentBox;

/**
 *
 * @author Movement
 */
public class Man implements Serializable {

    private ManHead head;
    private ManBody body;
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

    public void setBody(ManBody body) {
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
