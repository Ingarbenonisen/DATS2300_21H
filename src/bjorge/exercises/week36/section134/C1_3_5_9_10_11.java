package bjorge.exercises.week36.section134;

import bjorge.structure.Tabell;

import static bjorge.structure.Tabell.utvalgssorteringM;


public class C1_3_5_9_10_11 {
    public static void main(String[] args) {
        //Oppgave 11
        for (int i = 0; i < 10; i++) {
            int[] a = Tabell.randPerm(10);
            System.out.print(utvalgssorteringM(a) + " ");
        }

    }

}
