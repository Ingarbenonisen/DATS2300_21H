package bjorge.exercises.week36.section131;

import bjorge.structure.Tabell;

import java.util.Arrays;

public class A123 {
    /*
    * Oppgave 1
    * Metodene fra Programkode 1.3.1 a) og
    * Programkode 1.3.1 b) er lagt til i samleklassen Tabell

    * Oppgave 2
    * Gitt flg. permutasjoner av tallene fra 1 til 6:
    * a) 2 3 6 1 4 5 -> 2 3 6 1 5 4
    * b) 2 3 6 1 5 4 -> 2 3 6 4 1 5
    * c) 2 3 1 6 5 4 -> 2 3 4 1 5 6
    * d) 2 3 6 5 4 1 -> 2 4 1 3 5 6
    * e) 2 6 5 4 3 1 -> 3 1 2 4 5 6
    * Finn, for hver av dem, den neste i leksikografisk rekkefølge.
    * Bruk så metoden nestePermutasjon som fasit.

    * Oppgave 3
    * Skriv opp de 10 første permutasjonene som kommer etter
    * 3 1 4 9 7 10 8 6 5 2
    * Bruk metoden nestePermutasjon som fasit.
    * 1. 3 1 4 9 8 2 5 6 7 10
    * 2. 3 1 4 9 8 2 5 6 10 7
    * 3. 3 1 4 9 8 2 5 7 6 10
    * 4. 3 1 4 9 8 2 5 7 10 6
    * 5. 3 1 4 9 8 2 5 10 6 7
    * 6. 3 1 4 9 8 2 5 10 7 6
    * 7. 3 1 4 9 8 2 6 5 7 10
    * 8. 3 1 4 9 8 2 6 5 10 7
    * 9. 3 1 4 9 8 2 6 7 5 10
    * 10. 3 1 4 9 8 2 6 7 10 5
    */
    public static void main(String[] args) {
       /*
        // Oppgave 2
        // Arrays med permutasjoner
        int[] a ={2, 3, 6, 1, 4, 5};
        int[] b ={2, 3, 6, 1, 5, 4};
        int[] c ={2, 3, 1, 6, 5, 4};
        int[] d ={2, 3, 6, 5, 4, 1};
        int[] e ={2, 6, 5, 4, 3, 1};
        // Endrer arraysa til dei neste permutasjonene
        Tabell.nestePermutasjon(a);
        Tabell.nestePermutasjon(b);
        Tabell.nestePermutasjon(c);
        Tabell.nestePermutasjon(d);
        Tabell.nestePermutasjon(e);
        // Skriver ut permutasjoner
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(e));

        */
        // Oppgave 3
        int [] a10 = {3, 1, 4, 9, 7, 10, 8, 6, 5, 2};

        for (int i = 0; i < 10; i++) {
            Tabell.nestePermutasjon(a10);
            System.out.println(Arrays.toString(a10));
        }



    }
}
