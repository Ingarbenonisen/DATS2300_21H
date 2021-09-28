package bjorge.exercises.week36.section135;

import bjorge.structure.Tabell;

public class D235 {
    public static void main(String[] args) {
        int[] a = {3,8,10,12,14,16,21,24,27,30,32,33,34,36,40};
        int[] tomm = new int[0];
        //Oppgave 2
        /*
        System.out.println(Tabell.lineærsøk(tomm, 2));
        System.out.println("|");

        System.out.println(Tabell.lineærsøk(a, 2));

        System.out.println("|");

        System.out.println(Tabell.lineærsøk(a, 2));
        System.out.println(Tabell.lineærsøk(a, 15));
        System.out.println(Tabell.lineærsøk(a, 16));
        System.out.println(Tabell.lineærsøk(a, 40));
        System.out.println(Tabell.lineærsøk(a, 41));

         */

        // Oppgave 3
        // lagt inn metode i Tabell klassen

        //Oppgave 5
        System.out.println(Tabell.lineærsøk(a, 1, 10));


    }
}
