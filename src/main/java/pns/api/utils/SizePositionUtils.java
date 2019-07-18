/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import pns.api.mainClasses.Segment;

/**
 *
 * @author Movement
 */
public class SizePositionUtils {

    public static void settingLenToSegments(SortedSet<Segment> segmSet, double len) {
        if (segmSet != null) {
            for (Segment sg : segmSet) {
                sg.setLength(len);
            }
        }
    }

    public static List<Segment> settolist(SortedSet<Segment> segmSet) {
        List<Segment> res = new ArrayList<>();
        for (Segment sg : segmSet) {
            res.add(sg);
        }
        return res;
    }
}
