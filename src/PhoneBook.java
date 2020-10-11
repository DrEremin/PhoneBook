/*
 * Classname: PhoneBook
 *
 * Version:
 *
 * Date: 09.10.2020
 *
 * Autor: Ivan Eremin
 */

import java.util.Scanner;
import java.util.regex.*;

public class   ть   PhoneBook {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String item;
        boolean isExit = true;
        while (isExit) {
            System.out.println("\t\t\tMenu\t\t\t");
            System.out.println("1.\tAdd the person's data");
            System.out.println("2.\tDelete the person's data");
            System.out.println("3.\tShow phonebook");
            System.out.println("4.\tExit the program");
            item = stdin.nextLine();
            if (item.length() != 1) {
                System.out.println("Incorrect value entered");
                continue;
            }
            switch (item.charAt(0)) {
                case'1':
                    System.out.println("Add the person's data");
                    System.out.print("Press enter>>>");
                    stdin.nextLine();
                    break;
                case'2':
                    System.out.println("Delete the person's data");
                    System.out.print("Press enter>>>");
                    stdin.nextLine();
                    break;
                case'3':
                    System.out.println("Show phonebook");
                    System.out.print("Press enter>>>");
                    stdin.nextLine();
                    break;
                case'4':
                    System.out.println("Exit the program");
                    System.out.print("Press the key Y(exit) " +
                            "or any another key(stay)>>>");
                    if (stdin.hasNext("[Yy]")) {
                        isExit = false;
                    }
                    stdin.nextLine();
                    break;
                default:
                    System.out.println("Incorrect value entered");
            }
        }
        //Добавить считывание ввода пользователя в цикле123
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        return true;
    }

    public static boolean checkName(String name) {
        return true;
    }

    public static String formatName(String name) {
        return "";
    }

    public static String formatPhoneNumber(String number) {
        return "";
    }

    public static void add(String[][] book, String name, String number) {
        //add logic
    }

    public static void list(String[][] book) {
        //print phone book
    }
}
