package com.company;

import java.time.LocalDate;

public class Familiar {
    int serialNumber;
    String FIO;
    int year;
    int month;
    int day;
    String address;
    String numberPhone;

    public Familiar(int serialNumber, String FIO, int year, int month, int day, String address, String numberPhone){
        this.setSerialNumber(serialNumber);
        this.setFIO(FIO);
        this.setYear(year);
        this.setMonth(month);
        this.setDay(day);
        this.setAddress(address);
        this.setNumberPhone(numberPhone);
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public String toString() {
        return
                "serialNumber=" + serialNumber +
                        ", FIO='" + FIO + '\'' +
                        ", Date of birthday=" + year +
                        "." + month +
                        "." + day +
                        ", address='" + address + '\'' +
                        ", numberPhone='" + numberPhone + '\'' + '\n';
    }
}
