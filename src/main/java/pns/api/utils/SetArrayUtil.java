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
import pns.api.mainClasses.Segment;

/**
 *
 * @author Movement
 */
public class SetArrayUtil {

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
            System.out.println(k + "    :::   Id=" + sgList.get(k).getId() + "   Moment=" + sgList.get(k).getMoment() + "   X1=" + sgList.get(k).getFixedPoint().getX1());
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

}
