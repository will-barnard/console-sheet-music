package src.Java.model;

import src.Java.Utility.Global;

public class NoteStaff {


    private String[] noteStaff;
    public NoteStaff(Note note) {
        this.noteStaff = createtNoteStaff(note);
    }


    // main method for building output
    public String[] createtNoteStaff(Note note) {

        String noteHead = "(*)";

        //init resulting staff
        String[] staff = new String[14];
        int notePosition = staff.length - Global.strToStaffInt(note.getNoteName()) - 2;

        //generate first third of noteStaff
        for (int i = 0; i < staff.length; i++) {
            staff[i] = blankSegment()[i];
        }
        //generate middle third, the note
        for (int i = 0; i < staff.length; i++) {
            staff[i] += strToNote(note)[i];
        }
        //generate final third
        for (int i = 0; i < staff.length; i++) {
            staff[i] += blankSegment()[i];
        }

        // edge cases
        // below staff
        if (notePosition == 0) {
            staff[12] = " --(*)-- ";
        }
        if (notePosition == -1) {
            staff[12] = "   ---   ";
            staff[13] = "   (*)   ";
        }

        // add flat and sharp
        if (note.getSharp() || note.getFlat()) {
            String accidental = "";
            if (note.getSharp()) {
                accidental = Global.SHARP;
            }
            if (note.getFlat()) {
                accidental = Global.FLAT;
            }

            String strStart = staff[notePosition].substring(0, 3);
            String strEnd = staff[notePosition].substring(4);
            staff[notePosition] = strStart + accidental + strEnd;

        }

        // TODO add note stem here

        return staff;

    }

    public String[] strToNote(Note note) {
        String[] staff = blankSegment();
        staff[staff.length - Global.strToStaffInt(note.getNoteName()) - 2] = "(*)";
        return staff;
    }


    private static String[] blankSegment() {
        String[] staff = new String[14];

        for (int i = 0; i < staff.length; i++) {
            if (i == 0 || i == 12 || i % 2 == 1 || i == 13) {
                staff[i] = "   ";
            }
            else if (i % 2 == 0) {
                staff[i] = "---";
            }
        }
        return staff;
    }

}