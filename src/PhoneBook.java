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

public class PhoneBook {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String item, fullName, numPhone;
        String[][] dataBase = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
        boolean isExit = true;
        int indexRow;

        while (isExit) {
            System.out.println("\t\t\tМеню\t\t\t");
            System.out.println("1.\tДобавить запись");
            System.out.println("2.\tУдалить запись");
            System.out.println("3.\tПоказать данные телефонной книги");
            System.out.println("4.\tПоказать данные одной записи");
            System.out.println("5.\tВыйти из программы");
            item = stdin.nextLine();
            if (item.length() != 1) {
                System.out.println("Incorrect value entered");
                continue;
            }
            switch (item.charAt(0)) {
                case'1':
                    System.out.print("Введите ФИО>>>");
                    fullName = stdin.nextLine();
                    if (checkName(fullName)) {
                        fullName = formatFullName(fullName);
                        indexRow = checkMatch(fullName, dataBase, 0);
                        if (indexRow != -1) {
                            System.out.printf("Номер телефона по имени %s: %s",
                                    dataBase[indexRow][0], dataBase[indexRow][1]);
                        } else {
                            System.out.print("Введите номер телефона>>>");
                            numPhone = stdin.nextLine();
                            if (checkPhoneNumber(numPhone)) {
                                numPhone = formatPhoneNumber(numPhone);
                            } else {
                                System.out.println("Введен некорректный номер телефона");
                            }
                        }
                    } else {
                        System.out.println("Введено некорректное имя");
                    }
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
                    System.out.println("Show phonebook");
                    System.out.print("Press enter>>>");
                    stdin.nextLine();
                    break;
                    case'5':
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

    public static boolean checkName(String name) {
        return name.matches(
                "([A-Za-zА-Яа-я]+([-][A-Za-zА-Яа-я]+)?\\s+){2}[A-Za-zА-Яа-я]+([-][A-Za-zА-Яа-я]+)?\\s*");
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("[^0-9]*", "");
        System.out.println(phoneNumber);
        return phoneNumber.length() == 11;
    }

    public static int checkMatch(String str, String[][] Array, int column) {
        int index = -1;
        for (int i = 0; i < Array.length; i++) {
            if (str.equals(Array[i][column])) {
                index = i;
            }
        }
        return index;
    }

    public static String formatName(String name) {
        Pattern pattern = Pattern.compile("[A-ZА-Я]");
        Matcher match = pattern.matcher(name);
        String temp = name.substring(0, 1);
        if (!match.matches()) {
            temp = temp.toUpperCase();
        }
        name = name.toLowerCase();
        return name.replaceFirst(".", temp);
    }

    public static String formatFullName(String name) {
        Pattern pattern = Pattern.compile(".+[-].+");
        String[] partsOfWord;
        name = name.replaceAll("\\s+", " ");
        String[] words = name.split("\\s");
        Matcher match = pattern.matcher("");
        for (int i = 0; i < words.length; i++) {
            match.reset(words[i]);
            if (!match.matches()) {
                words[i] = formatName(words[i]);
            } else {
                partsOfWord = words[i].split("-");
                for (int j = 0; j < partsOfWord.length; j++) {
                    partsOfWord[j] = formatName(partsOfWord[j]);
                }
                words[i] = String.join("-", partsOfWord);
            }
        }
        return String.join(" ", words);
    }

    public static String formatPhoneNumber(String str) {
        String number = "+7 ";
        str = str.replaceAll("[^0-9]*", "");
        number += str.substring(1, 4) + " " + str.substring(4, 7) +
                " " + str.substring(7, 9) + " " + str.substring(9);
        return number;
    }

    public static void add(String[][] book, String name, String number) {
        //add logic
    }

    public static void list(String[][] book) {
        //print phone book
    }
}
