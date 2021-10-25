package bjorge.exercises.week43;

import bjorge.eksempelKlasser.SBinTre;

import java.util.Comparator;

// 77 Datastruktur for et binært søketre
public class B522_1 {
    // Oppgve 1
    // Låg klassen sBinTree inn
    public static void main(String[] args) {
        SBinTre<Integer> tre1 = SBinTre.sbintre();          // 1. konstruksjonsmetode

        Comparator<Integer> c = Comparator.naturalOrder();
        SBinTre<Integer> tre2 = SBinTre.sbintre(c);         // 2. konstruksjonsmetode

        System.out.println(tre1.antall() + " " + tre2.antall());

        // Utskrift: 0 0


    }
}
