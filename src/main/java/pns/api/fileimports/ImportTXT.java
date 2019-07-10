/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.fileimports;

import pns.fileUtils.FileActor;

/**
 *
 * @author Movement
 */
public class ImportTXT {

    private String fileName = "";
    //private File file;
    private FileActor fileActor;

    private static ImportTXT instance;

    public static ImportTXT getInstance() {
        if (instance == null) {
            synchronized (ImportTXT.class) {
                if (instance == null) {
                    instance = new ImportTXT();
                }
            }
        }
        return instance;
    }

    private ImportTXT() {
    }

    public String getFileName() {
        return fileName;
    }

    public FileActor getFileActor() {
        return fileActor;
    }

    public void setFileName(String fName) {
        fileName = fName;
        fileActor = new FileActor(fName);

    }

    public String readFile() {
        fileActor.fileRead();
        String res = fileActor.getFileContent().trim();

        res = res.replaceAll(" +}", " ");
        res = res.replaceAll(" +\\{ ", "\\{");
        res = res.replaceAll("} +", "}  ");
        res = res.replaceAll("\\{ +", "\\{");
        res = res.replaceAll("; +", ";");
        res = res.replaceAll(" +;", ";");
        res = res.replaceAll(" +", " ");
        return res;
    }

}
