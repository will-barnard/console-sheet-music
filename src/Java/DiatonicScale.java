package src.Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Class for parsing musical/diatonic information from an alpha input
public class DiatonicScale {

    private String key;
    private String[] majorScale;
    public DiatonicScale() {
    }

    public DiatonicScale(String key) {
        this.key = key;
        this.majorScale = printScaleNotesArray(diatonicScale(keyToIndex(key)));
    }

    public String getKey() {
        // MOVE DETERMINE KEY HERE
        return key;
    }




    public void main(String[] args) {

        // init scanner and prompt for key
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Input a key signature:");
        String keyInput = inputScanner.nextLine();
        keyInput = keyInput.substring(0, 1).toUpperCase() + keyInput.substring(1);

        { Boolean validCheck = true;
        while (validCheck) {
            if (isValidKey(keyInput)) {
                validCheck = false;
            } else {
                System.out.println("Not a valid key, try again");
                keyInput = inputScanner.nextLine();
            }
        }

        int keyIndex = keyToIndex(keyInput);
        System.out.println("diatonic index for " + keyInput + " is " + keyToIndex(keyInput));
        int[] diatonicArray = diatonicScale(keyIndex);
        System.out.println(printScaleNotesDiatonic(diatonicArray));

        }
    }

    public static boolean isValidKey(String str) {

        // calculate if given input is a valid key
        Map<String, Integer> keyMap = new HashMap<>();
        keyMap.put("C", 0);
        keyMap.put("C#", 1);
        keyMap.put("Db", 1);
        keyMap.put("D", 2);
        keyMap.put("D#", 3);
        keyMap.put("Eb", 3);
        keyMap.put("E", 4);
        keyMap.put("E#", 5);
        keyMap.put("Fb", 4);
        keyMap.put("F", 5);
        keyMap.put("F#", 6);
        keyMap.put("Gb", 6);
        keyMap.put("G", 7);
        keyMap.put("G#", 8);
        keyMap.put("Ab", 8);
        keyMap.put("A", 9);
        keyMap.put("A#", 10);
        keyMap.put("Bb", 10);
        keyMap.put("B", 11);
        keyMap.put("B#", 0);


        return (keyMap.containsKey(str)) ?
                true :
                false;
    }


    public static int keyToIndex(String note) {

        // get chrom index from note as string
        Map<String, Integer> keyMap = new HashMap<>();
        keyMap.put("C", 0);
        keyMap.put("C#", 1);
        keyMap.put("Db", 1);
        keyMap.put("D", 2);
        keyMap.put("D#", 3);
        keyMap.put("Eb", 3);
        keyMap.put("E", 4);
        keyMap.put("E#", 5);
        keyMap.put("Fb", 4);
        keyMap.put("F", 5);
        keyMap.put("F#", 6);
        keyMap.put("Gb", 6);
        keyMap.put("G", 7);
        keyMap.put("G#", 8);
        keyMap.put("Ab", 8);
        keyMap.put("A", 9);
        keyMap.put("A#", 10);
        keyMap.put("Bb", 10);
        keyMap.put("B", 11);
        keyMap.put("B#", 0);


        return keyMap.get(note);

    }

    public static String indexToKey(int note) {

        // get note value from chrom index
        Map<Integer, String> keyMap = new HashMap<>();
        keyMap.put(0, "C");
        keyMap.put(1, "C#/Dd");
        keyMap.put(2, "D");
        keyMap.put(3, "D#/Eb");
        keyMap.put(4, "E");
        keyMap.put(5, "F");
        keyMap.put(6, "F#/Gb");
        keyMap.put(7, "G");
        keyMap.put(8, "G#/Ab");
        keyMap.put(9, "A");
        keyMap.put(10, "A#/Bb");
        keyMap.put(11, "B");
        keyMap.put(12, "C");
        keyMap.put(13, "C#/Dd");
        keyMap.put(14, "D");
        keyMap.put(15, "D#/Eb");
        keyMap.put(16, "E");
        keyMap.put(17, "F");
        keyMap.put(18, "F#/Gb");
        keyMap.put(19, "G");
        keyMap.put(20, "G#/Ab");
        keyMap.put(21, "A");
        keyMap.put(22, "A#/Bb");
        keyMap.put(23, "B");

        return keyMap.get(note);

    }


    public int[] diatonicScale(int k) {

        // calculate diatonic scale as an int[] for current key
        int[] scale = new int[] {0, 2, 4, 5, 7, 9, 11, 12};
        for (int i = 0; i < 7; i++) {
            scale[i] = scale[i] + k;
        }

        for (int num : scale) {
            if (k == 11) {
                num -= 12;
            }
            if (num < k) {
                num += 12;
            }
        }

        return scale;

    }

    public String printScaleNotesDiatonic(int[] scale) {

        // print a string containing the seven note diatonic scale in letter form

        String scaleString = "";
        String note = "";
        for (int i = 0; i < scale.length; i++) {

            note = indexToKey(scale[i]);

            // convert to key sig appropriate note string
            if (note.length() > 2) {
                if (flatOrSharp(scale[0])) {
                    note = note.substring(0, 2);
                }
                else {
                    note = note.substring( 3);
                }
            }

            // concat and add comma
            scaleString += note;
            if (i < scale.length - 1) {
                scaleString = scaleString + ", ";
            }
        }

        return scaleString;

    }

    public String[] printScaleNotesArray(int[] scale) {

        // print a string containing the seven note diatonic scale in letter form

        String scaleString[] = new String[8];
        String note = "";
        for (int i = 0; i < scale.length; i++) {

            note = indexToKey(scale[i]);

            // convert to key sig appropriate note string
            if (note.length() > 2) {
                if (flatOrSharp(scale[0])) {
                    note = note.substring(0, 2);
                }
                else {
                    note = note.substring( 3);
                }
            }

            scaleString[i] = note;

        }

        return scaleString;

    }

    public boolean flatOrSharp(int key) {

        // checks for sharp/flat convention given scalar int array
        // SHARP is TRUE, FLAT is FALSE
        if (key == 0 || key == 2 || key == 4 || key == 6 || key == 7 || key == 9 || key == 11) {
            return true;
        }
        else {
            return false;
        }

    }

    public String printScaleNotesChromatic(int[] scale) {

        // print a string containing the notes from a int array input in letter form

        String scaleString = "";
        String note = "";
        for (int i = 0; i < scale.length; i++) {
            note = indexToKey(scale[i]);
            // concat and add comma
            scaleString += note;
            if (i < scale.length - 1) {
                scaleString = scaleString + ", ";
            }
        }

        return scaleString;

    }

    public int[] printScaleStaffPosition(int[] scale) {

        // print a string containing the seven note diatonic scale in letter form
        int scaleInts[] = new int[8];
        for (int i = 0; i < scale.length; i++) {
            //scaleInts[i] = NoteFunction.noteIntToStaffInt(scale[i]);
            if (scale[i] < scale[0]) {
                scale[i] += 8;
            }
            if (scale[0] == 11) {
                scale[0] = -1;
            }
        }



        return scaleInts;

    }


}
