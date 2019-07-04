package pns.startAPI;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pns.api.exeptions.SegmentExeption;
import pns.api.fileimports.ConvertingToSegment;
import pns.api.fileimports.ImportTXT;
import pns.api.mainClasses.Limb;
import pns.api.mainClasses.Man;
import pns.api.mainClasses.Segment;
import pns.fileUtils.FileBinActor;

public class Main {

    private static String fileName = "c:/segmData/";
    private static List<Segment> segmentList = new ArrayList<>();

    public static void main(String[] args) {
        Segment segment;

        System.out.println(" ++++++++++++++  " + new Date());
        if (args.length == 1) {

            ImportTXT importTXT = new ImportTXT(args[0]);
            String s = importTXT.readFile();
            System.out.println(" s= " + s);
            convertNew(s);
        } else {
            System.out.println(" Minimum 1 parameters expeted. Given only  " + args.length);
        }
//        segmentOperations(args);
//        limbOperation(args);
//        manOperation(args);
    }

    private static void segmentOperations(String[] args) {
        long ts = System.currentTimeMillis();

        Segment segment = new Segment();
        segment.setSize(20);
        if (args.length == 1) {
            try {
                int sz = pns.utils.ParserStr.parseInt(args[0]);
                segment.setSize(sz);
            } catch (ParseException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Thread t = new Thread(segment, "Segment");
            t.start();
            t.join();
        } catch (InterruptedException ex) {
            //    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        long te = System.currentTimeMillis();
        fileMake("segm", segment);
//        fileName = "c:/segmData/";
//        fileName += pns.utils.dateTimeMechanism.convertLongToDateStr(te, "ddMMYY/HH/") + "segm";
//        fileName += te + ".dat";
//        FileBinActor fa = new FileBinActor();
//        fa.writeFile(fileName, segment);
//        Segment ss = (Segment) fa.readBinFile(fileName);
//        System.out.println(ss);
//        //System.out.println("  size:  " + segment.getPoint9TreeSet().size() + "  time: " + (te - ts) + " ms");
//
//        System.out.println(segment + System.lineSeparator() + " fileName=" + fileName);
    }

    private static void limbOperation(String[] args) {
        Limb limb = new Limb();
        if (args.length == 1) {
            try {
                int sz = pns.utils.ParserStr.parseInt(args[0]);
                try {

                    limb.runSteps(sz);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ParseException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fileMake("limb", limb);
    }

    private static void manOperation(String[] args) {
        Man man = new Man();
        if (args.length == 1) {
            try {
                int sz = pns.utils.ParserStr.parseInt(args[0]);
                try {

                    man.runSteps(sz);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ParseException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fileMake("man", man);
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

    private static void convert(String s) {
        Segment segment = new Segment();
        ConvertingToSegment cts = new ConvertingToSegment();
        segment = cts.convert(s, true);

        double sm;
        try {
            sm = segment.calcData();
            System.out.println(segment + "  " + sm + "  " + System.lineSeparator() + "  " + System.lineSeparator() + "  ");;
        } catch (SegmentExeption ex) {
            //    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void convertNew(String s) {
        Segment segment = new Segment();
        ConvertingToSegment cts = new ConvertingToSegment();
        List<List<Segment>> segmentList = cts.convertNEW(s);
    }

}
