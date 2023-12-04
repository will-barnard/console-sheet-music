package src.Java.model;

public class Note {

    private Integer globalInt;
    private Integer setInt;
    private Boolean flat;
    private Boolean sharp;
    private String noteName;
    private int staffPosition;

    public Note() {
    }

    public Note(int setInt) {
        this.setInt = setInt;
    }

    public Note(int globalInt, int setInt, String noteName) {
        this.globalInt = globalInt;
        this.setInt = setInt;
        this.noteName = noteName;
    }

    public Note(int setInt, String noteName) {
        this.setInt = setInt;
        this.noteName = noteName;
    }

    public Note(int globalInt, int setInt, String noteName, boolean flat, boolean sharp) {
        this.globalInt = globalInt;
        this.setInt = setInt;
        this.noteName = noteName;
        this.flat = flat;
        this.sharp = sharp;
    }

    public Boolean getFlat() {
        return flat;
    }

    public void setFlat(Boolean flat) {
        this.flat = flat;
    }

    public Boolean getSharp() {
        return sharp;
    }

    public void setSharp(Boolean sharp) {
        this.sharp = sharp;
    }

    public int getGlobalInt() {
        return globalInt;
    }

    public void setGlobalInt(int globalInt) {
        this.globalInt = globalInt;
    }

    public int getSetInt() {
        return setInt;
    }

    public void setSetInt(int setInt) {
        this.setInt = setInt;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }
}
