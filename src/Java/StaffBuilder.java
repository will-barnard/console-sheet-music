package src.Java;

import src.Java.model.NoteStaff;

public class StaffBuilder {

    private String[] staff;
    public StaffBuilder() {
    }

    // TODO separate constructors for treble and bass clef
    public StaffBuilder(String[] scaleArray) {
        this.staff = new String[14];


        for (int i = 0; i < staff.length; i++) {
            staff[i] = trebleClef()[i];
        }

        for (int i = 0; i < scaleArray.length; i++) {

            NoteStaff noteStaff = new NoteStaff(scaleArray[i]);
            for (int j = 0; j < staff.length; j++) {
                staff[j] += noteStaff.getNote()[j];
            }

        }
    }

    public void print() {
        for (String line : staff) {
            System.out.println(line);
        }
    }

    public static String[] trebleClef() {
        String[] trebleClef = new String[]{
                "      |\\     ",
                "      |/     ",
                "------|------",
                "     /|      ",
                "----/-|------",
                "   / _|_     ",
                "--/-/-|-\\----",
                " ( (  |  \\   ",
                "--\\-\\_|)-/---",
                "   \\__|_/    ",
                "------|------",
                "      |      ",
                "    `-'      ",
                "             ",
                "             "
        };
        return trebleClef;
    }


}
