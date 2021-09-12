package bjorge.exercises.week34;

import bjorge.exercises.week34.section113.B56;
import bjorge.structure.Tabell;

import java.util.Arrays;

public class sectionMain {
    public static void main(String[] args) {
        int[] a = {};
        //Oppgave 5
        System.out.println(Arrays.toString(B56.minmaxPos(a)));
        //Oppgave 6
        System.out.println(B56.fak(4));
        //Oppfave D1
        System.out.println(Tabell.maks3(a));
    }
}
