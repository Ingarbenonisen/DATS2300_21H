////////////////// class SBinTre //////////////////////////////
package bjorge.eksempelKlasser;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

public class SBinTre<T> // implements Beholder<T>
{

    private static final class Node<T> // en indre nodeklasse
    {
        private T verdi;                 // nodens verdi
        private Node<T> venstre, høyre;  // venstre og høyre barn

        private Node(T verdi, Node<T> v, Node<T> h)  // konstruktør
        {
            this.verdi = verdi; venstre = v; høyre = h;
        }

        private Node(T verdi)  // konstruktør
        {
            this(verdi, null, null);
        }

    } // class Node

    private Node<T> rot;                       // peker til rotnoden
    private int antall;                        // antall noder
    private final Comparator<? super T> comp;  // komparator

    public SBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null; antall = 0; comp = c;
    }

    public static <T extends Comparable<? super T>> SBinTre<T> sbintre()
    {
        return new SBinTre<>(Comparator.naturalOrder());
    }

    public static <T> SBinTre<T> sbintre(Comparator<? super T> c)
    {
        return new SBinTre<>(c);
    }
    // 5.2.3
    public static <T> SBinTre<T> sbintre(Stream<T> s, Comparator<? super T> c)
    {
        SBinTre<T> tre = new SBinTre<>(c);             // komparatoren c
        s.forEach(tre::leggInn);                       // bygger opp treet
        return tre;                                    // treet returneres
    }
    public static <T extends Comparable<? super T>> SBinTre<T> sbintre(Stream<T> s)
    {
        return sbintre(s, Comparator.naturalOrder());  // naturlig ordning
    }

    public static <T extends Comparable<? super T>> SBinTre<T> naturligOrdenTre()
    {
        return new SBinTre<>(Comparator.naturalOrder());
    }

    public static <T> SBinTre<T> komparatorTre(Comparator<? super T> c)
    {
        return new SBinTre<>(c);
    }

    public static <T> SBinTre<T> komparatorTre(T[] a, Comparator<? super T> c)
    {
        SBinTre<T> tre = new SBinTre<>(c);          // komparatoren c
        for (T verdi : a) tre.leggInn(verdi);       // bygger opp treet
        return tre;                                 // treet returneres
    }

    public static <T extends Comparable<? super T>> SBinTre<T> naturligOrdenTre(T[] a)
    {
        return komparatorTre(a, Comparator.naturalOrder());  // naturlig ordning
    }


    public final boolean leggInn(T verdi)    // skal ligge i class SBinTre
    {
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                             // hjelpevariabel

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi,p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<>(verdi);                   // oppretter en ny node

        if (q == null) rot = p;                  // p blir rotnode
        else if (cmp < 0) q.venstre = p;         // venstre barn til q
        else q.høyre = p;                        // høyre barn til q

        antall++;                                // én verdi mer i treet
        return true;                             // vellykket innlegging
    }

    public int antall()        // antall verdier i treet
    {
        return antall;
    }

    public boolean tom()       // er treet tomt?
    {
        return antall == 0;
    }

    public void nullstill()
    {
        rot = null; antall = 0;
    }

    private static int høyde(Node<?> p)  // ? betyr vilkårlig type
    {
        if (p == null) return -1;          // et tomt tre har høyde -1

        return 1 + Math.max(høyde(p.venstre), høyde(p.høyre));
    }

    public int høyde()
    {
        return høyde(rot);                 // kaller hjelpemetoden
    }

    public String toString()                   // hører til SBinTre
    {
        StringBuilder s = new StringBuilder();   // StringBuilder
        s.append('[');                           // starter med [
        if (!tom()) toString(rot,s);             // den rekursive metoden
        s.append(']');                           // avslutter med ]
        return s.toString();                     // returnerer
    }

    private static <T> void toString(Node<T> p, StringBuilder s)
    {
        if (p.venstre != null)                   // p har et venstre subtre
        {
            toString(p.venstre, s);                // komma og mellomrom etter
            s.append(',').append(' ');             // den siste i det venstre
        }                                        // subtreet til p

        s.append(p.verdi);                       // verdien i p

        if (p.høyre != null)                     // p har et høyre subtre
        {
            s.append(',').append(' ');             // komma og mellomrom etter
            toString(p.høyre, s);                  // p siden p ikke er den
        }                                        // siste noden i inorden
    }

    public boolean inneholder(T verdi)          // ny versjon
    {
        if (verdi == null) return false;          // treet har ikke nullverdier

        Node<T> p = rot;                          // starter i roten
        Node<T> q = null;                         // hjelperefranse

        while (p != null)                         // sjekker p
        {
            if (comp.compare(verdi, p.verdi) < 0)   // sammenligner
            {
                p = p.venstre;                        // går til venstre
            }
            else
            {
                q = p;                                // oppdaterer q
                p = p.høyre;                          // går til høyre
            }
        }

        return q == null ? false : comp.compare(verdi,q.verdi) == 0;
    }

    // 5.2.5 Fra ordnet tabell til binært søketre
    private static <T> Node<T> balansert(T[] a, int v, int h)  // en rekursiv metode
    {
        if (v > h) return null;                       // tomt intervall -> tomt tre

        int m = (v + h)/2;                            // midten
        T verdi = a[m];                               // midtverdien

        while (v < m && verdi.equals(a[m-1])) m--;    // til venstre

        Node<T> p = balansert(a, v, m - 1);           // venstre subtre
        Node<T> q = balansert(a, m + 1, h);           // høyre subtre

        return new Node<>(verdi, p, q);               // rotnoden
    }

    public static <T> SBinTre<T> balansert(T[] a, Comparator<? super T> c)
    {
        SBinTre<T> tre = new SBinTre<>(c);          // oppretter et tomt tre
        tre.rot = balansert(a, 0, a.length - 1);    // bruker den rekursive metoden
        tre.antall = a.length;                      // setter antallet
        return tre;                                 // returnerer treet
    }

    public static <T extends Comparable<? super T>> SBinTre<T> balansert(T[] a)
    {
        return balansert(a, Comparator.naturalOrder());
    }

    // 5.2.7 Min, maks, gulv, tk, mindre, større

    public T min()                 // skal returnere treets minste verdi
    {
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        Node<T> p = rot;                            // starter i roten
        while (p.venstre != null) p = p.venstre;    // går mot venstre
        return p.verdi;                             // den minste verdien
    }
    // Skrivd selv, skal skrive ute den siste gulv verdien, er det riktig?
    public T gulv(T verdi)
    {
        Objects.requireNonNull(verdi, "Treet har ingen nullverdier!");
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        Node<T> p = rot; T gulv = null;

        while (p != null)
        {
            int cmp = comp.compare(verdi, p.verdi);

            if (cmp < 0) p = p.venstre;  // gulvet ligger til venstre
            else if (cmp > 0)
            {
                gulv = p.verdi;            // nodeverdien er en kandidat
                p = p.høyre;
            }
            else if (gulv == p.verdi){
                gulv = p.verdi;
            }
            else {         // verdi ligger i treet
                return p.verdi;
            }
        }
        return gulv;
    }
    // Den fra kompendiet
    public T gulv2(T verdi)
    {
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        Node<T> p = rot;
        T gulv = null;

        while (p != null)
        {
            int cmp = comp.compare(verdi, p.verdi);

            if (cmp < 0) p = p.venstre;  // gulv(verdi) ligger til venstre
            else
            {
                gulv = p.verdi;            // nodeverdien er en kandidat
                p = p.høyre;
            }
        }

        return gulv;
    }

    public T større(T verdi)
    {
        if (tom()) throw new NoSuchElementException("Treet er tomt!");
        if (verdi == null) throw new NullPointerException("Ulovlig nullverdi!");

        Node<T> p = rot;
        T større = null;

        while (p != null)
        {
            int cmp = comp.compare(verdi, p.verdi);

            if (cmp < 0)
            {
                større = p.verdi;  // en kandidat
                p = p.venstre;
            }
            else                 // den må ligge til høyre
            {
                p = p.høyre;
            }
        }

        return større;
    }
    // 5.2.7
    // Oppgave 1 og 2
    public T maks()                 // skal returnere treets minste verdi
    {
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        Node<T> p = rot; // starter i roten
        Node<T> q = rot;
        while (p.høyre != null) {
            p = p.høyre;    // går mot høgre
            if (comp.compare(p.verdi,q.verdi) > 0) q = p;
        }
            return q.verdi;                             // den største verdien
    }
    // Oppgave 5
    public T tak(T verdi)
    {
        if (tom())
        {
            throw new NoSuchElementException("Treet er tomt!");
        }

        Node<T> p = rot;
        T tak = null;

        while (p != null)
        {
            int cmp = comp.compare(verdi, p.verdi);

            if (cmp < 0)
            {
                tak = p.verdi;
                p = p.venstre;
            }
            else if (cmp > 0)
            {
                p = p.høyre;
            }
            else
            {
                return p.verdi;
            }
        }

        return tak;
    }
    // Oppgave 6
    public T mindre(T verdi)
    {
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        Node<T> p = rot;
        T mindre = null;

        while (p != null)
        {
            int cmp = comp.compare(verdi, p.verdi);

            if (cmp <= 0)
            {
                p = p.venstre;
            }
            else
            {
                mindre = p.verdi;
                p = p.høyre;
            }
        }

        return mindre;
    }

} // class SBinTre 