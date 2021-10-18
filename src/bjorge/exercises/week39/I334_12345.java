package bjorge.exercises.week39;

import bjorge.eksempelKlasser.EnkeltLenketListe;
import bjorge.eksempelKlasser.Liste;

import java.util.Iterator;

// 3.3.4  En indre iteratorklasse
public class I334_12345 {

    public static void main(String[] args) {
        // Oppgave 1
        /*
        Liste<Integer> liste = new EnkeltLenketListe<>();
        for (int i = 1; i <= 10; i++) liste.leggInn(i);

        Iterator<Integer> iterator = liste.iterator();
        liste.fjern(0);   // fjerner verdi med indeks 0
        System.out.println(iterator.next());
         */


        // Oppgave 2
        Liste<Integer> liste = new EnkeltLenketListe<>();
        for (int i = 1; i <= 10; i++) liste.leggInn(i);
        System.out.println(liste);

        // fjerner partallene
        liste.fjernHvis(x -> x % 2 == 0);

        // skriver ut
        liste.forEach(x -> System.out.print(x + " "));
    }
}
