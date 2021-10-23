package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Familiars {
    ArrayList<Familiar> familiars;

    public Familiars(){
        this.familiars=new ArrayList<>();
    }

    void add(Familiar familiar){
        familiars.add(familiar);
    }



    void findMonth(){
        int counter1=0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер месяца, рожденных которых в этот месяц вы хотели бы увидеть:");
        int numberMonth = scan.nextInt();
        for (Familiar object : familiars) {
            if(object.getMonth() == numberMonth)
            {
                System.out.println(object);
                counter1++;
            }
        }
        if(counter1==0)
        {
            System.out.println("В указанном месяце нет родившихся знакомых");
        }
    }

    void existPhone() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Знакомые, имеющие телефон: ");
        for (Familiar object : familiars) {
            if(object.numberPhone != null){
                System.out.println(object);
            }
        }
    }

    void addNumber(Familiar familiar, int number){

        familiars.add(number,familiar);
        int size = familiars.size();
        for (int i = number; i < size; i++) {
            this.familiars.get(i).serialNumber=i+1;
        }
    }


    void findWithCodOperatore(){
        int counter2=0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите код оператора:");
        String codOperatora = "+38";
        codOperatora += scan.nextLine();
        for (Familiar object : familiars) {
            if(object.getNumberPhone()!=null){
                if(object.getNumberPhone().contains(codOperatora) ){
                    System.out.println(object);
                    counter2++;
                }
            }
        }
        if(counter2 ==0){
            System.out.println("Знакомых с указанным оператором нет");
        }
    }
    void saveFile(String fileWay) throws IOException {
        Save saveBase = new Save();
        saveBase.save(familiars,fileWay);
    }

    void loadFile(String fileWay) throws IOException {
        Load loadBase = new Load();
        loadBase.load(familiars , fileWay);
    }

    @Override
    public String toString() {
        return "Familiars{" +
                "familiars=\n" + familiars +
                '}';
    }
}
