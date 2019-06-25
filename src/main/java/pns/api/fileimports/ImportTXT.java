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

    public ImportTXT() {
    }

    public ImportTXT(String fName) {
        fileName = fName;
        //file = new File(fName);
        fileActor = new FileActor(fName);
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

    public void readFile() {
        fileActor.fileRead();
        System.out.println("   fileActor.getFileContent()   " + fileActor.getFileContent());

    }
}
