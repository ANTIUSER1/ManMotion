/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.fileimports;

import java.util.Map;
import java.util.SortedSet;
import pns.api.mainClasses.Limb;
import pns.api.mainClasses.Man;
import pns.api.mainClasses.ManHead;
import pns.api.mainClasses.Segment;
import pns.api.mainClasses.SegmentBox;

/**
 *
 * @author Movement
 */
public class ManFormation {

    public static Man generateMan(Map<String, SortedSet<Segment>> segmMap, SortedSet<Segment> body, SortedSet<Segment> head) {

        Limb LeftHand = LimbDataFormation.generateLimb(segmMap, "D2", "D3", 200.4, 150.22);
        Limb RightHand = LimbDataFormation.generateLimb(segmMap, "D4", "D5", 200.4, 150.22);
        Limb LeftLeg = LimbDataFormation.generateLimb(segmMap, "D6", "D7", 20.4, 50.22);
        Limb RightLeg = LimbDataFormation.generateLimb(segmMap, "D8", "D9", 20.4, 50.22);
        SegmentBox manBody = new SegmentBox();
        ManHead manHead = new ManHead();
        manBody.setSegment(body);
        manHead.setSegment(head);
        Man man = new Man();

        man.setHead(manHead);
        man.setBody(manBody);
        man.setHandLeft(LeftHand);
        man.setHandRight(RightHand);
        man.setLegLeft(LeftLeg);
        man.setLegRight(RightLeg);
        return man;
    }

}
