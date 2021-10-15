package bjorge.exercises.week38.section157;

import bjorge.eksempelKlasser.Komparator;
import bjorge.structure.R_Tabell;
import bjorge.structure.Tabell;

import java.util.Arrays;
import java.util.Timer;

import static bjorge.eksempelKlasser.Komparator.naturligOrden;
import static bjorge.structure.Tabell.bytt;

// 1.5.7  Kvikksortering
public class D1 {
    public static void main(String[] args) {
        // Oppgave 1

        System.out.println("Oppgave 1");
        Integer[] a = {2, 3, 4, 5, 6, 7, 8, 8, 3, 9};
        Tabell.kvikksortering(a, 2, 8, naturligOrden());
        System.out.println(Arrays.toString(a));
        // [2, 3, 3, 4, 5, 6, 7, 8, 8, 9]
        // [2, 3, 3, 4, 5, 6, 7, 8, 8, 9]
    }
}
