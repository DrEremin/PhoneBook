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
            System.out.println("4.\tВыйти из программы");
            System.out.print("Введите цифру от 1 до 4, соответствующую пункту меню>>>");
            item = stdin.nextLine();
            if (item.length() != 1) {
                System.out.println("Введено более одного символа");
                continue;
            }
            switch (item.charAt(0)) {
                case'1':
                    System.out.print("Введите ФИО или номер телефона>>>");
                    fullName = stdin.nextLine();
                    numPhone = fullName;
                    if (checkName(fullName)) {
                        fullName = formatFullName(fullName);
                        indexRow = checkMatch(fullName, dataBase, 0);
                        if (indexRow != -1) {
                            System.out.printf("По имени %s номер телефона : %s\n",
                                    dataBase[indexRow][0], dataBase[indexRow][1]);
                            System.out.print("Press enter>>>");
                            service = stdin.nextLine();
                        } else {
                            System.out.print("Введите номер телефона>>>");
                            numPhone = stdin.nextLine();
                            if (checkPhoneNumber(numPhone)) {
                                numPhone = formatPhoneNumber(numPhone);
                                indexRow = checkMatch(numPhone, dataBase, 1);
                                if (indexRow != -1) {
                                    System.out.printf("По номеру телефона %s имя: %s\n",
                                            dataBase[indexRow][1], dataBase[indexRow][0]);
                                    System.out.print("Press enter>>>");
                                    service = stdin.nextLine();
                                } else {
                                    dataBase = addRegister(fullName, numPhone, dataBase);
                                    sortingOfRegisters(dataBase);
                                }
                            } else {
                                System.out.println("Введен некорректный номер телефона");
                                System.out.print("Press enter>>>");
                                service = stdin.nextLine();
                            }
                        }
                    } else if (checkPhoneNumber(numPhone)) {
                        numPhone = formatPhoneNumber(numPhone);
                        indexRow = checkMatch(numPhone, dataBase, 1);
                        if (indexRow != -1) {
                            System.out.printf("По номеру телефона %s имя: %s\n",
                                    dataBase[indexRow][1], dataBase[indexRow][0]);
                        } else {
                            System.out.print("Введите ФИО>>>");
                            fullName = stdin.nextLine();
                            if (checkName(fullName)) {
                                fullName = formatFullName(fullName);
                                indexRow = checkMatch(fullName, dataBase, 0);
                                if (indexRow != -1) {
                                    System.out.printf("По имени %s номер телефона : %s\n",
                                            dataBase[indexRow][0], dataBase[indexRow][1]);
                                    System.out.print("Press enter>>>");
                                    service = stdin.nextLine();
                                } else {
                                    dataBase = addRegister(fullName, numPhone, dataBase);
                                    sortingOfRegisters(dataBase);
                                }
                            } else {
                                System.out.println("Введены некорректные ФИО");
                                System.out.print("Press enter>>>");
                                service = stdin.nextLine();
                            }
                        }
                    }
                    else {
                        System.out.println("Введены некорректные данные");
                        System.out.print("Press enter>>>");
                        service = stdin.nextLine();
                    }
                    break;
                case'2':
                    System.out.print("Введите ФИО или номер телефона>>>");
                    fullName = stdin.nextLine();
                    numPhone = fullName;
                    if (checkName(fullName)) {
                        fullName = formatFullName(fullName);
                        indexRow = checkMatch(fullName, dataBase, 0);
                        if (indexRow != -1) {
                            dataBase = delRegister(dataBase, indexRow);
                        } else {
                            System.out.println("Такой записи, в телефонной книге, нет");
                            System.out.print("Press enter>>>");
                            service = stdin.nextLine();
                        }
                    } else if (checkPhoneNumber(numPhone)) {
                        numPhone = formatPhoneNumber(numPhone);
                        indexRow = checkMatch(numPhone, dataBase, 1);
                        if (indexRow != -1) {
                            dataBase = delRegister(dataBase, indexRow);
                        } else {
                            System.out.println("Такой записи, в телефонной книге, нет");
                            System.out.print("Press enter>>>");
                            service = stdin.nextLine();
                        }
                    }
                    else {
                        System.out.println("Введены некорректные данные");
                        System.out.print("Press enter>>>");
                        service = stdin.nextLine();
                    }
                    break;
                case'3':
                    printPhoneBook(dataBase);
                    System.out.print("Press enter>>>");
                    service = stdin.nextLine();
                    break;
                case'4':
                    isExit = false;
                    break;
                default:
                    System.out.println("\nВыбор вне диапазона меню");
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

    public static String[][] delRegister(String[][] array, int index) {
        String[][] newArray;
        int end = array.length;
        int freeRows = 0;

        if ((index == end - 1) || (array[index + 1][0].length() == 0)) {
            array[index][0] = "";
            array[index][1] = "";
        } else {
            for (int i = index + 1; i < end; i++) {
                if (array[i - 1][0].length() == 0) {
                    break;
                }
                array[i - 1][0] = array[i][0];
                array[i - 1][1] = array[i][1];
            }
            if (array[end - 1][0].length() > 0) {
                array[end - 1][0] = "";
                array[end - 1][1] = "";
            }
        }
        for (int i = end - 1; i >= 0; i--) {
            if (array[i][0].length() == 0) {
                freeRows++;
            } else {
                break;
            }
        }
        if (freeRows > 5) {
            end -= (freeRows - 2);
            newArray = new String[end][2];
            for (int i = 0; i < end; i++) {
                newArray[i][0] = array[i][0];
                newArray[i][1] = array[i][1];
            }
            return newArray;
        } else {
            return array;
        }
    }

    public static void sortingOfRegisters(String[][] array) {
        int end = 0;
        String temp = "";

        for (int i = (array.length - 1); array[i][0].length() == 0; i--) {
            end++;
        }
        end = array.length - end;
        while (!temp.equals("1")) {
            temp = "1";
            for (int i = 0; i < end - 1; i++) {
                if (array[i][0].compareToIgnoreCase(array[i + 1][0]) > 0) {
                    for (int j = 0; j < 2; j++) {
                        temp = array[i][j];
                        array[i][j] = array[i + 1][j];
                        array[i + 1][j] = temp;
                    }
                }
            }
            end--;
        }
    }

    public static void printPhoneBook(String[][] book) {
        System.out.printf("\t%30s\t%36s\n", "*--=Имя=--*", "*--=Телефон=--*");
        for (int i = 0; i < book.length; i++) {
            if (book[i][0].length() > 0) {
                System.out.printf("%d. \t%-50s\t%-20s\n", i + 1, book[i][0], book[i][1]);
            }
        }
    }
}
