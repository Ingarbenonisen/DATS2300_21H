package bjorge.exercises.week37.section142;

import bjorge.structure.Tabell;

import java.util.Arrays;

public class B12 {
    public static void main(String[] args) {
        // Oppgave 1 for lett
        // Oppgave 2
        String[] s = {"Per","Kari","Ole","Anne","Ali","Eva"};
        Tabell.innsettingssortering(s);
        System.out.println(Arrays.toString(s));  // [Ali, Anne, Eva, Kari, Ole, Per]
    }
}
