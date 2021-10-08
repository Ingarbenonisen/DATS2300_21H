package bjorge.exercises.week37.section146;

import bjorge.eksempelKlasser.Komparator;
import bjorge.eksempelKlasser.Person;
import bjorge.eksempelKlasser.Student;
import bjorge.eksempelKlasser.Studium;
import bjorge.structure.Tabell;

import java.util.Arrays;

public class F12345_7 {
    public static void main(String... args)
    {
        Person[] p = new Person[5];                       // en persontabell
        p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
        p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
        p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
        p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
        p[4] = new Person("Bolle", "Alum");           // Kari Pettersen
/*
        class FornavnKomparator implements Komparator<Person>
        {
            public int compare(Person p1, Person p2)        // to personer
            {
                return p1.fornavn().compareTo(p2.fornavn());  // sammenligner fornavn
            }
        }

        Komparator<Person> c = new FornavnKomparator();   // en instans av klassen
        Tabell.innsettingssortering(p, c);                // se Programkode 1.4.6 b)

 */
        /*
        Komparator<Person> c = (p1,p2) -> p1.fornavn().compareTo(p2.fornavn());
        Tabell.innsettingssortering(p, c);                // se Programkode 1.4.6 b)
         */
        Student[] s = new Student[5];                                            // en studenttabell
        s[0] = new Student(p[0].fornavn(), p[0].etternavn(), Studium.Data);      // Kari Svendsen
        s[1] = new Student(p[1].fornavn(), p[1].etternavn(), Studium.IT);      // Boris Zukanovic
        s[2] = new Student(p[2].fornavn(), p[2].etternavn(), Studium.Anvendt);        // Ali Kahn
        s[3] = new Student(p[3].fornavn(), p[3].etternavn(), Studium.IT);       // Azra Zukanovic
        s[4] = new Student(p[4].fornavn(), p[4].etternavn(), Studium.Data);     // Kari Pettersen

        Tabell.innsettingssortering(s, (s1,s2) -> s1.studium().compareTo(s2.studium()));
        System.out.println(Arrays.toString(s));


        Komparator<Student> c = (s1,s2) ->
        {
            int cmp = s1.studium().compareTo(s2.studium());
            return cmp != 0 ? cmp : s1.compareTo(s2);
        };

        Tabell.innsettingssortering(s, c);    // Programkode 1.4.6 b)
        System.out.println(Arrays.toString(s));
    }
}
