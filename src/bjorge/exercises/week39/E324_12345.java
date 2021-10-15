package bjorge.exercises.week39;

import bjorge.eksempelKlasser.Liste;
import bjorge.eksempelKlasser.TabellListe;

//  3.2.4  En indre iteratorklasse
public class E324_12345 {
    /*
    * Oppgave 1:
    * iterator-klasssen lagt inn i Tabellliste
    * Oppgave 2:
    * Test: arvede metoder fjernHvis, forEach:
    * Oppgave 3:
    * Metoden fjernHvis() arves fra Beholder.
    * Kod den i TabellListe og da direkte uten å bruke iteratorens remove-metode.
    * Oppgave 4:
    * Klassen TabellListe arver metoden forEach() fra Iterable.
    * Kod den i TabellListe og da direkte uten å bruke iteratoren.
    * Oppgave 5:
    * Kod metoden forEachRemaining() direkte i TabellListeIterator.
    *
     */
    public static void main(String[] args) {
        //Oppgave 2
        System.out.println("Oppgave 2: ");
        String[] s = {"Jens","Per","Kari","Ole","Berit","Jens","Anne","Nils","Siv"};

        Liste<String> liste = new TabellListe<>();

        for (String navn : s) liste.leggInn(0,navn);  // legger inn først

        System.out.println("Vi henter " + liste.hent(5) + ".");

        System.out.println("Nils er på plass " + liste.indeksTil("Nils") + "!");

        liste.oppdater(2,"Anna");  // bytter ut Anne med Anna på plass 2

        System.out.println(liste.fjern(0) + " er slettet!");

        System.out.println("Listeinnhold: " + liste);

        liste.fjernHvis(x -> x.equals("Jens"));  // fjerner alle forekomster av Jens

        liste.forEach(x -> System.out.print(x + " "));

        //Oppgave 3
        System.out.println("Oppgave 3: ");


    }
}
