package bjorge.structure;
import java.util.*;

public class Tabell     // Samleklasse for tabellmetoder
{
    private Tabell() {}   // privat standardkonstruktør - hindrer instansiering

    // Metoden bytt(int[] a, int i, int j)       Programkode 1.1.8 d)
    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    // Metoden randPerm(int n)                   Programkode 1.1.8 e)
    public static int[] randPerm(int n)
    {
        Random r = new Random();                 // en randomgenerator
        int[] a = new int[n];                    // en tabell med plass til n tall

        for (int i = 0; i < n; i++)
            a[i] = r.nextInt(n) + 1;             // tabellen fylles med tall

        return a;                                // tabellen returneres
    }

    // Metoden randPerm(int[] a)                 Programkode 1.1.8 f)
    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    // Metoden maks(int[] a, int fra, int til)   Programkode 1.2.1 b)
    public static int maks(int[] a, int fra, int til)
    {
        /*if (fra < 0 || til > a.length || fra >= til)
        {
            throw new IllegalArgumentException("Illegalt intervall!");
        }*/
        if (a == null) throw new NullPointerException
                ("parametertabellen a er null!");

        fratilKontroll(a.length, fra, til);

        if (fra == til) throw new NoSuchElementException
                ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }
    // Metoden maks(int[] a)                     Programkode 1.2.1 c)
    public static int maks(int[] a)  // bruker hele tabellen
    {
        return maks(a,0,a.length);     // kaller metoden over
    }

    // min-metodene - se Oppgave 1 i Avsnitt 1.2.1
    public static int minHalvaapentI(int[] a, int fra, int til)
    {
        if (fra < 0 || til > a.length || fra >= til)
        {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = fra;              // indeks til minste verdi i a[fra:til>
        int minverdi = a[fra];   // minste verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] < minverdi)
            {
                m = i;                // indeks til minste verdi oppdateres
                minverdi = a[m];     // minste verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    public static int minTabell(int[] a)  // bruker hele tabellen
    {
        return minHalvaapentI(a,0,a.length);     // kaller metoden over
    }

    // maks3 metode
    public static int maksHalvaapentI3(int[] a, int fra, int til)  // versjon 3 av maks-metoden
    {
        int sist = a.length - 1;       // siste posisjon i tabellen
        int m = 0;                     // indeks til største verdi
        int maksverdi = a[0];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = 0x7fffffff;          // legger tallet 2147483647 sist

        for (int i = 0; ; i++)         // i starter med 0
            if (a[i] >= maksverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : m;   // er siste størst?
                }
                else
                {
                    maksverdi = a[i];        // maksverdi oppdateres
                    m = i;                   // m oppdateres
                }
            }
    } // maks

    public static int maks3(int[] a){
        return maksHalvaapentI3(a, 0, a.length);
    }

    //Bytt om innholdet i posisjon i og j  i char-tabellen c
    public static void bytt(char[] c, int i, int j){
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    // Kontrllerer om intervallet er lovlig
    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    //Metoden skal skrive ut tallene i intervallet a[fra:til> til konsollet
    public static void skrivI(int[] a, int fra, int til)
    {
        fratilKontroll(a.length, fra, til);
        if (til - fra > 0) System.out.print(a[fra]);
        for (int i = fra + 1; i < til; i++) System.out.print(" " + a[i]);
    }

    public static void skriv(int[] a)
    {
        skrivI(a, 0, a.length);
    }

    // Samme som over bare med linjeskifte på slutten
    public static void skrivlnI(int[] a, int fra, int til)
    {
        skrivI(a,fra,til);
        System.out.println();

    }

    public static void skrivln(int[] a)
    {
        skrivlnI(a, 0, a.length);
    }

    //Sjekker om intervallet er lovlig
    public static void vhKontroll(int tablengde, int v, int h)
    {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }
    public static int[] nestMaks(int[] a) // ny versjon                             Opperasjoner:
    {
        int n = a.length;     // tabellens lengde                                       #1
        if (n < 2) throw      // må ha minst to verdier                                 #2
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = 0;      // m er posisjonen til største verdi                            #1
        int nm = 1;     // nm er posisjonen til nest største verdi                      #1

        // bytter om m og nm hvis a[1] er større enn a[0]                               #n*3
        if (a[1] > a[0])
        {
            m = 1;
            nm = 0;
        }

        int maksverdi = a[m];                // største verdi
        int nestmaksverdi = a[nm];           // nest største verdi

        for (int i = 2; i < n; i++)
        {
            if (a[i] > nestmaksverdi)
            {
                if (a[i] > maksverdi)
                {
                    nm = m;
                    nestmaksverdi = maksverdi;     // ny nest størst

                    m = i;
                    maksverdi = a[m];              // ny størst
                }
                else
                {
                    nm = i;
                    nestmaksverdi = a[nm];         // ny nest størst
                }
            }
        } // for

        return new int[] {m,nm};    // n i posisjon 0, nm i posisjon 1

    } // nestMaks

    public static int[] indekssortering(int[] a) {
        int[] indeksTabell = new int[a.length];
        int[] hjelpeTabell = new int[a.length];
        if (a.length == 0) {
            return indeksTabell;
        }
        //Fant til slutt ut at detta ikkje fungerte for ein eller ana grunn
        //int[] hjelpeTabell = a.
        //Men og lage hjelpevariablen slik fungerte.
        for (int i = 0; i < a.length; i++) {
            hjelpeTabell[i] = a[i];
        }
        //Hjelpemetoder.bobblesortering(hjelpeTabell);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (hjelpeTabell[i] == a[j]) {
                    indeksTabell[i] = j;
                }
            }
        }
        return indeksTabell;
    }

}