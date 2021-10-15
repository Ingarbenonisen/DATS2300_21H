package bjorge.exercises.week39;

import bjorge.eksempelKlasser.Liste;
import bjorge.eksempelKlasser.TabellListe;

public class C322_123 {
    /*
    * Oppgave 1:
    * Lagt inn klassen TabellListe<T> implements Liste<T>
    * Oppgave 2:
    * Lag en String-tabell s, en instans av TabellListe med
    * s som parameter og sjekk at aksessor-metodene virker som de skal.
    * Sjekk at det virker hvis s har en eller flere null-er.
     */
    public static void main(String[] args) {
        String[] s = {"Sohil",null,"Per","Thanh","Ann","Kari","Jon",null};
        Liste<String> liste = new TabellListe<>(s);
        // liste inneholder nå: "Sohil","Per","Thanh","Ann","Kari","Jon"

        System.out.println(liste.hent(4));
        System.out.println(liste.indeksTil("Kari"));
        System.out.println(liste.inneholder("Kari"));
    }

}
