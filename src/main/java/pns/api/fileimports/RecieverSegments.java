/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.fileimports;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import pns.api.converting.SegmentSeparator;
import pns.api.mainClasses.Segment;

/**
 *
 * @author Movement
 */
public class RecieverSegments {

    public static SortedSet<Segment> recieveSegmSetByKey(Map<String, SortedSet<Segment>> segmMap, String d0) {
        return segmMap.get(d0);
    }

    public static SortedSet<Segment> recieveSegmSetByKey(Map<String, SortedSet<Segment>> segmMap, int d0) {

        List<Map<String, SortedSet<Segment>>> listOfMaps = SegmentSeparator.separateToList(segmMap);
        if (d0 < 0 || d0 >= listOfMaps.size()) {
            return null;
        }

        Map<String, SortedSet<Segment>> m = listOfMaps.get(d0);

        int k = 0;

        for (String key : m.keySet()) {
            if (k == 0) {
                return m.get(key);
            }
            k++;
        }
        return null;

    }

}
