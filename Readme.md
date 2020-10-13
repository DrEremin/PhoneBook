# PhoneBook
**Phonebook** is console application with simple database. It lets to keep full-<br/>
names of people and their phone numbers. Its apllication also lets to show<br/> 
database or separate entries on display and to input data in database.
## Features of use
For the input of fullname use three words (last name, first name, middle name)<br/>
separated whitespaces. These words may consist of Latin or Cyrillic letters.<br/>
Using a hyphen permissible too, but only in a middle of words. A number of phone<br/>
must include 11 digits and first digit must to be 7 or 8. Other symbols is<br/>
allowable for number of phone.<br/> 
When adding an entry, user can enter either a phone number or a full name if he<br/>
wish. The program itself recognizes the format and at the second stage of creating<br/>
a register, will offer to enter the necessary data.<br/>
If at any stage of creating a register a match is found between the entered data and<br/>
the lines of the telephone directory, the program will display such a register and will<br/>
not add a new one.
## Features of implementation
If the moment of writing a new register has come and all the rows of the array<br/>
"String[][] dataBase" are occupied, the program will first increase the size of the<br/>
array by (number of rows) by 5 and then rec a new register. If, when deleting a<br/>
register, more 5 free rows then, the program will reduce the size of the array<br/>
(the number of rows) in such a way that only 2 free rows remain.<br/>
This will save memory while the program is running.<br/>
To avoid errors when accessing free array strings, they are initialized with empty values ("").
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
there is a free row, then simply writes data to it.
#### public static void printPhoneBook(String[][] book):
This method output on display the data of all phonebook.
#### public static String[][] delRegister(String[][] array, int index):
This method deletes a register by phone number or by name. If the number of free<br/>
rows after deleting a register becomes more than five, then it decreases the size<br/> 
of the array in such a way that for registers there are two free rows.
#### public static void sortingOfRegisters(String[][] array):
This method sorts the phonebook entries alphabetically, comparing only the rows<br/>
in column zero of the array "String[][] array". The rows of the column with index one<br/>
are moved according to the movements of the rows of the column with the index<br/>
zero.
### [Link to the program's scheme](https://github.com/DrEremin/PhoneBook/blob/master/ProgrammScheme.pdf)
## Autors:    
**Eremin Ivan Nikolaevich**
