/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.formations;

import java.util.Map;
import java.util.SortedSet;
import pns.api.mainClasses.Limb;
import pns.api.mainClasses.Man;
import pns.api.mainClasses.Segment;
import pns.api.mainClasses.boxies.ManBody;
import pns.api.mainClasses.boxies.ManHead;

/**
 *
 * @author Movement
 */
public class ManFormation {

    public Man generateMan(Map<String, SortedSet<Segment>> segmMap, SortedSet<Segment> body, SortedSet<Segment> head) {

        Limb LeftHand = LimbDataFormation.generateLimb(segmMap, "D2", "D3", 200.4, 150.22);
        Limb RightHand = LimbDataFormation.generateLimb(segmMap, "D4", "D5", 200.4, 150.22);
        Limb LeftLeg = LimbDataFormation.generateLimb(segmMap, "D6", "D7", 20.4, 50.22);
        Limb RightLeg = LimbDataFormation.generateLimb(segmMap, "D8", "D9", 20.4, 50.22);
        ManBody manBody = new ManBody();
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

    public static Man generateMan(Map<String, SortedSet<Segment>> segmMap) {

        if (segmMap.size() == 0) {
            return null;
        }
// вытаскиваем сегменты из частей тела
        // сегмент body
        SortedSet<Segment> body = BodyPartsGenerator.oneSegmGen(segmMap, 1, 0, 50);

        // сегмент head
        SortedSet<Segment> head = BodyPartsGenerator.oneSegmGen(segmMap, 0, 0, 5);

        // структура limb-hand-R
        Limb handR = LimbDataFormation.generateLimb(segmMap, 2, 3, 15, 10);

        // структура limb-Hand-L
        Limb handL = LimbDataFormation.generateLimb(segmMap, 4, 5, 10, 20);

        // структура limb-leg-R
        Limb legR = LimbDataFormation.generateLimb(segmMap, 6, 7, 15, 10);

        // структура limb-leg-L
        Limb legL = LimbDataFormation.generateLimb(segmMap, 8, 9, 10, 20);

        // структура limb-leg-5
        Limb limb5 = LimbDataFormation.generateLimb(segmMap, 10, 11, 10, 20);

        // структура limb-leg-6
        Limb limb6 = LimbDataFormation.generateLimb(segmMap, 12, 13, 10, 20);

        ManBody manBody = new ManBody();
        ManHead manHead = new ManHead();
        manBody.setSegment(body);
        manHead.setSegment(head);
        Man man = new Man();

        man.setHead(manHead);
        man.setBody(manBody);
        man.setHandLeft(handL);
        man.setHandRight(handR);
        man.setLegLeft(legL);
        man.setLegRight(legR);
        return man;
    }

}
