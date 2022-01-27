import java.util.*;
//Author: Rea Ahuja
//Date: October 11th 2021
/*Description: This program contains multiple methods, where the user can choose whether they want to run a binary search method on a given array, a quick sort method on an imputed array,
a vowel counter on an input or to print a right triangle with the number of rows imputed */

public class ICS4U_recursion_AhujaR {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //gives the user a menu of options, and asks which one they would like to do
        System.out.println("Hello!");
        System.out.println("To perform binary search:  press 1");
        System.out.println("To perform quick sort:     press 2");
        System.out.println("To perform a vowel search: press 3");
        System.out.println("To print a right triangle: press 4");
        System.out.println("To exit:                   press 5");

        // user makes a selection
        System.out.println("Enter your option: ");
        int option = input.nextInt();

        //if the user does not want to exit, then run the loop, else exit and end program
        while(option != 5){
            if (option == 1){
                // if the user chooses 1, then run binary search
                System.out.println("You have chose binary search");

                //user is asked to enter the value of a number between 1-9
                System.out.println("Enter the value of the number between 1-9: ");
                int value = input.nextInt();

                int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
                int min = 0;
                // the variable min is equal to the minimum/lowest index in the array
                int max = array.length -1;
                // the variable maximum is equal to the greatest index in the array
                int middle = (min + max)/2;
                // the variable middle is equal to the middle index in the array

                //the method findIndex finds the index of the given number and returns it
                System.out.println("The index is: " + findIndex(array, min, max, middle, value));


            }else if (option == 2){

                // if the user chooses 2, then run quick sort
                System.out.println("You have chose quick sort");

                System.out.println("Enter the size of the array: ");
                int size = input.nextInt();
                if (size == 0){
                    System.out.println("");
                }else{
                    int[] array = new int[size];
                    int k = 0;
                    int extra = fillArray(array, k, size);
                    //lowestSearch stores the lowest index of range being search
                    int lowestSearch = 0;
                    //highestSearch stores teh highest index of range being search
                    int highestSearch = array.length - 1;
                    int j = lowestSearch;
                    int i = 0;
                    System.out.println("Unsorted array: ");
                    //prints the array
                    printArray(array, i);
                    System.out.println("");
                    //performs quickSort
                    quickSorts(array, lowestSearch, highestSearch, j);
                    //prints the array
                    System.out.println("Array sorted: ");
                    printArray(array, i);
                    System.out.println("");
                }

            }else if (option == 3){
                // if the user chooses 3, then run vowel search
                System.out.println("You have chose vowel search");

                System.out.println("Enter a word: ");
                String str = input.next();
                str = str.toLowerCase(Locale.ROOT);
                // user is asked to enter a word
                // input is taken in variable str

                System.out.println("The number of vowels are: " + vowelCount(str));
                //vowelCount method returns the number of vowels in the input


            }else if (option == 4){
                // if the user chooses 4, then run vowel search
                System.out.println("You have chose right triangle printing");
                System.out.println("Enter the number of rows: ");
                int rows = input.nextInt();
                // user is asked to enter the number of rows that the triangle should have

                String str = "";

                System.out.println(displayTriangle(rows, str));
                //method prints the triangle

            }else{
                // if the user a number that is not in range of 1-5, then let them know that the input is invalid
                System.out.println("Invalid input");
            }
            //give user the menu of options and ask them again
            System.out.println("Choose program again");
            System.out.println("To perform binary search:  press 1");
            System.out.println("To perform quick sort:     press 2");
            System.out.println("To perform a vowel search: press 3");
            System.out.println("To print a right triangle: press 4");
            System.out.println("To exit:                   press 5");

            System.out.println("Enter your option: ");
            option = input.nextInt();

        }
        //if the user chooses exit then the program ends
        System.out.println("Program ends");
    }

    //BinarySearch Method
    public static int findIndex(int[] array, int min, int max, int middle, int value){
/*Description: This method takes the array created, the minimum value of the array, the maximum value of the array, the middle value of the array, and the value being
found as parameters. Additionally, this method uses recursion to find the index of the given value. As if it finds that the middle of the array in the range being looked
at is greater than the value, then it will decrease the range by making the maximum index being looked at, the number beside the middle value. Additionally, if it finds
that the middle of the array in the range being looked at is less than the value of the array, than it will make the minimum 1 greater than the middle. Moreover, the
program continues the recursive calls until it finds the index of the given value */

        middle = (min + max)/2;
        //the variable middle is equal to middle index of the part of the array being looked at
        //the value of middle is reset each time the range changes and the method calls on itself, to the middle of that specific range

        if (array[middle] != value){
            /*Base case: The base case is array[middle] != value. If the value at index middle is equal to the value that needs to be found. No recursion needs to be done,
            the variable middle can be returned. However, if array[middle] != value is true, than the program needs to perform recursion in order to find the index of the
            imputed value */
            //if the value of the array at middle is not equal to the value that needs to be found, enter if statement
            if (array[middle] > value){
                /* General Case 1: If the value of the array at index middle is greater than the value being found, then the range needs to be changed. Thereby, the
                upper range needs to change to the value beside the middle. Additionally, a recursion call needs to be done to reset the middle as per the range and
                find it is equal to the value. If not, the range needs to be changed again and checked again.
                 */
                // if the value of the array at the middle is greater than the value then make the max value 1 smaller than the middle
                max = middle - 1;
                return findIndex(array, min, max, middle, value);
                //do a recursive call on the findIndex with the max 1 smaller than the middle
            }else{
                /* General Case 2: If the value of the array at index middle if smaller than the value being found, then the range needs to be changed. Thereby, the lower range
                needs to be changed to the value on the right of the middle. Additionally, a recursion call needs to be done to reset the middle as per the range and
                find it is equal to the value. If not, the range needs to be changed again and checked again.
                 */
                // if the array[middle] < value than make the smallest value in range one bigger than the middle
                min = middle + 1;
                return findIndex(array, min, max, middle, value);
                //do a recursive call on the findIndex with the min 1 bigger than the middle
            }
            //the variables min/max are increased/decreased until the range shortens down the value that needs to be found
        }
        // program will not enter if statement if the index of value has been found


        return middle;
        //the method returns the index of the value, after the program has found it.

    }

    //quick sort methods
    public static int fillArray(int[] array, int k, int size) {
        /* Description: The main purpose of this method is to let the user input the elements and fill the array with values. Additionally, the method uses recursion to
        do this, as it increases the value of k, which represents the index, each time, so the user can input a value for a new index. The value of size is decreased
        so the method does not form an infinite loop and due to the fact that one element in the array has been filled.
         */
        Scanner input = new Scanner(System.in);
        // if the size is greater than 0 then keep asking the user to fill the array
        if (size > 0){
            System.out.println("Enter a value for index " + k + ": ");
            int element = input.nextInt();
            array[k] = element;
            return fillArray(array, k +1, size -1);
            /* k, which represents the index in the array, is increased by 1 so a value can be added to the next index and the size is decreased by one as an element
            in the array has been filled
             */
        }
        return 0;
    }

    public static void quickSorts(int[] array, int lowestSearch, int highestSearch, int j) {
        /* Description: The main purpose of this method is to organize the calls on the sorting method. The sorting method is where the quick sort algorithm takes place.
        In this method, the if statement runs until the range is valid, thereby the lowest index being searched is less than the highest index being searched.
        Additionally, the sorting method returns the index of where the highest index value has been swapped to. After returning, the quickSorts method is called on again, using the
        value returned. The first call uses the value given to change the range, and check the first half of the array, thereby the part to the left of the index of the last swap, and it sorts it. The second
        call on quickSorts uses the value given to change the range, and check the second half of the array, thereby the half to the right of the index of the pivot.
         */
        /*The method takes the array, the lowest index that needs to be searched, the highest index that needs to be searched, and index of the last swap as parameters
         */

        if (lowestSearch < highestSearch){
            //General Case: Makes sure that the range is existent and that the lowest index of the range being searched is lower than the highest index being searched
            int value = sorting(array, lowestSearch, highestSearch, lowestSearch);
            // returns the index of last swap, thereby j

            quickSorts(array, lowestSearch, value-1, lowestSearch);
            /*the method quickSorts is called on again with the highest index being searched changed to the index to the left of the last swap and the value of j being
            equal to the lowest index */
            quickSorts(array, value +1, highestSearch, value + 1);
            /*the method quickSorts is called upon again with the lowest index and j being the value to the right of the last swap */
        }


    }

    public static int sorting(int[] array, int lowestSearch, int highestSearch, int j) {
        /* Description: This method performs quick sort on the given array. It takes the array, the lowest index of the range being searched, the highest index of the array
        being search, and the value of j (which gives the index of the comparison) as parameters. Moreover, to simply describe the function of the method, if there is a
        value greater than the value at the highest index, then that value and the value at the last comparison will be swapped, and the method will be called on recursively
        with the value of the lowest index being searched being increased, as well as the index of the last comparison being increase so that the next value can be checked.
         However, if the values are smaller than the highest index the method will be called on recursively with the lowest index changed, so that the next element can
        be checked. Once the lowest index is equal to the highest index the element in the greatest index and the element at the last swap, are swapped. The index of
        the last comparison is then returned.
         */

        if(lowestSearch < highestSearch){
            /*Base Case: If the lowest index of the array being searched is less than the highest index being searched, the program will go into the if statement. If not
            it will exit the if statement, swap the value of the index at highestSearch and the last comparison, and return the value of j. */
            if ( array[lowestSearch] < array[highestSearch]){
                /*General Case 1: If the value of the array at the lowest index is smaller than the value of the array at the highest index (the pivot), then swap
                the value of the lowest index being searched and the index of the last comparison. Call the method recursively, and increase the lowest index, and comparison index
                by one. Also, the lowest index is increased so that the next value in the range can be checked.
                 */
                int temp = array[lowestSearch];
                array[lowestSearch] = array[j];
                array[j] = temp;
                return sorting(array, lowestSearch + 1, highestSearch, j + 1);
                /*the lowest value is increased by one so the next index can be checked, the highestSearch remains the same, and the variable that contains the index of
                the last swap is increased by one. Additionally, the method is called upon recursively, and all these values, alongside the array are returned.
                 */
            }else{
                /*General Case 2: If the value of the array at the lowest index is not smaller than the value of the array at the highest array (the pivot), then call on
                the method recursively, while increasing the lowest index in the range being searched by one to check the next element.
                 */
                return sorting(array, lowestSearch +1, highestSearch, j);
                /* the lowest value is increased by one so the next index can be checked, the highestSearch remains the same and the variable j remains the same as no
                swaps were done. Additionally, the method is called upon recursively, and all these values, alongside the array are returned.
                 */
            }
        }
        // swap pivot with the element at index of j (the element at the last comparison)
        int temp = array[highestSearch];
        array[highestSearch] = array[j];
        array[j] = temp;
        // return the value of j or thereby the index of the last swap
        return j;
    }

    public static String printArray(int[] array, int i) {
        //Description: This method uses recursion to print an array.
        if (i < array.length){
            //Base case would be i == array.length
            //General case is i < array.length
            System.out.print(array[i] + " ");
            return printArray(array, i +1);
            /* the value of i is increased by one so the next value can be printed. Additionally, the method is called upon recursively and
            the value of i and the array are returned. */
        }
        return "";

    }

    //vowel search method
    public static int vowelCount(String str){
        /*Description: The method vowelCount counts the number of vowels in an imputed word. In order to do so, a variable counter is created which is initialized as 0.
        Moreover, after initializing and declaring the variable counter, the program goes into an if statement where the first character of the string is checked
        to see if it is a vowel. If it is a vowel, then one will be added to counter. Next, the counter is returned, and  the method is called upon recursively,
        and the string at the second index is returned. By making str.substring(1), the program looks at the next character of the string and checks to see if
        it is a vowel or not. Additionally, it takes the word as a parameter.
         */
        int count = 0;
        //variable counts the number of vowels in the string

        if (str.length() > 0){
            //Base Case: If the length of the string is larger than one, then the program will enter the if statement, and check if the first character of the string is a vowel
            if (str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o' || str.charAt(0) == 'u'){
                  /*General Case 1: Program checks to see if the first character of the string is a vowel. If it is, then one is added to the counter, and, counter is returned
                  and recursion takes place as the method is called on once again but with the str shortened, so the next character can be looked at.
                   */
                count = count + 1;
                //the value of count is increased by 1, as the program has found a vowel in the word
                return count + vowelCount(str.substring(1));
                //the value of count is returned, and the method vowelCount is called upon recursively with the string shortened so the next value can be looked at
            }else{
                 /*General Case 2: Program checks to see if the second character of the string is a vowel. If it is not, then counter is returned, and the method with
                 the string shortened is called upon recursively so the next character can be looked at.
                  */
                return count + vowelCount(str.substring(1));
                //the value of count is returned, and the method vowelCount is called upon recursively with the string shortened so the next value can be looked at
            }
        }

        /*Once program exits if statement, thereby the length of the string is equal to 0, and all characters have been checked, the variable count, thereby the number
        of vowels in the program is returned.
         */

        return count;

    }

    //right triangle printing method
    public static String displayTriangle(int rows, String str){
        /*Description: The method displayTriangle displays a right triangle made up of stars as per the number of rows given by the user. Specifically, the program checks
        if the number of rows is greater than 0, if so, then it will add a star the string str, print it, and call on the method recursively with the number of rows
        decreased, as a row has been printed, and it also returns the string in which the star has been added, so another star can be added for the next row. Once all the
        rows have been printed, the program will be stopped by returning a value.
         */

        if (rows > 0){
            //General Case: If the number of rows is greater than 0, then continue if statement and keep printing rows in triangle
            str = str + "*";
            // a star is added to the variable str
            System.out.println(str);
            //str is printed
            return displayTriangle(rows -1, str);
            /*the method is called upon, and the value of the rows is decreased by one so the program can move onto the next row. Additionally, the method is called upon
            recursively and the value of the rows alongside the str in which the stars are being added are returned
             */
        }else{
            //Base Case: If the number of rows is equal to 0, stop method by returning a value
            return "";
        }

    }

}
