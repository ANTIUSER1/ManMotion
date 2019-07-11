/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import pns.api.converting.SegmentSeparator;
import pns.api.mainClasses.Limb;
import pns.api.mainClasses.Man;
import pns.api.mainClasses.Segment;

/**
 *
 * @author Movement
 */
public class SetArrayDisplayUtil {

    public static void setDisplay(SortedSet<Segment> data) {
        if (data == null) {
            System.out.println("null");
            return;
        }
        List<Segment> sgList = new ArrayList<>();

        for (Segment sg : data) {
            sgList.add(sg);
        }
        for (int k = 0; k < sgList.size(); k++) {
            System.out.println(k + "    :::   Id=" + sgList.get(k).getId() + " length=" + sgList.get(k).getLength()
                    + "   Moment=" + sgList.get(k).getMoment() + "   X1=" + sgList.get(k).getFixedPoint().getX1());
        }
        System.out.println("         total  " + data.size() + " items in " + data.getClass().getCanonicalName());
    }

    public static void setDisplay(Map<String, SortedSet<Segment>> data) {
        if (data == null) {
            System.out.println("null");
            return;
        }
        int m = 0;
        for (Map.Entry<String, SortedSet<Segment>> entry : data.entrySet()) {
            System.out.println(m + "  -- " + entry.getKey() + "  ");
            setDisplay(entry.getValue());
            m++;
        }
        System.out.println("             total  " + data.size() + " items in " + data.getClass().getCanonicalName());
    }

    public static void setDisplay(Man data) {
        System.out.println("Display Man");

        System.out.println("         Head   ");
        setDisplay(data.getHead().getSegment());

        System.out.println("         Body   ");
        setDisplay(data.getBody().getSegment());

        System.out.println("         Left Hand   ");
        setDisplay(data.getHandLeft());

        System.out.println("         Right Hand   ");
        setDisplay(data.getHandRight());

        System.out.println("         Left Leg   ");
        setDisplay(data.getLegLeft());

        System.out.println("         Right Leg   ");
        setDisplay(data.getLegRight());

    }

    public static void setDisplay(List<Limb> data) {

        int k = 0;
        for (Limb limb : data) {
            System.out.println("Limb  No  " + k);
            setDisplay(limb);
            k++;
        }
    }

    public static void setDisplay(Limb data) {
        System.out.println(" Top ");
        if (data != null) {
            if (data.getSegmentSetTop() != null) {
                setDisplay(data.getSegmentSetTop());
            } else {
                System.out.println("null");
            }
            System.out.println("Bottom");
            if (data.getSegmentSetBottom() != null) {
                setDisplay(data.getSegmentSetBottom());
            } else {
                System.out.println("null");
            }
        }
    }

    public static SortedSet<Segment> search(SortedSet<Segment> sgm, String needle) {
        SortedSet<Segment> res = new TreeSet<>();
        List<Segment> resList = new ArrayList<>(sgm);

        for (int k = 0; k < resList.size(); k++) {
            Segment sg = resList.get(k);

            if (sg.getId().equals(needle)) {
                res.add(sg);
            }
        }

        return res;
    }

    public static SortedSet<Segment> search(SortedSet<Segment> segmSet, int i) {
        return null;
    }

    public static Map<String, SortedSet<Segment>> search(Map<String, SortedSet<Segment>> segmMap, int i) {
        if (i < 0) {
            return null;
        }
        List<Map<String, SortedSet<Segment>>> listOfMaps = SegmentSeparator.separateToList(segmMap);
        return listOfMaps.get(i);

    }

}
