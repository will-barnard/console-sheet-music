package src.Java;

public class StaffGenerator {

    public static void main(String[] args) {

        for (String str : trebleClef()) {
            System.out.println(str);
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
                "    `-'      "
        };

        return trebleClef;

    }












    /*


      |\
      |/
------|------
     /|
----/-|------
   / _|_
--/-/-|-\----
 ( (  |  \
--\-\_|)-/---
   \__|_/
------|------
      |
    `-'


-------------

-------------

-------------

-------------

-------------



-------------

-------------

-------------

-------------

-----(*)-----













     */
}
