package bjorge.structure;

import bjorge.eksempelKlasser.Kø;
import bjorge.eksempelKlasser.Oppgave;
import bjorge.eksempelKlasser.TabellKø;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringJoiner;
import java.util.function.ObjIntConsumer;

public class BinTre<T>           // et generisk binærtre
{

    private static final class Node<T>  // en indre nodeklasse
    {
        private T verdi;            // nodens verdi
        private Node<T> venstre;    // referanse til venstre barn/subtre
        private Node<T> høyre;      // referanse til høyre barn/subtre

        private Node(T verdi, Node<T> v, Node<T> h)    // konstruktør
        {
            this.verdi = verdi; venstre = v; høyre = h;
        }

        private Node(T verdi) { this.verdi = verdi; }  // konstruktør

    } // class Node<T>

    private Node<T> rot;      // referanse til rotnoden
    private int antall;       // antall noder i treet

    public BinTre() { rot = null; antall = 0; }          // konstruktør

    public BinTre(int[] posisjon, T[] verdi)  // konstruktør
    {
        if (posisjon.length > verdi.length) throw new
                IllegalArgumentException("Verditabellen har for få elementer!");

        for (int i = 0; i < posisjon.length; i++) leggInn(posisjon[i],verdi[i]);
    }

    public final void leggInn(int posisjon, T verdi)  // final: kan ikke overstyres
    {
        if (posisjon < 1) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") < 1!");

        Node<T> p = rot, q = null;    // nodereferanser

        int filter = Integer.highestOneBit(posisjon) >> 1;   // filter = 100...00

        while (p != null && filter > 0)
        {
            q = p;
            p = (posisjon & filter) == 0 ? p.venstre : p.høyre;
            filter >>= 1;  // bitforskyver filter
        }

