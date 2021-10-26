package bjorge.exercises.week43;

import bjorge.eksempelKlasser.SBinTre;

import java.util.stream.Stream;

// 5.2.7  Min, maks, gulv, tak, mindre, større
public class F527_123456 {
  public static void main(String[] args) {
        // Oppgave 3
        Integer[] verdi = {1, 3, 5, 7 ,7, 4, 2, 4, 1};
        SBinTre<Integer> tre = SBinTre.sbintre(Stream.of(verdi));
        System.out.println(tre.gulv(6));
  }
}
