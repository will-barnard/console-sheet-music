package src.Java;

import java.util.Scanner;

public class ConsoleMain {

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
            StaffBuilder print = new StaffBuilder(test.printScaleNotesArray(test.diatonicScale(NoteFunction.strToInt(keyInput))));
            print.print();


        }



    }


}
