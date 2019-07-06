/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.mainClasses;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import pns.api.interfaces.ISteps;

/**
 *
 * @author Movement
 */
public class Man implements Serializable, ISteps {

    private Head head = new Head();

    private Map<String, Limb> mapLimb = new HashMap<String, Limb>();

    public Man() {
        head.setLength(100 * Math.random());
        mapLimb.put("Left hand", new Limb());
        mapLimb.put("Right hand", new Limb());
        mapLimb.put("Left Leg", new Limb());
        mapLimb.put("Right Leg", new Limb());
    }

    public void runSteps(int steps) throws InterruptedException {
        head.setLength(steps);
        int k = 0;
        for (Map.Entry<String, Limb> entry : mapLimb.entrySet()) {
            Limb limb = entry.getValue();
            limb.getSegmentBottom().generatePointSet();
            limb.getSegmentTop().generatePointSet();
            limb.getSegmentBottom().setLength(steps);
            limb.getSegmentTop().setLength(steps);
            Thread tb = new Thread(limb.getSegmentBottom(), "Limb Segment Bottom " + k);
            tb.start();
            tb.join();
            Thread tt = new Thread(limb.getSegmentTop(), "Limb Segment Top " + k);
            tt.start();
            tb.join();
            System.out.println("");
            tb.join();
            System.out.println("");
            tb.join();

            k++;
        }
    }

    @Override
    public String toString() {
        return "Man{" + "head=" + head + "," + System.lineSeparator()
                + " mapLimb=" + System.lineSeparator() + mapLimb + System.lineSeparator() + '}' + System.lineSeparator() + " " + System.lineSeparator();
    }

}
