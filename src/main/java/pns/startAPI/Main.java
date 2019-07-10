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
import pns.api.mainClasses.Segment;
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
        SortedSet<Segment> segmSet = ConvertorUtil.convertData(s);
        Map<String, SortedSet<Segment>> segmMap = SegmentSeparator.separate(segmSet);
        segmMap = FileCalculator.integrate(segmMap);
        //SetArrayUtil.setDisplay(segmMap);

    }

}
