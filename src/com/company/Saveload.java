package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class Saveload {
    private static FileOutputStream outFile;
    private static FileInputStream inFile;
    public void save(ArrayList<Familiar> familiars , String fileWay) throws IOException {

        byte[] bytesToWrite;
        byte[] SeralNumber,FIO,year,month,day,address,numberPhone,razd;
        String razdelitel = ".";
        for (Familiar object : familiars) {

                String s1 =Integer.toBinaryString(object.getSerialNumber());
                SeralNumber=s1.getBytes(StandardCharsets.UTF_8);
                FIO = object.getFIO().getBytes(StandardCharsets.UTF_8);
                String s3 = Integer.toBinaryString(object.getYear());
                year = s3.getBytes(StandardCharsets.UTF_8);
                String s4 = Integer.toBinaryString(object.getMonth());
                month = s4.getBytes(StandardCharsets.UTF_8);
                String s5 = Integer.toBinaryString(object.getDay());
                day = s5.getBytes(StandardCharsets.UTF_8);
                address = object.getAddress().getBytes(StandardCharsets.UTF_8);
                numberPhone = object.getNumberPhone().getBytes(StandardCharsets.UTF_8);
                razd = razdelitel.getBytes(StandardCharsets.UTF_8);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
                outputStream.write( SeralNumber );
                outputStream.write( razd );
                outputStream.write( FIO );
                outputStream.write( razd );
                outputStream.write( year );
                outputStream.write( razd );
                outputStream.write( month );
                outputStream.write( razd );
                outputStream.write( day );
                outputStream.write( razd );
                outputStream.write( address );
                outputStream.write( razd );
                outputStream.write( numberPhone );
                outputStream.write( razd );
                bytesToWrite = outputStream.toByteArray( );
                outFile = null;
                boolean isOpened = false;
            try {
                outFile = new FileOutputStream(fileWay, true);
                isOpened = true;
                outFile.write(bytesToWrite); //запись в файл
            } catch (FileNotFoundException e) {
                System.out.println("Невозможно произвести запись в файл:" + fileWay);
            } catch (IOException e) {
                System.out.println("Ошибка ввода/вывода:" + e);
            }
            if (isOpened) {
                outFile.close();
            }

        }

    }

    public void load(ArrayList<Familiar> familiars , String fileWay) throws IOException {
        familiars.clear();
        byte[] wert=new byte[0];
        int amount=0;
        try {

            inFile = new FileInputStream(fileWay);
            int bytesAvailable = inFile.available(); //сколько можно считать
            System.out.println("Available: " + bytesAvailable);

            byte[] bytesReaded = new byte[bytesAvailable]; //куда считываем
            int count = inFile.read(bytesReaded, 0, bytesAvailable);

            System.out.println("Было считано байт: " + count);
            System.out.println(Arrays.toString(bytesReaded));
            byte[] trap = bytesReaded;
            wert=trap;
            amount = count;
                inFile.close();

        }catch (FileNotFoundException e) {
            System.out.println("Невозможно произвести чтение из файла:" + fileWay);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода:" + e);
        }
        byte[] dannie=wert;
        int serialNumber=0;
        String FIO = "";
        int year=0;
        int month=0;
        int day=0;
        String address ="";
        String numberPhone ="";
        String num="";
        String y1="",m1="",d1="";
        int q = 0;
        for (int i = 0; i < amount; i++) {

            for (i = q; i < amount; i++) {
                if (dannie[i] == 46) {
                    q = i+1;
                    break;
                }
                byte[] ab = new byte[1];
                ab[0] = dannie[i];
                String str = new String(ab, "UTF-8");
                num = num + str;
                serialNumber = Integer.parseInt(num, 2);
            }

            for (i = q; i < amount; i++) {
                if (dannie[i] == 46) {
                    q = i+1;
                    break;
                }
                byte[] ab = new byte[1];
                ab[0] = dannie[i];
                String str = new String(ab, "UTF-8");
                FIO = FIO + str;
            }
            for (i = q; i < amount; i++) {
                if (dannie[i] == 46) {
                    q = i+1;
                    break;
                }
                byte[] ab = new byte[1];
                ab[0] = dannie[i];
                String str = new String(ab, "UTF-8");
                y1 = y1 + str;
                year = Integer.parseInt(y1, 2);
            }
            for (i = q; i < amount; i++) {
                if (dannie[i] == 46) {
                    q = i+1;
                    break;
                }
                byte[] ab = new byte[1];
                ab[0] = dannie[i];
                String str = new String(ab, "UTF-8");
                m1 = m1 + str;
                month = Integer.parseInt(m1, 2);
            }
            for (i = q; i < amount; i++) {
                if (dannie[i] == 46) {
                    q = i+1;
                    break;
                }
                byte[] ab = new byte[1];
                ab[0] = dannie[i];
                String str = new String(ab, "UTF-8");
                d1 = d1 + str;
                day = Integer.parseInt(d1, 2);
            }

            for (i = q; i < amount; i++) {
                if (dannie[i] == 46) {
                    q = i+1;
                    break;
                }
                byte[] ab = new byte[1];
                ab[0] = dannie[i];
                String str = new String(ab, "UTF-8");
                address = address + str;

            }
            for (i = q; i < amount; i++) {
                if (dannie[i] == 46) {
                    q = i+1;
                    break;
                }
                byte[] ab = new byte[1];
                ab[0] = dannie[i];
                String str = new String(ab, "UTF-8");
                numberPhone = numberPhone + str;
            }
            i-=1;
            if(i==amount-1)
            {
                break;
            }
            familiars.add(new Familiar(serialNumber, FIO, year, month, day, address, numberPhone));

            serialNumber=0;
            FIO = "";
            year=0;
            month=0;
            day=0;
            address ="";
            numberPhone ="";
            num="";
            y1="";
            m1="";
            d1="";
        }

    }
}
