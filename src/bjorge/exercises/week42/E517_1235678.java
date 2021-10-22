package bjorge.exercises.week42;
// 5.1.7  Preorden, inorden og postorden

import bjorge.eksempelKlasser.Oppgave;
import bjorge.structure.BinTre;

public class E517_1235678 {
    public static void main(String[] args) {
        /*
        String[] preorden = "ABDHOIPQEJRKSCFLMTUGNV".split("");
        String[] inorden =  "HODPIQBJREKSALFTMUCNVG".split("");

        BinTre<String> tre = BinTre.trePreorden(preorden,inorden);

        tre.nivåorden(Oppgave.konsollutskrift());

        // Utskrift: A B C D E F G H I J K L M N O P Q R S T U V


         */
        int[] posisjon = {1,2,3,6,7,12,13,26,27};            // posisjoner
        String[] verdi = "ABCDEFGHI".split("");              // verdier
        BinTre<String> tre = new BinTre<>(posisjon,verdi);   // konstruktør
        // bruker v for verdi og p for posisjon som variabelnavn
        tre.preorden((v,p) -> System.out.print("(" + v + "," + p + ") "));
        // Utskrift: (A,1) (B,2) (C,3) (D,6) (F,12) (G,13) (H,26) (I,27) (E,7)
    }
}
