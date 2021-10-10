package bjorge.exercises.week37.section147;


import bjorge.eksempelKlasser.Funksjon;
import bjorge.eksempelKlasser.Komparator;
import bjorge.eksempelKlasser.Person;
import bjorge.eksempelKlasser.Student;
import bjorge.structure.Tabell;

import java.util.Arrays;

public class G12345 {
    public static void main(String[] args) {
        /* Kode fra avsnittet 1.4.7
        Integer[] a = {6,2,10,9,5,1,8,4,3,7};                            // Integer
        String[] s = {"Sohil","Per","Thanh","Ann","Kari","Jon"};         // String

        Tabell.innsettingssortering(a, (x, y) -> x.compareTo(y));         // lamda-uttrykk
        Tabell.innsettingssortering(s, (x,y) -> x.compareTo(y));         // lamda-uttrykk
        Tabell.innsettingssortering(a, Komparator.naturligOrden());
        Tabell.innsettingssortering(s, Komparator.naturligOrden());
        System.out.println(Arrays.toString(a));  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println(Arrays.toString(s));  // [Ann, Jon, Kari, Per, Sohil, Thanh]

        Tabell.innsettingssortering(a, Komparator.omvendtOrden());
        Tabell.innsettingssortering(s, Komparator.omvendtOrden());
        System.out.println(Arrays.toString(a));  // [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
        System.out.println(Arrays.toString(s));  // [Thanh, Sohil, Per, Kari, Jon, An



        Funksjon<Student,String> velger = x -> x.studium();
        Funksjon<Student,String> velger = Student::studium;  // metodenavn etter ::
        Komparator<Student> c = Komparator.orden(velger);
        Tabell.innsettingssortering(s, c); // Ellegangt kode
        System.out.println(Arrays.toString(s)); // Utskrift: [Per, Kari, Lars, Berit, Bodil, Anders]

        Tabell.innsettingssortering(a, Komparator.orden(Integer::toString));
        Tabell.innsettingssortering(a, Komparator.orden(x -> x.toString()));
        System.out.println(Arrays.toString(a)); // [1, 10, 100, 11, 13, 2, 21, 25, 3, 33]

         */
        Person[] p = new Person[5];                       // en persontabell
        p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
        p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
        p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
        p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
        p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

        Tabell.innsettingssortering(p, Komparator.orden(Person::etternavn));
        System.out.println(Arrays.toString(p));
    }
}
