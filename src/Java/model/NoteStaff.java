package src.Java.model;

import src.Java.Utility.Global;

public class NoteStaff {

//    public static void main(String[] args) {
//        for (String line : toNote()) {
//            System.out.println(line);
//        }
//    }

    private String[] noteStaff;




    public NoteStaff(Note note) {
        this.noteStaff = createtNoteStaff(note);
    }


    // main method for building output
    public String[] createtNoteStaff(Note note) {

        String noteHead = "(*)";

        //init resulting staff
        String[] staff = new String[14];

        //generate first third of noteStaff
        for (int i = 0; i < staff.length; i++) {
            staff[i] = blankSegment()[i];
        }


        // edge cases below staff
        if (Global.strToInt(noteStr) == 0) {
            staff[12] = " --";
        }

        if (note.getFlat() || note.getSharp()) {
            if (Global.strToStaffInt(noteStr) > 1 ) {

                staff[Global.strToStaffInt(noteStr)] = flat
                        ? staff[Global.strToStaffInt(noteStr) + 7].substring(0, 1) + Global.FLAT
                        : staff[Global.strToStaffInt(noteStr) + 7].substring(0, 1) + Global.SHARP;
            }

        }
        else if (Global.strToInt(noteStr) == -1) {
            // do nothing for now, graphically dependant
        }

        //generate middle third, the note
        for (int i = 0; i < staff.length; i++) {
            staff[i] += strToNote()[i];
        }

        //generate final third
        for (int i = 0; i < staff.length; i++) {
            staff[i] += blankSegment()[i];
        }
        // edge cases below staff
        if (Global.strToInt(noteStr) == 0) {
            staff[12] = staff[12].substring(0, 6) + "-- ";
        }

        return staff;

    }

    public String[] getNoteFromInt() {

        //init resulting staff
        String[] staff = new String[14];

        //generate first third
        for (int i = 0; i < staff.length; i++) {
            staff[i] = blankSegment()[i];
        }
        // edge cases below staff
        if (Global.strToInt(noteStr) == 0) {
            staff[12] = " --";
        }

        if (flat || sharp) {
            if (Global.strToStaffInt(noteStr) > 1 ) {

                staff[Global.strToStaffInt(noteStr)] = flat
                        ? staff[Global.strToStaffInt(noteStr) + 7].substring(0, 1) + Global.FLAT
                        : staff[Global.strToStaffInt(noteStr) + 7].substring(0, 1) + Global.SHARP;
            }

        }
        else if (Global.strToInt(noteStr) == -1) {
            // do nothing for now, graphically dependant
        }

        //generate middle third, the note
        for (int i = 0; i < staff.length; i++) {
            //staff[i] += intToNote()[i];
        }

        //generate final third
        for (int i = 0; i < staff.length; i++) {
            staff[i] += blankSegment()[i];
        }
        // edge cases below staff
        if (Global.strToInt(noteStr) == 0) {
            staff[12] = staff[12].substring(0, 6) + "-- ";
        }

        return staff;

    }


    public String[] strToNote() {
        String[] staff = blankSegment();
        staff[staff.length - Global.strToStaffInt(noteStr) - 2] = "(*)";
//        if (NoteFunction.strToInt(noteStr) == -1) {
//            staff[13] = "---";
//        }
//        if (NoteFunction.strToInt(noteStr) < 11) {
//            staff[NoteFunction.strToStaffInt(noteStr)+1] = staff[NoteFunction.strToStaffInt(noteStr)+1].substring(0,1) += "|";
//            staff[NoteFunction.strToStaffInt(noteStr)+2] = staff[NoteFunction.strToStaffInt(noteStr)+2].substring(0,1) += "|";
//        }
        return staff;
    }

//    public String[] intToNote() {
//        String[] staff = blankSegment();
//        staff[staff.length - NoteFunction.strToStaffInt(noteInt) - 2] = "(*)";

//        return staff;
//    }


    private static String[] blankSegment() {
        String[] staff = new String[14];

        for (int i = 0; i < staff.length; i++) {
            if (i == 0 || i == 12 || i % 2 == 1 || i == 13 || i == 14) {
                staff[i] = "   ";
            }
            else if (i % 2 == 0) {
                staff[i] = "---";
            }
        }
        return staff;
    }

}