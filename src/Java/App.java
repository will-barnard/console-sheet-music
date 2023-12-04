package src.Java;

import src.Java.Utility.Global;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);


        System.out.println("--SHEET MUSIC GENERATOR--");
        String moduleSelect = inputScanner.nextLine();

        // CREATE DIRECTORY HERE

        if (moduleSelect.equals("DiatonicMethod") || moduleSelect.equals("")) {

            System.out.println("Diatonic Module");
            System.out.println("Now in Diatonic Module");
            System.out.println("Type 'Commands' for Diatonic Module commands");
            System.out.println("Please input a key signature");
            String keyInput = inputScanner.nextLine();

            DiatonicScale test = new DiatonicScale(keyInput);
            StaffBuilder print = new StaffBuilder(test.printScaleNotesArray(test.diatonicScale(Global.strToInt(keyInput))));
            print.print();


        }



    }


}
