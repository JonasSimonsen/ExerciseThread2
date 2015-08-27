package exercise3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class BackupThread extends Thread {

    private final List lines;
    boolean run = true;

    public BackupThread(List lines) {
        this.lines = lines;
    }

    @Override
    public void run() {
        String userDir = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
        try {
            while (run) {
                saveTXT(userDir, lines);
                sleep(15000);
                System.out.println("Autosaved to path: " + userDir);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(BackupThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean saveTXT(String userDir, List lines) {
        if (lines == null) {
            return false;
        }
        FileWriter writer;
        File file = new File(userDir + "/backup.txt");
        try {
            writer = new FileWriter(file, false);
            writer.write(lines.toString() + "\n");      //Each String object is written as a line in file.
            System.out.println(lines.size());
            System.out.println("Written to file");
            writer.close();                                 //Closing the file.
        } catch (IOException ex) {                          //Goes something wrong everything is send to system out.
            System.out.println("Could not save to file!");
            System.out.println(ex.toString());
            return false;                                   //Goes something wrong false is returned!
        }
        return true;
    }

}
