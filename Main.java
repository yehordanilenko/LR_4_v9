package com.company;


import java.util.Scanner;

public class Main {
    public static Familiars familiars = new Familiars();
    public static void main(String[] args) {
	familiars.add(new Familiar(1,"Petrov Ivan Ivanovich", 2003,12,12,"Balkovskaya 9, apart 15","+380500419660"));
    familiars.add(new Familiar(2,"Andreev Alexandr Sergeevich", 2001,10,2,"Serova 13, apart 5","+380668726372"));
    familiars.add(new Familiar(3,"Fedorov Andrey Igorevich", 2000,1,23,"Morozova 1, apart 23",null));
    familiars.add(new Familiar(4,"Petrov Sasha Petrovich", 1994,1,1,"Petrova 19","+380662207300"));
    //System.out.println(familiars);

    menuTask();

    }
    public static void menuTask() {
        Scanner scan = new Scanner(System.in);
        int number;
        do {
            System.out.println("1)Вывод информации о знакомых" +
                    "\n2)Выдача сведений о знакомых, родившихся в указанном месяце" +
                    "\n3)Выдача сведений о знакомых, имеющих телефон" +
                    "\n4)Добавление новой записи после записи с указанной фамилией" +
                    "\n5)Выдача сведений о знакомых с кодом телефона указанного оператора" +
                    "\n6)Завершение работы программы");
            System.out.print("Выберете пункт меню :");
            int taskNumber = scan.nextInt();
            while (true) {
                if (taskNumber <= 0 || taskNumber > 6) {
                    System.out.print("Выберете корректный пункт меню: ");
                    taskNumber = scan.nextInt();
                } else {
                    break;
                }
            }
            switch (taskNumber) {
                case 1:
                    System.out.println(familiars);
                    break;
                case 2:
                    familiars.findMonth();
                    break;
                case 3:
                    familiars.existPhone();
                    break;
                case 4:
                    System.out.println(familiars);
                    int newNumber;
                    do {
                        System.out.println("Введите номер, после которого хотели бы добавить нового знакомого");
                        newNumber = scan.nextInt();
                        scan.nextLine();
                    }while (newNumber<=0);
                    System.out.println("Введите ФИО пользователя");
                    String newFIO =scan.nextLine();
                    System.out.println("Введито год рождения");
                    int newYear = scan.nextInt();
                    System.out.println("Введито месяц рождения");
                    int newMonth = scan.nextInt();
                    System.out.println("Введито день рождения");
                    int newDay = scan.nextInt();;
                    scan.nextLine();
                    System.out.println("Введите домашний адрес пользователя");
                    String newAddress =scan.nextLine();
                    System.out.println("Имеет ли пользователь номер телефона? если да, ответьте 1, если нет, то ответьте 0 ");
                    int answer = scan.nextInt();
                    scan.nextLine();
                    String newNumberPhone;
                    if(answer == 1) {
                        System.out.println("Введите номер телефона пользователя");
                        newNumberPhone = scan.nextLine();
                    }
                    else
                    {
                        newNumberPhone = null;
                    }
                    familiars.addNumber(new Familiar(newNumber,newFIO,newYear,newMonth,newDay,newAddress,newNumberPhone),newNumber);

                    break;
                case 5:
                    familiars.findWithCodOperatore();
                    break;
            }
            number = taskNumber;
        }while (number!=6);


    }

}
