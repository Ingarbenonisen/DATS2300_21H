package bjorge.exercises.week42;

import bjorge.eksempelKlasser.Liste;
import bjorge.eksempelKlasser.Oppgave;
import bjorge.eksempelKlasser.TabellListe;
import bjorge.structure.BinTre;
import bjorge.structure.Tabell;

import java.util.Arrays;
import java.util.StringJoiner;

public class D516_1345810 {
    public static void main(String[] args) {
        /*
        int[] posisjon = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner og
        String[] verdi = "EIBGAHKLODNMCJF".split("");              // verdier i nivåorden

        BinTre<String> tre = new BinTre<>(posisjon, verdi);        // en konstruktør
        tre.nivåorden(c -> System.out.print(c + " "));  // lambda-uttrykk som argument
        // Utskrift: E I B G A H K L O D N M C J F

        Liste<Character> liste = new TabellListe<>();  // en liste
        tre.nivåorden(c -> liste.leggInn(c));          // lambda-uttrykk som argument
        System.out.println(liste);                     // skriver ut listen


        int[] posisjon = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // nodeposisjoner
        String[] verdi = "EIBGAHKLODNMCJF".split("");              // verdier i nivåorden

        BinTre<String> tre = new BinTre<>(posisjon, verdi);        // en konstruktør

        int[] nivåer = tre.nivåer();  // bruker Programkode 5.1.6 k)

        System.out.print("Nivåer: " + Arrays.toString(nivåer));
        System.out.print(" Treets bredde: " + nivåer[Tabell.maks(nivåer)]);
        System.out.println(" Treets høyde: " + (nivåer.length - 1));

        // Utskrift: Nivåer: [1, 2, 4, 4, 4] Treets bredde: 4 Treets høyde: 4

        // Oppgave 3
        tre.nivåorden(Oppgave.konsollutskrift().deretter(c -> System.out.print(' ')));
        // Oppgave 4
        BinTre<Character> tre4 = new BinTre<>();             // et tomt tre

        int[] p = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner i nivåorden
        String v = "EIBGAHKLODNMCJF";                       // verdier i nivåorden
        for (int i = 0; i < p.length; i++) tre4.leggInn(p[i],v.charAt(i));

        StringJoiner s = new StringJoiner(", ", "[", "]");

        tre.nivåorden(c -> s.add(c.toString()));

        String verdier = s.toString();
        System.out.println(verdier);                    // skriver ut listen
        */
        // Oppgave 5
        BinTre<Character> tre5 = new BinTre<>();             // et tomt tre

        int[] p5 = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner i nivåorden
        String v5 = "EIBGAHKLODNMCJF";                       // verdier i nivåorden
        for (int i = 0; i < p5.length; i++) tre5.leggInn(p5[i],v5.charAt(i));

        StringJoiner s5 = new StringJoiner(", ", "[", "]");

        char d = 'D';
        tre5.nivåorden(c -> {
            if (c > d) s5.add(c.toString());
        } );

        String verdier5 = s5.toString();
        System.out.println(verdier5);                    // skriver ut listen
        // Oppgave 8

    }
}
