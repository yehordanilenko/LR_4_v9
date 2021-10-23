package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Load {
    public void load(ArrayList<Familiar> familiars , String fileWay) throws IOException {
        familiars.clear();
        try {
            Scanner scan = new Scanner(new FileReader(fileWay));
            int serialNumber;
            String FIO;
            int year;
            int month;
            int day;
            String address;
            String numberPhone;
            while (scan.hasNextLine()) {
                serialNumber = Integer.valueOf(scan.nextLine());
                FIO = scan.nextLine();
                year = Integer.valueOf(scan.nextLine());
                month = Integer.valueOf(scan.nextLine());
                day = Integer.valueOf(scan.nextLine());
                address = scan.nextLine();
                numberPhone = scan.nextLine();
                familiars.add(new Familiar(serialNumber, FIO, year, month, day, address, numberPhone));
            }
            scan.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
