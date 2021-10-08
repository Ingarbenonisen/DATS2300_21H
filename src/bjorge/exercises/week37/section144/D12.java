package bjorge.exercises.week37.section144;

import bjorge.eksempelKlasser.Heltall;
import bjorge.lecture.week37.Person;
import bjorge.structure.Tabell;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class D12 {
    public static void main(String[] args) {

        // Utskrift:

        // Boris Zukanovic er størst
        // [Ali Kahn, Kari Pettersen, Kari Svendsen, Azra Zukanovic, Boris Zukanovic]
        // Oppgave 1
        //d)
        Heltall x = new Heltall(3), y = new Heltall(3);  // x og y er like
        // Kommenter ut equals i Heltalls tabellen
        //før: 0 true
        //etter: 0 true
        System.out.println(x.compareTo(y) + "  " + x.equals(y));
        //e)
        // Kommenter ut hashCode i Heltalls tabellen
        //før: 34 34
        //etter: 1199823423  932172204
        System.out.println(x.hashCode() + "  " + y.hashCode());

        // Oppgave 2
        //Oppgave 2 a) b)
        Person[] p = new Person[5];                   // en persontabell

        p[0] = new Person("Kari","Svendsen");         // Kari Svendsen
        p[1] = new Person("Boris","Zukanovic");       // Boris Zukanovic
        p[2] = new Person("Ali","Kahn");              // Ali Kahn
        p[3] = new Person("Azra","Zukanovic");        // Azra Zukanovic
        p[4] = new Person("Kari","Pettersen");        // Kari Pettersen

        int m = Tabell.maks(p);                       // posisjonen til den største
        System.out.println(p[m] + " er størst");      // skriver ut den største

        Tabell.innsettingssortering(p);               // generisk sortering
        System.out.println(Arrays.toString(p));       // skriver ut sortert

        Stream s = Arrays.stream(p);
        Optional<Person> resultat = s.max(Comparator.naturalOrder());
        resultat.ifPresent(System.out::println);
        Arrays.stream(p).max(Comparator.naturalOrder()).ifPresent(System.out::println);
    }
}
