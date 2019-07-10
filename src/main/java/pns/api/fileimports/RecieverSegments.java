/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.fileimports;

import java.util.Map;
import java.util.SortedSet;
import pns.api.mainClasses.Segment;

/**
 *
 * @author Movement
 */
public class RecieverSegments {

    public static SortedSet<Segment> recieveSegmSetByKey(Map<String, SortedSet<Segment>> segmMap, String d0) {
        return segmMap.get(d0);
    }

}
