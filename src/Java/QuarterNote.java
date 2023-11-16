package src.Java;

public class QuarterNote {

//    public static void main(String[] args) {
//        for (String line : toNote()) {
//            System.out.println(line);
//        }
//    }

    private String noteStr;
    private int noteInt;
    private boolean flat = false;
    private boolean sharp = false;


    public QuarterNote(String note) {
        this.noteStr = note;
        if (note.length() > 1) {
            if (note.contains(NoteFunction.SHARP)) {
                this.sharp = true;
            }
            if (note.contains(NoteFunction.FLAT)) {
                this.flat = true;
            }
        }
        this.noteInt = NoteFunction.strToInt(note);
    }
    public QuarterNote(int note, boolean flatOrSharp) {

        if (flatOrSharp) {
            this.sharp = true;
        }
        if (!flatOrSharp) {
            this.flat = true;
        }

        this.noteInt = note;
    }
    public QuarterNote(int note) {
        //this.noteStr = note;
        this.noteInt = note;
    }
    public QuarterNote() {
    }






    // main method for building output
    public String[] getNote() {

        //init resulting staff
        String[] staff = new String[14];

        //generate first third
        for (int i = 0; i < staff.length; i++) {
            staff[i] = blankSegment()[i];
        }
        // edge cases below staff
        if (NoteFunction.strToInt(noteStr) == 0) {
            staff[12] = " --";
        }

        if (flat || sharp) {
            if (NoteFunction.strToStaffInt(noteStr) > 1 ) {

                staff[NoteFunction.strToStaffInt(noteStr)] = flat
                        ? staff[NoteFunction.strToStaffInt(noteStr) + 7].substring(0, 1) + NoteFunction.FLAT
                        : staff[NoteFunction.strToStaffInt(noteStr) + 7].substring(0, 1) + NoteFunction.SHARP;
            }

        }
        else if (NoteFunction.strToInt(noteStr) == -1) {
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
        if (NoteFunction.strToInt(noteStr) == 0) {
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
        if (NoteFunction.strToInt(noteStr) == 0) {
            staff[12] = " --";
        }

        if (flat || sharp) {
            if (NoteFunction.strToStaffInt(noteStr) > 1 ) {

                staff[NoteFunction.strToStaffInt(noteStr)] = flat
                        ? staff[NoteFunction.strToStaffInt(noteStr) + 7].substring(0, 1) + NoteFunction.FLAT
                        : staff[NoteFunction.strToStaffInt(noteStr) + 7].substring(0, 1) + NoteFunction.SHARP;
            }

        }
        else if (NoteFunction.strToInt(noteStr) == -1) {
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
        if (NoteFunction.strToInt(noteStr) == 0) {
            staff[12] = staff[12].substring(0, 6) + "-- ";
        }

        return staff;

    }


    public String[] strToNote() {
        String[] staff = blankSegment();
        staff[staff.length - NoteFunction.strToStaffInt(noteStr) - 2] = "(*)";
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


    public static String[] blankSegment() {
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