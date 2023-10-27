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
            if (note.substring(1).equals("#")) {
                this.sharp = true;
            }
            if (note.substring(1).equals("b")) {
                this.flat = true;
            }
        }

    }

    public QuarterNote(int note) {
        //this.noteStr = note;
        this.noteInt = note;
    }
    public QuarterNote() {
    }







    public static String[] blankSegment() {
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



    // main method for building output
    public String[] getNote() {
        String[] staff = new String[14];

        for (int i = 0; i < staff.length; i++) {
            staff[i] = blankSegment()[i];
            if (flat || sharp) {
                if (NoteFunction.strToStaffInt(noteStr) > 1 ) {
                    // add flat or sharp here


                }





            }
            else if (NoteFunction.strToInt(noteStr) == 0) {
                // create additional lines for C here
            }
        }
        for (int i = 0; i < staff.length; i++) {
            staff[i] += strToNote()[i];
        }
        for (int i = 0; i < staff.length; i++) {
            staff[i] += blankSegment()[i];
        }
        return staff;
    }


//    public String[] intToNote() {
//        String[] staff = blankSegment();
//        String spaceLine = "  |";
//        String lineLine = "--|";
//
//
//        staff[staff.length - noteInt] = "(*)";
//        return staff;
//    }



    public String[] strToNote() {
        String[] staff = blankSegment();
        staff[staff.length - NoteFunction.strToStaffInt(noteStr) - 2] = "(*)";
        return staff;
    }





}


/*


---------

---------

---------

---------
     |
-----|---
     |
   (*)


 */



//    private String[] noteStaff = new String[]{
//
//            "         ",
//            "         ",
//            "---------",
//            "         ",
//            "---------",
//            "         ",
//            "---------",
//            "         ",
//            "---------",
//            "         ",
//            "---------",
//            "         ",
//            "         "
//
//    };
