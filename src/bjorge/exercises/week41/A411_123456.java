package bjorge.exercises.week41;

import bjorge.eksempelKlasser.Stakk;

import java.util.Stack;

public class A411_123456 {
    public interface Stakk<T>          // eng: Stack
    {
        public void leggInn(T verdi);    // eng: push
        public T kikk();                 // eng: peek
        public T taUt();                 // eng: pop
        public int antall();             // eng: size
        public boolean tom();            // eng: isEmpty
        public void nullstill();         // eng: clear

    } // interface Stakk

    public static void main(String[] args) {
        // Oppgave 1
        /*
         * Utfør flg. seks operasjoner på en stakk:
         * legg inn 5, legg inn 7, ta ut, legg inn 3, legg inn 7 og ta ut.
         * Hvilket tall ligger nå øverst på stakken?
         * Svar: 3 vil ligge øverst
         */
        // Oppgave 2
        /*
        A.leggInn(2);
        A.leggInn(5);
        A.leggInn(1);
        A.kikk();
        A.taUt();


        Hvilket tall ligger nå øverst på stakken?
         * Svar: 5 vil ligge øverst
         */
        // Opgpave 3


    }
}
