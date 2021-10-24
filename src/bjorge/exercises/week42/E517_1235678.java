package bjorge.exercises.week42;
// 5.1.7  Preorden, inorden og postorden

import bjorge.eksempelKlasser.Oppgave;
import bjorge.structure.BinTre;

import java.util.StringJoiner;

public class E517_1235678 {
    public static void main(String[] args) {
        /*
        String[] preorden = "ABDHOIPQEJRKSCFLMTUGNV".split("");
        String[] inorden =  "HODPIQBJREKSALFTMUCNVG".split("");

        BinTre<String> tre = BinTre.trePreorden(preorden,inorden);

        tre.nivåorden(Oppgave.konsollutskrift());

        // Utskrift: A B C D E F G H I J K L M N O P Q R S T U V



        int[] posisjon = {1,2,3,6,7,12,13,26,27};            // posisjoner
        String[] verdi = "ABCDEFGHI".split("");              // verdier
        BinTre<String> tre = new BinTre<>(posisjon,verdi);   // konstruktør
        // bruker v for verdi og p for posisjon som variabelnavn
        tre.preorden((v,p) -> System.out.print("(" + v + "," + p + ") "));
        // Utskrift: (A,1) (B,2) (C,3) (D,6) (F,12) (G,13) (H,26) (I,27) (E,7)

        int[] posisjon = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner og
        String[] verdi = "EIBGAHKLODNMCJF".split("");              // verdier i nivåorden
        BinTre<String> tre = new BinTre<>(posisjon, verdi);        // en konstruktør

        StringJoiner s = new StringJoiner(", " ,"[", "]");         // StringJoiner
        tre.preorden(tegn -> s.add(tegn));                         // tegn = String

        System.out.println(s);
        // Utskrift: [E, I, G, A, L, O, M, C, B, H, D, K, N, J, F]

         */
        // Oppgave 5
        /*
        BinTre<Character> tre = new BinTre<>();   // et tomt tre

        String v = "HBKADIOCFJMEGLN";  // verdiene i nivåorden
        int[] p = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};

        for (int i = 0; i < p.length; i++)
            tre.leggInn(p[i],v.charAt(i));  // autoboksing fra char til Character

        tre.preorden(Oppgave.konsollutskrift());  // skriver ut

        // Utskrift: A B C D E F G H I J K L M N O

         */

        // Oppgave 6
        BinTre<Character> tre = new BinTre<>();   // et tomt tre

        String v = "HBKADIOCFJMEGLN";  // verdiene i nivåorden
        int[] p = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};

        for (int i = 0; i < p.length; i++)
            tre.leggInn(p[i],v.charAt(i));  // autoboksing fra char til Character

        tre.inorden(Oppgave.konsollutskrift());  // skriver ut
    }

}
