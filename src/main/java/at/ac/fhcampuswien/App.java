package at.ac.fhcampuswien;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static
    // Also put all the method headers here, even if you don't implement the body of the
    // method in order to compile the AppTest Class without errors.
    public static void oneMonthCalendar(int days, int whichDay) {
        int day = 1;
        int blankDaysToPrint = whichDay - 1;
        boolean blankDaysPrinted = false;

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 7; j++){
                if (!blankDaysPrinted){
                    for(int k = 0; k < blankDaysToPrint; k++){
                        System.out.print("   ");
                    }
                    blankDaysPrinted = true;
                    j += blankDaysToPrint;
                }
                if (day < 10){
                    System.out.print(" " + day + " ");
                }
                else{
                    System.out.print(day + " ");
                }

                day++;

                if (day > days){
                    break;
                }
            }
            System.out.println();
        }
    }

    //TODO Frage: erster wert stimmt, dann gibt es abweichung, warum?
    public static long[] lcg(int seed) {
        long[] randomNumbersArray = new long[10];
        double m = Math.pow(2,31);
        int a = 1103515245;
        int c = 12345;
        double randomNumber = 0;
        //double randomNumber = (a * seed + c) % m;

        for(int k = 0; k < 10; k++) {
            randomNumber = ((a * randomNumber) + c) % m;
            randomNumbersArray[k] = (long) randomNumber;
        }
        return randomNumbersArray;
    }

    public static void guessingGame(int numberToGuess) {
        Scanner scanner = new Scanner(System.in);

        int numberCount = 1;
        int guess;

        do{
            System.out.print("Guess number " + numberCount + ": ");

            if(numberCount == 10){
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }

            guess = scanner.nextInt();

            if(guess > numberToGuess){
                System.out.println("The number AI picked is lower than your guess.");
            }
            if(guess == numberToGuess){
                System.out.println("You won wisenheimer!");
                break;
            }
            else if(guess < numberToGuess){
                System.out.println("The number AI picked is higher than your guess.");
            }
            numberCount++;
        }
        while(guess != numberToGuess && numberCount <= 10);
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;

        return randomNumber;
    }

    public static boolean swapArrays(int[] array1, int[] array2) {
        boolean sameLength = false;
        int arrayCounter = 0;
        int arrayIntSave;

        if (array1.length == array2.length){
            sameLength = true;
        }
        if (sameLength) {
            for (int k = array1.length; k > 0; k--) {
                arrayIntSave = array1[arrayCounter];
                array1[arrayCounter] = array2[arrayCounter];
                array2[arrayCounter] = arrayIntSave;
                arrayCounter++;
            }
        }
        return sameLength;
    }

    public static String camelCase(String s) {
        char[] charArray = toCharArray(s);
        int symbolsDeleted = 0;

        //converts all Upper case into lower case and replaces punctuation marks with #, counts how many got replaced
        for (int k = 0; k < charArray.length; k++){
            if (charArray[k] >= 65 && charArray[k] <= 90){
                charArray[k] += 32;
            }
            if(charArray[k] == '.' || charArray[k] == ',' || charArray[k] == 39 || charArray[k] == '?' || charArray[k] == '!'){
                charArray[k] = '#';
                symbolsDeleted++;
            }
        }
        //detects a #, if it does it shifts all chars after that one place forward
        for (int k = 0; k < charArray.length; k++){
            if (charArray[k] == '#'){
                for (int l = k; l < charArray.length - 1; l++){
                    charArray[l] = charArray[l + 1];
                }
            }
        }
        //creates a new Char array, this array is shorter than the first one and only contains lower case and spaces
        char[] newCharArray = new char[s.length() - symbolsDeleted];
        for (int k = 0; k < newCharArray.length; k++){
            newCharArray[k] = charArray[k];
        }
        symbolsDeleted = 0;
        for (int k = 0; k < newCharArray.length; k++){
            //checks if the first char is a lower case, if yes it converts it into upper case
            if (k == 0 && newCharArray[k] >= 97 && newCharArray[k] <= 122){
                newCharArray[k] -= 32;
            }
            //this checks for spaces, if it detects one, it shifts all chars after that one forward and converts them into upper case, and counts them
            if (newCharArray[k] == ' '){
                newCharArray[k] = newCharArray[k + 1];
                newCharArray[k] -= 32;
                for (int l = k + 1; l < newCharArray.length - 1; l++){
                    newCharArray[l] = newCharArray[l + 1];
                }
                symbolsDeleted++;
            }
        }
        //creates the final char array, this one is shorter than the previous one, only containing the final version
        char[] finalCharArray = new char[newCharArray.length - symbolsDeleted];
        for (int k = 0; k < finalCharArray.length; k++){
            finalCharArray[k] = newCharArray[k];
        }
        //converts the final version of the char array into a string
        String stringToReturn = new String(finalCharArray);

        return stringToReturn;
    }

    public static char[] toCharArray(String s){
        char[] charArray = new char[s.length()];

        for(int k = 0; k<s.length(); k++){
            charArray[k] = s.charAt(k);
        }
        return charArray;
    }

    public static int checkDigit(int[] codeArray) {

        int[] weightedArray = new int[codeArray.length];
        int[] productArray = new int[codeArray.length];
        int sum = 0;
        int mod11;
        int testDigit;

        for(int k = 0; k < codeArray.length; k++){
            weightedArray[k] = k + 2;
            productArray[k] = weightedArray[k] * codeArray[k];
            sum += productArray[k];
        }
        mod11 = sum % 11;
        testDigit = 11 - mod11;
        if(testDigit == 10){
            testDigit = 0;
        }
        if(testDigit == 11){
            testDigit = 5;
        }
        return testDigit;
    }

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
        Scanner scanner = new Scanner(System.in);

        //Task One
        int numberOfDays = scanner.nextInt();
        int whichDay = scanner.nextInt();
        oneMonthCalendar(numberOfDays, whichDay);

        //Task Two
        long[] randomNumberArray = lcg(0);
        for (int k = 0; k < randomNumberArray.length; k++){
            System.out.println(randomNumberArray[k]);
        }

        //Task Three
        guessingGame(randomNumberBetweenOneAndHundred());

        //Task Four

        //Task Five

        //Task Six

    }
}