/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonassimonsen
 */
public class FileSaverThread extends Thread {

    List<String> list;

    public FileSaverThread(List<String> lines) {
        list = lines;
    }

    @Override
    public void run() {
        while (true) {

            try {
                FileSaverThread.sleep(1500);

            } catch (InterruptedException ex) {
                Logger.getLogger(FileSaverThread.class.getName()).log(Level.SEVERE, null, ex);

            }

            try {
                FileWriter writer = new FileWriter("backup.txt", false);
                PrintWriter out = new PrintWriter(writer);

                for (String lines : list) {
                    out.println(lines);
                }
                out.close();
            } catch (IOException iOException) {

            }

        }
    }
}
