package pns.startAPI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import pns.api.converting.SegmentSeparator;
import pns.api.fileimports.ConvertorUtil;
import pns.api.fileimports.FileCalculator;
import pns.api.fileimports.ImportTXT;
import pns.api.fileimports.ManFormation;
import pns.api.fileimports.RecieverSegments;
import pns.api.mainClasses.Man;
import pns.api.mainClasses.Segment;
import pns.api.mainClasses.boxies.SimpleSegmentContainer;
import pns.api.utils.SetArrayDisplayUtil;
import pns.fileUtils.FileBinActor;

public class Main {

    private static String fileName = "c:/segmData/";
    private static List<Segment> segmentList = new ArrayList<>();

    public static void main(String[] args) {
        Segment segment;
        System.out.println(" ++++++++++++++  " + new Date());
        if (args.length == 1) {
            ImportTXT importTXT = ImportTXT.getInstance();
            importTXT.setFileName(args[0]);
            String s = importTXT.readFile();
            convertNew(s);
        } else {
            System.out.println(" Minimum 1 parameters expeted. Given only  " + args.length);
        }
    }

    private static void fileMake(String pref, Serializable obj) {
//        try {
//            Thread.currentThread().join();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        long te = System.currentTimeMillis();
        fileName = "c:/segmData/";
        fileName += pns.utils.dateTimeMechanism.convertLongToDateStr(te, "ddMMYY/HH/") + pref;
        fileName += te + ".dat";
        FileBinActor fa = new FileBinActor();
        System.out.println("---------------ffff  " + fileName);
        fa.writeFile(fileName, obj);
        // System.out.println(" limb " + obj);
    }

    private static void convertNew(String s) {

        SortedSet<Segment> segmSet = ConvertorUtil.convertData(s, 300.3);
        SimpleSegmentContainer ssc = new SimpleSegmentContainer();
        ssc.setSegment(segmSet);
        Map<String, SortedSet<Segment>> segmMap = SegmentSeparator.separate(segmSet);
        segmMap = FileCalculator.integrate(segmMap);

        SortedSet<Segment> segmSetD = RecieverSegments.recieveSegmSetByKey(segmMap, "D1");

        SortedSet<Segment> body = SetArrayDisplayUtil.search(segmSet, "D1");
        SetArrayDisplayUtil.setDisplay(body);

        SortedSet<Segment> head = SetArrayDisplayUtil.search(segmSet, "D0");
        SetArrayDisplayUtil.setDisplay(head);

        Man man = ManFormation.generateMan(segmMap, body, head);
        SetArrayDisplayUtil.setDisplay(man);

    }

}
