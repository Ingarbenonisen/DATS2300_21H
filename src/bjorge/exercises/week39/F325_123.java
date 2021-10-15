package bjorge.exercises.week39;

import bjorge.eksempelKlasser.Liste;
import bjorge.eksempelKlasser.TabellListe;

import java.util.Iterator;

//  3.2.5  Flere iteratorer samtidig
public class F325_123 {
    /*
    *
    *
     */
    public static void main(String[] args) {
        String[] s = {"Per","Kari","Ole"};

        Liste<String> liste = new TabellListe<>();

        for (String navn : s) liste.leggInn(navn);

        System.out.println(liste);

        // Utskrift: [Per, Kari, Ole]
/*
        Iterator<String> i = liste.iterator();     // oppretter en iterator
        System.out.println(i.next());              // den første i listen

        liste.fjern("Per");                        // fjerner den første
        System.out.println(i.next());              // den neste i listen


 */
        Iterator<String> i = liste.iterator();     // oppretter en iterator i
        Iterator<String> j = liste.iterator();     // oppretter en iterator j

        System.out.println(i.next());              // den første i listen
        i.remove();                                // fjerner den første
        System.out.println(j.next());              // den første i listen

    }
}
