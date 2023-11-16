package src.Java;

import java.util.HashMap;
import java.util.Map;

public class NoteFunction {

    public final static String FLAT = "b";
    public final static String SHARP = "#";


    public static int strToInt(String note) {

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

    public static int strToStaffInt(String note) {

        // get chrom index from note as string
        Map<String, Integer> keyMap = new HashMap<>();
        keyMap.put("C", 0);
        keyMap.put("C#", 0);
        keyMap.put("Db", 1);
        keyMap.put("D", 1);
        keyMap.put("D#", 1);
        keyMap.put("Eb", 2);
        keyMap.put("E", 2);
        keyMap.put("E#", 2);
        keyMap.put("Fb", 3);
        keyMap.put("F", 3);
        keyMap.put("F#", 3);
        keyMap.put("Gb", 4);
        keyMap.put("G", 4);
        keyMap.put("G#", 4);
        keyMap.put("Ab", 5);
        keyMap.put("A", 5);
        keyMap.put("A#", 5);
        keyMap.put("Bb", 6);
        keyMap.put("B", 6);
        keyMap.put("B#", 6);


        return keyMap.get(note);
    }

//    public static String parseKeyFromInput(String key) {
//
//    }

}
