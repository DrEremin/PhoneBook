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
        String item, fullName, numPhone, service;
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
            System.out.print("Введите цифру от 1 до 5, соответствующую пункту меню>>>");
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
                            System.out.printf("Номер телефона по имени %s: %s\n",
                                    dataBase[indexRow][0], dataBase[indexRow][1]);
                        } else {
                            System.out.print("Введите номер телефона>>>");
                            numPhone = stdin.nextLine();
                            if (checkPhoneNumber(numPhone)) {
                                numPhone = formatPhoneNumber(numPhone);
                                dataBase = addRegister(fullName, numPhone, dataBase);
                            } else {
                                System.out.println("Введен некорректный номер телефона");
                            }
                        }
                    } else {
                        System.out.println("Введено некорректное имя");
                    }
                    System.out.print("Press enter>>>");
                    service = stdin.nextLine();
                    break;
                case'2':
                    System.out.println("Delete the person's data");
                    System.out.print("Press enter>>>");
                    service = stdin.nextLine();
                    break;
                case'3':
                    printPhoneBook(dataBase);
                    System.out.print("Press enter>>>");
                    service = stdin.nextLine();
                    break;
                case'4':
                    System.out.println("Show phonebook");
                    System.out.print("Press enter>>>");
                    service = stdin.nextLine();
                    break;
                case'5':
                    System.out.println("Exit the program");
                    System.out.print("Press the key Y(exit) " +
                            "or any another key(stay)>>>");
                    if (stdin.hasNext("[YyНн]")) {
                        isExit = false;
                    }
                        service = stdin.nextLine();
                    break;
                default:
                    System.out.println("Incorrect value entered");
            }
        }
    }

    public static boolean checkName(String name) {
        return name.matches(
                "([A-Za-zА-Яа-я]+([-][A-Za-zА-Яа-я]+)?\\s+){2}[A-Za-zА-Яа-я]+([-][A-Za-zА-Яа-я]+)?\\s*");
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("[^0-9]*", "");
        return (phoneNumber.length() == 11) && (phoneNumber.matches("^[7-8].*"));
    }

    public static int checkMatch(String str, String[][] array, int column) {
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (str.equals(array[i][column])) {
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
        String[] words;

        name = name.replaceAll("\\s+", " ");
        words = name.split("\\s");
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

    public static String[][] addRegister(String fullName,
                                         String phoneNumber, String[][] array) {
        int index = -1;
        String[][] newArray;

        for (int i = 0; i < array.length; i++) {
            if (array[i][0].length() == 0) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            array[index][0] = fullName;
            array[index][1] = phoneNumber;
            return array;
        } else {
            index = array.length;
            newArray = new String[index + 5][2];
            for (int i = 0; i < index; i++) {
                newArray[i][0] = array[i][0];
                newArray[i][1] = array[i][1];
            }
            newArray[index][0] = fullName;
            newArray[index][1] = phoneNumber;
            for (int i = index + 1; i < newArray.length; i++) {
                newArray[i][0] = "";
                newArray[i][1] = "";
            }
            return newArray;
        }
    }

    public static void printPhoneBook(String[][] book) {
        System.out.printf("\t%20s\t%26s\n", "-=Имя=-", "-=Телефон=-");
        for (int i = 0; i < book.length; i++) {
            if (book[i][0].length() > 0) {
                System.out.printf("%d. \t%-35s\t%-20s\n", i + 1, book[i][0], book[i][1]);
            }
        }
    }
}
