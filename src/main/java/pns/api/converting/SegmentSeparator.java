/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.converting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import pns.api.mainClasses.Segment;
import pns.api.utils.SetArrayDisplayUtil;

/**
 *
 * @author Movement
 */
public class SegmentSeparator {

    public static Map<String, SortedSet<Segment>> separate(SortedSet<Segment> segmSet) {

        System.out.println("SEPARATOR");

        Map<String, SortedSet<Segment>> res = groupingSegmList(segmSet);

        return res;
    }

    private static Set<String> sgIDs(List<Segment> testSGList) {
        Set<String> res = new HashSet<>();
        for (int k = 0; k < testSGList.size(); k++) {
            res.add(testSGList.get(k).getId());
        }
        return res;
    }

    private static Map<String, SortedSet<Segment>> groupingSegmList(SortedSet<Segment> sgm) {
        Map<String, SortedSet<Segment>> res = new TreeMap<>();
        List<Segment> tmp = new ArrayList(sgm);
        Set<String> sgIdSet = sgIDs(tmp);
        List<String> sgList = new ArrayList<>(sgIdSet);

        for (int p = 0; p < tmp.size(); p++) {
            for (int ss = 0; ss < sgList.size(); ss++) {
                String id = sgList.get(ss);
                if (id.equals(tmp.get(p).getId())) {
                    SortedSet<Segment> sgmTmp = SetArrayDisplayUtil.search(sgm, id);
                    res.put(tmp.get(p).getId(), sgmTmp);
                    //       res.put(ss, sgmTmp);

                }
            }
        }

        return res;
    }

    public static List<Map<String, SortedSet<Segment>>> separateToList(Map<String, SortedSet<Segment>> segmMap) {
        if (segmMap == null) {
            return null;
        }
        int m = 0;
        List<Map<String, SortedSet<Segment>>> res = new ArrayList<>();

        for (Map.Entry<String, SortedSet<Segment>> entry : segmMap.entrySet()) {
            Map<String, SortedSet<Segment>> tmp = new TreeMap<>();
            tmp.put(entry.getKey(), entry.getValue());
            res.add(tmp);

        }
        return res;
    }

}