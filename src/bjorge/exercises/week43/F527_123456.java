package bjorge.exercises.week43;

import bjorge.eksempelKlasser.SBinTre;

import java.util.stream.Stream;

// 5.2.7  Min, maks, gulv, tak, mindre, større
public class F527_123456 {
  public static void main(String[] args) {
        // Oppgave 3
        Integer[] verdi = {1, 5, 7, 10, 15,7};
        SBinTre<Integer> tre = SBinTre.sbintre(Stream.of(verdi));
        System.out.println(tre);
        int verdiTall = 6;
        System.out.println(tre.gulv(verdiTall));
        // Oppgave 4
        System.out.println(tre.gulv2(verdiTall));
        if (tre.gulv(verdiTall).equals(tre.gulv2(verdiTall))){
        System.out.println(true);
        }

  }
}