        if (filter > 0) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") mangler forelder!");
        else if (p != null) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") finnes fra før!");

        p = new Node<>(verdi);          // ny node

        if (q == null) rot = p;         // tomt tre - ny rot
        else if ((posisjon & 1) == 0)   // sjekker siste siffer i posisjon
            q.venstre = p;                // venstre barn til q
        else
            q.høyre = p;                  // høyre barn til q

        antall++;                       // en ny verdi i treet
    }

    public int antall() { return antall; }               // returnerer antallet

    public boolean tom() { return antall == 0; }         // tomt tre?

    private Node<T> finnNode(int posisjon)  // finner noden med gitt posisjon
    {
        if (posisjon < 1) return null;

        Node<T> p = rot;   // nodereferanse
        int filter = Integer.highestOneBit(posisjon >> 1);   // filter = 100...00

        for (; p != null && filter > 0; filter >>= 1)
            p = (posisjon & filter) == 0 ? p.venstre : p.høyre;

        return p;   // p blir null hvis posisjon ikke er i treet
    }

    public boolean finnes(int posisjon)
    {
        return finnNode(posisjon) != null;
    }

    public T hent(int posisjon)
    {
        Node<T> p = finnNode(posisjon);

        if (p == null) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") finnes ikke i treet!");

        return p.verdi;
    }

    public T oppdater(int posisjon, T nyverdi)
    {
        Node<T> p = finnNode(posisjon);

        if (p == null) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") finnes ikke i treet!");

        T gammelverdi = p.verdi;
        p.verdi = nyverdi;

        return gammelverdi;
    }
    // Oppgaver 5.1.5
    // Oppgave 8
    public int nodetype(int posisjon)
    {
        if (posisjon < 1) throw new IllegalArgumentException("Må ha posisjon > 0!");

        Node<T> p = finnNode(posisjon);

        if (p == null)
            return -1; // posisjon er utenfor treet
        else if (p.venstre != null || p.høyre != null)
            return 0; // posisjon er en indre node
        else return 1;  // posisjon er en bladnode
    }
    //Oppgave 9
    public T fjern(int posisjon)
    {
        if (posisjon < 1) throw new
                IllegalArgumentException("Posisjon(" + posisjon + ") < 1!");

        Node<T> p = rot, q = null;               // hjelpepekere
        int filter = Integer.highestOneBit(posisjon >> 1);   // binært siffer

        while (p != null && filter > 0)
        {
            q = p;
            p = (filter & posisjon) == 0 ? p.venstre : p.høyre;
            filter >>= 1;
        }

        if (p == null) throw new
                IllegalArgumentException("Posisjon(" + posisjon + ") er utenfor treet!");

        if (p.venstre != null || p.høyre != null) throw new
                IllegalArgumentException("Posisjon(" + posisjon + ") er ingen bladnode!");

        if (p == rot) rot = null;
        else if (p == q.venstre) q.venstre = null;
        else q.høyre = null;

        antall--;  //
        return p.verdi;
    }
    // 5.5.6

    public void nivåorden(Oppgave<? super T> oppgave)                // skal ligge i class BinTre
    {
        if (tom()) return;                   // tomt tre

        Kø<Node<T>> kø = new TabellKø<>();   // Se Avsnitt 4.2.2
        kø.leggInn(rot);                     // legger inn roten

        while (!kø.tom())                    // så lenge som køen ikke er tom
        {
            Node<T> p = kø.taUt();             // tar ut fra køen
            oppgave.utførOppgave(p.verdi);     // den generiske oppgaven

            if (p.venstre != null) kø.leggInn(p.venstre);
            if (p.høyre != null) kø.leggInn(p.høyre);
        }
    }

    public int[] nivåer()   // returnerer en tabell som inneholder nivåantallene
    {
        if (tom()) return new int[0];       // en tom tabell for et tomt tre

        int[] a = new int[8];               // hjelpetabell
        Kø<Node<T>> kø = new TabellKø<>();  // hjelpekø
        int nivå = 0;                       // hjelpevariabel

        kø.leggInn(rot);    // legger roten i køen

        while (!kø.tom())   // så lenge som køen ikke er tom
        {
            // utvider a hvis det er nødvendig
            if (nivå == a.length) a = Arrays.copyOf(a,2*nivå);

            int k = a[nivå] = kø.antall();  // antallet på dette nivået

            for (int i = 0; i < k; i++)  // alle på nivået
            {
                Node<T> p = kø.taUt();

                if (p.venstre != null) kø.leggInn(p.venstre);
                if (p.høyre != null) kø.leggInn(p.høyre);
            }

            nivå++;  // fortsetter på neste nivå
        }

        return Arrays.copyOf(a, nivå);  // fjerner det overflødige
    }


    // 5.1.7

    // V1 - er mest effektiv
    private static <T> void preorden(Node<T> p, Oppgave<? super T> oppgave)
    {
        oppgave.utførOppgave(p.verdi);                       // utfører oppgaven

        if (p.venstre != null) preorden(p.venstre,oppgave);  // til venstre barn
        if (p.høyre != null) preorden(p.høyre,oppgave);      // til høyre barn
    }

    public void preorden(Oppgave<? super T> oppgave)
    {
        if (!tom()) preorden(rot,oppgave);  // sjekker om treet er tomt
    }

    // V2
    /*
    private static <T> void preorden(Node<T> p, Oppgave<? super T> oppgave)
    {
        if (p != null)  // metoden returnerer hvis p == null
        {
            oppgave.utførOppgave(p.verdi);

            preorden(p.venstre,oppgave);
            preorden(p.høyre,oppgave);
        }
    }

    public void preorden(Oppgave <? super T> oppgave)
    {
        preorden(rot,oppgave);
    }

     */

    private static <T> void inorden(Node<T> p, Oppgave<? super T> oppgave)
    {
        if (p.venstre != null) inorden(p.venstre,oppgave);
        oppgave.utførOppgave(p.verdi);
        if (p.høyre != null) inorden(p.høyre,oppgave);
    }

    public void inorden(Oppgave <? super T> oppgave)
    {
        if (!tom()) inorden(rot,oppgave);
    }

    public String toString()
    {
        StringJoiner s = new StringJoiner(", ", "[", "]");
        if (!tom()) inorden(x -> s.add(x != null ? x.toString() : "null"));
        return s.toString();
    }

    public T førstInorden()
    {
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        Node<T> p = rot;
        while (p.venstre != null) p = p.venstre;

        return p.verdi;
    }

    public T førstPostorden()
    {
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        Node<T> p = rot;
        while (true)
        {
            if (p.venstre != null) p = p.venstre;
            else if (p.høyre != null) p = p.høyre;
            else return p.verdi;
        }
    }

    private static
    <T> Node<T> trePreorden(T[] preorden, int rot, T[] inorden, int v, int h)
    {
        if (v > h) return null;  // tomt intervall -> tomt tre
        int k = v; T verdi = preorden[rot];
        while (!verdi.equals(inorden[k])) k++;  // finner verdi i inorden[v:h]

        Node<T> venstre = trePreorden(preorden, rot + 1, inorden, v, k - 1);
        Node<T> høyre   = trePreorden(preorden, rot + 1 + k - v, inorden, k + 1, h);

        return new Node<>(verdi, venstre, høyre);
    }
    public static <T> BinTre<T> trePreorden(T[] preorden, T[] inorden)
    {
        BinTre<T> tre = new BinTre<>();
        tre.rot = trePreorden(preorden, 0, inorden, 0, inorden.length - 1);

        tre.antall = preorden.length;
        return tre;
    }

    private static <T> void
    preorden(Node<T> p, int k, ObjIntConsumer<? super T> oppgave)
    {
        oppgave.accept(p.verdi, k);
        if (p.venstre != null) preorden(p.venstre, 2*k, oppgave);
        if (p.høyre != null) preorden(p.høyre, 2*k + 1, oppgave);
    }

    public void preorden(ObjIntConsumer<? super T> oppgave)
    {
        if (!tom()) preorden(rot, 1, oppgave);  // roten har posisjon 1
    }

    // Oppgave 7
    private static <T> void postorden(Node<T> p, Oppgave<? super T> oppgave)
    {
        if (p.venstre != null) postorden(p.venstre,oppgave);
        if (p.høyre != null) postorden(p.høyre,oppgave);
        oppgave.utførOppgave(p.verdi);
    }

    public void postorden(Oppgave<? super T> oppgave)
    {
        if (rot != null) postorden(rot,oppgave);
    }

    // Oppgave 8
    public void nullstill()
    {
        if (!tom()) nullstill(rot);  // nullstiller
        rot = null; antall = 0;      // treet er nå tomt
    }

    private void nullstill(Node<T> p)
    {
        if (p.venstre != null)
        {
            nullstill(p.venstre);      // venstre subtre
            p.venstre = null;          // nuller peker
        }
        if (p.høyre != null)
        {
            nullstill(p.høyre);        // høyre subtre
            p.høyre = null;            // nuller peker
        }
        p.verdi = null;              // nuller verdien
    }



} // class BinTre<T>