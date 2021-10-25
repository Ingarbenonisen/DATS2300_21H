package bjorge.exercises.week43;

import bjorge.eksempelKlasser.SBinTre;

import java.util.Comparator;
import java.util.stream.Stream;

// 5.2.3  Innlegging av verdier
public class C523_12345 {
    public static void main(String[] args) {
        // Oppgave 3: bygg opp treet til
        // venstre i 5.2.1 a)
        String[] verdiA = "IEOAGMCFHKNBDJL".split("");

        SBinTre<String> tre3a = SBinTre.sbintre(Stream.of(verdiA));
        System.out.println("Antall " + tre3a.antall());
        System.out.println("Høyde " + tre3a.høyde());
        System.out.println(tre3a);

        // høgre i 5.2.1 b)
        Integer[] verdiB = {8,2,10,1,6,9,14,4,7,12,15,3,5,11,13};
        SBinTre<Integer> tre3b = SBinTre.sbintre(Stream.of(verdiB));
        System.out.println("Antall " + tre3b.antall());
        System.out.println("Høyde " + tre3b.høyde());
        System.out.println(tre3b);

        // Oppgave 4 c
        Integer[] verdi4 = {4, 1, 8, 5, 3, 10, 7, 2, 6, 9};
        SBinTre<Integer> tre4 = SBinTre.sbintre(Stream.of(verdi4));
        System.out.println("Antall " + tre4.antall());
        System.out.println("Høyde " + tre4.høyde());
        System.out.println(tre4);
        // Oppgave 5
        Integer[] verdi5 = {4, 1, 8, 5, 3, 10, 7, 2, 6, 9};
        Comparator<Integer> c = Comparator.reverseOrder();
        SBinTre<Integer> tre5 = SBinTre.sbintre(Stream.of(verdi5), c);
        System.out.println("Antall " + tre5.antall());
        System.out.println("Høyde " + tre5.høyde());
        System.out.println(tre5);

    }
}
