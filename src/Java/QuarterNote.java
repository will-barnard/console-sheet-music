package src.Java;

public class QuarterNote {

    public static void main(String[] args) {
        for (String line : blankSegment()) {
            System.out.println(line);
        }
    }









    private String noteStr;
    //private String[] blankSegment =

    public QuarterNote(String note) {
        this.noteStr = note;

    }
    public QuarterNote() {
    }




    private String[] noteStaff = new String[]{

            "         ",
            "         ",
            "---------",
            "         ",
            "---------",
            "         ",
            "---------",
            "         ",
            "---------",
            "         ",
            "---------",
            "         ",
            "         "

    };

    public static String[] blankSegment() {
        String[] staff = new String[13];

        for (int i = 0; i < staff.length; i++) {
            if (i == 0 || i == 12 || i % 2 == 1) {
                staff[i] = "   ";
            }
            else if (i % 2 == 0) {
                staff[i] = "---";
            }
        }
        return staff;
    }


    public void c4() {

    }
    public void csharp4() {

    }
    public void dflat4() {

    }
    public void d4() {

    }
    public void dsharp4() {

    }
    public void eflat4() {

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