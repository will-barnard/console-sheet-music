package src.Java;

public class StaffBuilder {

    private String[] staff;


    public StaffBuilder() {
    }

    // this constructor is wrong
    public StaffBuilder(String[] scaleArray) {
        this.staff = new String[14];


        for (int i = 0; i < staff.length; i++) {
            staff[i] = TrebleClef.trebleClef()[i];
        }
        for (int i = 0; i < scaleArray.length; i++) {
            QuarterNote note = new QuarterNote(scaleArray[i]);
            for (int j = 0; j < staff.length; j++) {
                staff[j] += note.getNote()[j];
            }
        }
    }


    public void print() {
        for (String line : staff) {
            System.out.println(line);
        }
    }



}
