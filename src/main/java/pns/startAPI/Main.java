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
import pns.api.formations.ManFormation;
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
        List<Map<String, SortedSet<Segment>>> listOfMapsSS = SegmentSeparator.separateToList(segmMap);
        /*
        // вытаскиваем сегменты из частей тела
        // сегмент body
        SortedSet<Segment> body = BodyPartsGenerator.oneSegmGen(segmMap, 1, 0, 50);
        SetArrayDisplayUtil.setDisplay(body);

        // сегмент head
        SortedSet<Segment> head = BodyPartsGenerator.oneSegmGen(segmMap, 0, 0, 5);
        SetArrayDisplayUtil.setDisplay(head);

        // структура limb-hand-R
        Limb limbHR = LimbDataFormation.generateLimb(segmMap, 2, 3, 15, 10);
        SetArrayDisplayUtil.setDisplay(limbHR);

        // структура limb-Hand-L
        Limb limbHL = LimbDataFormation.generateLimb(segmMap, 4, 5, 10, 20);
        SetArrayDisplayUtil.setDisplay(limbHL);

        // структура limb-leg-R
        Limb limbLR = LimbDataFormation.generateLimb(segmMap, 6, 7, 15, 10);
        SetArrayDisplayUtil.setDisplay(limbLR);

        // структура limb-leg-L
        Limb limbLL = LimbDataFormation.generateLimb(segmMap, 8, 9, 10, 20);
        SetArrayDisplayUtil.setDisplay(limbLL);

        // структура limb-leg-L
        Limb limb5 = LimbDataFormation.generateLimb(segmMap, 10, 11, 10, 20);
        SetArrayDisplayUtil.setDisplay(limb5);

        // структура limb-leg-L
        Limb limb6 = LimbDataFormation.generateLimb(segmMap, 12, 13, 10, 20);
        SetArrayDisplayUtil.setDisplay(limb6);
         */
        Man man = ManFormation.generateMan(segmMap);
        SetArrayDisplayUtil.setDisplay(man);

    }

}
