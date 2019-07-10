/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.fileimports;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import pns.api.mainClasses.Limb;
import pns.api.mainClasses.Segment;
import pns.api.utils.SizePositionUtils;

/**
 *
 * @author Movement
 */
public class LimbDataFormation {

    public static Limb generateLimb(String d0, String d1, double lenTop) {
        Limb limb = new Limb();
        return limb;
    }

    public static Limb generateLimb(Map<String, SortedSet<Segment>> segmMap, String d0, String d1, double lenTop, double lenBottom) {
        Limb limb = new Limb();
        SortedSet<Segment> segmSet0 = RecieverSegments.recieveSegmSetByKey(segmMap, d0);
        SizePositionUtils.settingLenToSegments(segmSet0, lenTop);

        SortedSet<Segment> segmSet1 = RecieverSegments.recieveSegmSetByKey(segmMap, d1);
        SizePositionUtils.settingLenToSegments(segmSet1, lenBottom);

        limb.setSegmentSetTop(segmSet0);
        limb.setSegmentSetBottom(segmSet1);
        return limb;
    }

    public static List<Limb> generateLimbList(Map<String, SortedSet<Segment>> segmMap,
            String d0, String d1, String d2, String d3,
            String d4, String d5, String d6, String d7,
            double sz0, double sz1, double sz2, double sz3,
            double sz4, double sz5, double sz6, double sz7
    ) {
        List<Limb> limbList = new ArrayList<>();
        Limb limb0 = generateLimb(segmMap, d0, d1, sz0, sz1);
        limbList.add(limb0);

        Limb limb1 = generateLimb(segmMap, d2, d3, sz2, sz3);
        limbList.add(limb1);

        Limb limb2 = generateLimb(segmMap, d4, d5, sz4, sz5);
        limbList.add(limb2);

        Limb limb3 = generateLimb(segmMap, d6, d7, sz6, sz7);
        limbList.add(limb3);

        return limbList;
    }

}
