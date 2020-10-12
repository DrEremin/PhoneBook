# Phone Book
**Phone Book** is console application with simple database. It lets to keep full-<br/>
names of people and their phone numbers. Its apllication also lets to show<br/> 
database or separate entries on display and to input data in database.
## Features of use
For the input of fullname use three words (last name, first name, middle name)<br>
wich may consist of Latin or Cyrillic letters. Using a hyphen permissible too,<br/>
but only in a middle of words. A number of phone must include 11 digits.<br/>
Herewith the format may be any.
## Methods of class PhoneBook:
#### public static boolean checkName(String):
Takes String, return true or false  depending on match of String with regex.<br/>
The string must contain three words with Latin or Cyrillic letters. Using a<br/>
hyphen permissible too, but only in a middle of words.
#### public static boolean checkPhoneNumber(String):
This method checks the correctness of entering the phone number. The criterion: <br/>
presence of 11 digits in the entered line.
#### public static int checkMatch (String, String[][], int):
This method checks if the first argument matches any string of the second argument<br/> 
in the column specified in the third argument? If there are no matches, it returns<br/>
-1, otherwise it returns the row's index of the match.
#### public static String formatName(String):
This method formats an argument (word) and returns a string with the same symbols<br/>
as in the argument, but with the first letter in upper case and the rest in lower<br/>
case.
#### public static String formatFullName(String):
This method splits the argument into separate words and uses the **formatName()**<br/>
method to format as described above. It also formats hyphenated words so that<br/>
both parts of such words start with a capital letter.
#### public static String formatPhoneNumber(String):
This method formats the argument and returns a string in the format<br/>
+7 XXX XXX XX XX.
#### public static String[][] addRegister(String, String, String[][]):
This method increases a two-dimensional array of strings by 5 rows if there is<br/>
no free row and writes the strings (name and phone number) to a free row, or if<br/>
there is a free row, then simply writes strings to it.
#### public static void printPhoneBook(String[][] book):
This method output on display the data of all phonebook.
## Autor    
Eremin Ivan Nikolaevich
