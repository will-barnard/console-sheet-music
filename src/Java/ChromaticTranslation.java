package src.Java;

import java.util.Scanner;

public class ChromaticTranslation {

    private int[] toneSet;

    public static void main(String[] args) {

        System.out.println("welcome");

        //init scanner
        Scanner inputScanner = new Scanner(System.in);
        String input = inputScanner.nextLine();

        //checkIfToneRow(String.valueOf(input).split(" "));
        String[] setString = input.split(",");
        int[] set = new int[setString.length];
        for (int i = 0; i < set.length; i++) {
            set[i] = Integer.parseInt(setString[i]);
        }

        String resultArray = inverseSet(set).toString();
        System.out.println(resultArray.join(","));


    }

    public static boolean checkIfToneRow(int[] row) {

        if (row.length > 11) {
            return false;
        }
        int[] chromScale = new int[11];
        for (int note : chromScale) {
            note = 0;
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i] < 0 || row[i] > 11) {
                return false;
            }
            else {
                chromScale[row[i]] += 1;
            }
        }
        for (int note : chromScale) {
            if (note > 1) {
                return false;
            }
        }
        return true;

    }

    public static int[] inverseSet(int[] set) {
        int[] returnSet = new int[set.length];
        int current = 0;
        for (int i = 1; i < set.length; i++) {
            returnSet[i] -= set[set.length - i] - set[set.length -1 - i];
        }
        for (int i = 0; i < returnSet.length; i++) {
            if (returnSet[i] < 0) {
                returnSet[i] += 12;
            }
            if (returnSet[i] > 11) {
                returnSet[i] -= 12;
            }
        }
        return returnSet;
    }



}
