package bjorge.exercises.week37.section148;

import bjorge.eksempelKlasser.Komparator;
import bjorge.eksempelKlasser.Student;
import bjorge.structure.Tabell;
import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

// 1.4.8  Leksikografiske ordninger
public class H124 {
    public static void main(String[] args) {
        /* Endret i innsettingssortering slit at den kan ta inn metoder fra Comperator ikkje Komperator som i kode her.
         *  Derfor er den kommentert ut.

        Komparator<String> c_1 = (s1, s2) ->
        {
            int k = s1.length() - s2.length();
            return k != 0 ? k : s1.compareTo(s2);
        };

        String[] navn = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        Tabell.innsettingssortering(navn, c_1);

        System.out.println(Arrays.toString(navn));
        // Utskrift: [Per, Kari, Lars, Berit, Bodil, Anders]

        Komparator<String> c1 =     Komparator.orden(String::length);  // ordner etter lengde
        Komparator<String> c2 =     Komparator.naturligOrden();        // ordner alfabetisk

        Komparator<String> c_2  =   c1.deretter(c2);      // sammensetingen av c1 og c2

        Komparator<Student> c_3 =   Komparator.orden(Student::studium).
                                    deretter(Komparator.orden(Student::fornavn)).
                                    deretter(Komparator.orden(Student::etternavn));

        Komparator<Student> c_4 =   Komparator.orden(Student::studium).
                                    deretter(Student::fornavn).
                                    deretter(Student::etternavn);

        String[] s = {"OLE","Per","Kari","PER","Ole","kari","per","KARI","ole"};
        Tabell.innsettingssortering(s, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(s));
        // Utskrift: [Kari, kari, KARI, OLE, Ole, ole, Per, PER, per]
        Komparator<String> c = String::compareToIgnoreCase;
        Tabell.innsettingssortering(s, c.deretter(Komparator.omvendtOrden()));
        System.out.println(Arrays.toString(s));
        // [kari, Kari, KARI, ole, Ole, OLE, per, Per, PER]

        Arrays.sort(s, Collator.getInstance(Locale.US));  // finnes ingen norsk versjon
        System.out.println(Arrays.toString(s));
        // Utskrift: [kari, Kari, KARI, ole, Ole, OLE, per, Per, PER]



        String[] s = {"OLE","Per","Kari","PER","Ole","kari","per","KARI","ole"};

        Tabell.innsettingssortering(s, Komparator.orden(x -> x));
        System.out.println(Arrays.toString(s));

        Tabell.innsettingssortering(s, Komparator.naturligOrden());
        System.out.println(Arrays.toString(s));

        String[] s1 = {"21","18","8","13","20","6","16","25","3","10"};

        Komparator<String> c1 =     Komparator.orden(String::length);  // ordner etter lengde
        Tabell.innsettingssortering(s1, c1.deretter(x -> x)); // x -> x representererer f(x) = x
        System.out.println(Arrays.toString(s1));
         */
    }
}
