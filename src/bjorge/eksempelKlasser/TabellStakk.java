package bjorge.eksempelKlasser;
import java.util.*;

public class TabellStakk<T> implements Stakk<T> {
    private T[] a;                     // en T-tabell
    private int antall;                // antall verdier på stakken

    public TabellStakk()               // konstruktør - tabellengde 8
    {
        this(8);
    }

    @SuppressWarnings("unchecked")     // pga. konverteringen: Object[] -> T[]
    public TabellStakk(int lengde)     // valgfri tabellengde
    {
        if (lengde < 0)
            throw new IllegalArgumentException("Negativ tabellengde!");

        a = (T[]) new Object[lengde];     // oppretter tabellen
        antall = 0;                      // stakken er tom
    }

// de andre metodene skal inn her!
public void leggInn(T verdi)
{
    if (antall == a.length)
        a = Arrays.copyOf(a, antall == 0 ? 1 : 2*antall);   // dobler

    a[antall++] = verdi;
}

    public T kikk()
    {
        if (antall == 0)       // sjekker om stakken er tom
            throw new NoSuchElementException("Stakken er tom!");

        return a[antall-1];    // returnerer den øverste verdien
    }

    public T taUt()
    {
        if (antall == 0)       // sjekker om stakken er tom
            throw new NoSuchElementException("Stakken er tom!");

        antall--;             // reduserer antallet

        T temp = a[antall];   // tar var på det øverste objektet
        a[antall] = null;     // tilrettelegger for resirkulering

        return temp;          // returnerer den øverste verdien
    }

    public boolean tom() { return antall == 0; }

    // Oppgave 1
    @Override
    public void nullstill() {
        for (int i = 0; i < antall; i++) a[i] = null;
        antall = 0;
    }

    public int antall() { return antall; }
    // Oppgave 2
    @Override
    public String toString()   // bruker StringJoiner
    {
        StringJoiner s = new StringJoiner(", ", "[", "]");
        for (int i = antall - 1; i >= 0; i--) s.add(a[i] == null ? "null" : a[i].toString());
        return s.toString();
    }

    public String toString2()  // bruker StringBuilder
    {
        if (tom()) return "[]";

        StringBuilder s = new StringBuilder();
        s.append('[');
        s.append(a[antall-1]);

        for (int i = antall - 2; i >= 0; i--)
            s.append(',').append(' ').append(a[i]);

        s.append(']');
        return s.toString();
    }

    //Oppgave 3

    public static <T> void snu(Stakk<T> A)
    {
        Stakk<T> B = new TabellStakk<T>();
        Stakk<T> C = new TabellStakk<T>();

        while (!A.tom()) B.leggInn(A.taUt());
        while (!B.tom()) C.leggInn(B.taUt());
        while (!C.tom()) A.leggInn(C.taUt());
    }
    //Oppgave 4

    public static <T> void kopier(Stakk<T> A, Stakk<T> B)
    {
        Stakk<T> C = new TabellStakk<T>();
        while (!A.tom()) C.leggInn(A.taUt());
        while (!C.tom())
        {
            T t = C.taUt();
            B.leggInn(t);
            A.leggInn(t);
        }
    }

    // sorterer slik at den minste kommer øverst på stakken

    public static <T> void sorter(Stakk<T> A, Comparator<T> c)
    {
        Stakk<T> B = new TabellStakk<T>();
        T temp; int n = 0;

        while (!A.tom())
        {
            temp = A.taUt();
            n = 0;
            while (!B.tom() && c.compare(temp,B.kikk()) < 0)
            {
                n++; A.leggInn(B.taUt());
            }
            B.leggInn(temp);
            for (int i = 0; i < n; i++) B.leggInn(A.taUt());
        }

        while (!B.tom()) A.leggInn(B.taUt());
    }

} // class TabellSTakk
