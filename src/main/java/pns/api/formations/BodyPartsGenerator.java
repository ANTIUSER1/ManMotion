/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.formations;

import java.util.Map;
import java.util.SortedSet;
import pns.api.fileimports.RecieverSegments;
import pns.api.mainClasses.Segment;
import pns.api.utils.SetArrayDisplayUtil;
import pns.api.utils.SizePositionUtils;

/**
 *
 * @author Movement
 */
public class BodyPartsGenerator {

    public static SortedSet<Segment> oneSegmGen(Map<String, SortedSet<Segment>> baseMap, int mapIndex, int segmIndex, int segmSize) {
        Map<String, SortedSet<Segment>> headMap = SetArrayDisplayUtil.search(baseMap, mapIndex);
        SortedSet<Segment> res = RecieverSegments.recieveSegmSetByKey(headMap, segmIndex);
        SizePositionUtils.settingLenToSegments(res, segmSize);
        return res;
    }
}
