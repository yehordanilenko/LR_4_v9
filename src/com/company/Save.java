package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Save {
    public void save(ArrayList<Familiar> familiars , String fileWay) throws IOException {
        FileWriter outStream = new FileWriter(fileWay);
        BufferedWriter bw = new BufferedWriter(outStream);
        for (Familiar object : familiars) {
            try {
                bw.write(String.valueOf(object.getSerialNumber()));
                bw.write(System.lineSeparator());
                bw.write(object.getFIO());
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(object.getYear()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(object.getMonth()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(object.getDay()));
                bw.write(System.lineSeparator());
                bw.write(object.getAddress());
                bw.write(System.lineSeparator());
                bw.write(object.getNumberPhone());
                bw.write(System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bw.close();
        outStream.close();
    }
}
