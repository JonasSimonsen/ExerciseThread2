package exercise1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jonassimonsen
 */
public class ThreadClass extends Thread {

    private final String url;
    int size = 0;

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public ThreadClass(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        byte[] sizeArr;

        sizeArr = getBytesFromUrl(url);
        for (int i = 0; i < sizeArr.length; i++) {
            size += sizeArr[i];
        }
        setSize(size);
    }

    protected byte[] getBytesFromUrl(String url) {
        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        try {
            InputStream is = new URL(url).openStream();
            byte[] bytebuff = new byte[4096];
            int read;
            while ((read = is.read(bytebuff)) > 0) {
                bis.write(bytebuff, 0, read);
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }

        return bis.toByteArray();
    }
}