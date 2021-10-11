package bjorge.structure;
import bjorge.eksempelKlasser.Komparator;

import java.util.*;

public class Tabell     // Samleklasse for tabellmetoder
{
    private Tabell() {}   // privat standardkonstruktør - hindrer instansiering


    public static int fak(int n)      //Metode fak(int n)
    {
        int n_fakultet=1;
        for (int i=2; i<n; ++i) {
            n_fakultet = n_fakultet*n;
        }
        return n_fakultet;
    }



    public static int[] randPerm(int n)     // Metoden randPerm(int n) returnerer int[]                 Programkode 1.1.8 e)
    {
        Random r = new Random();                 // en randomgenerator
        int[] a = new int[n];                    // en tabell med plass til n tall

        for (int i = 0; i < n; i++)
            a[i] = r.nextInt(n) + 1;             // tabellen fylles med tall

        return a;                                // tabellen returneres
    }

    public static void randPerm(int[] a)        // Metoden randPerm(int[] a), stokker om a              Programkode 1.1.8 f)
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    public static Integer[] randPermInteger(int n)
    {
        Integer[] a = new Integer[n];               // en Integer-tabell
        Arrays.setAll(a, i -> i + 1);               // tallene fra 1 til n

        Random r = new Random();   // hentes fra  java.util

        for (int k = n - 1; k > 0; k--)
        {
            int i = r.nextInt(k+1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);             // bytter om
        }
        return a;  // tabellen med permutasjonen returneres
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
    public static int min(int[] a, int fra, int til) // Halvåpent intervall
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

    public static int min(int[] a)  // bruker hele tabellen
    {
        return min(a,0,a.length);     // kaller metoden over
    }

    public static int maks3(int[] a, int fra, int til)  // versjon 3 av maks-metoden med Halvaapent intervall
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

    public static int maks3(int[] a)
    {
        return maks3(a, 0, a.length);
    }

    //Maks generics metode
    public static
    <T extends Comparable<? super T>>
    int maks_generic(T[] a, int fra, int til)
    {
        if (a == null) throw new NullPointerException("parametertabellen a er null!");
        fratilKontroll(a.length, fra, til);
        if (fra == til) throw new NoSuchElementException("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        // indeks til største verdi i a[fra:til>
        int m = fra;
        // største verdi i a[fra:til>
        T maksverdi = a[fra];
        for (int i = fra + 1; i < til; i++)
        {
            if (a[i].compareTo(maksverdi) > 0)
            {
                // indeks til største verdi oppdateres
                m = i;
                // største verdi oppdateres
            }
                maksverdi = a[m];
        }
        // posisjonen til største verdi i a[fra:til>
        return m;
    }

    public static
    <T extends Comparable<? super T>>
    int maks_generic(T[] a){
        return maks_generic(a, 0, a.length);
    }

    public static <T extends Comparable<? super T>> int maks(T[] a) // fra 1.4.2
    {
        int m = 0;                     // indeks til største verdi
        T maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    } // maks

    public static void bytt(char[] c, int i, int j) //Bytt om innholdet i posisjon i og j  i char-tabellen c
    {
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    public static void bytt(int[] a, int i, int j)  // Metoden bytt(int[] a, int i, int j)       Programkode 1.1.8 d)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static void bytt(Object[] a, int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void fratilKontroll(int tablengde, int fra, int til)  // Kontrllerer om intervallet er lovlig
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


    public static void skrivI(int[] a, int fra, int til)    //Metoden skal skrive ut tallene i intervallet a[fra:til> til konsollet
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

    public static void skrivln(int[] a, int i, int antall)
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

    public static void skriv(Object[] a, int fra, int til)
    {
        fratilKontroll(a.length,fra,til);

        for (int i = fra; i < til; i++) System.out.print(a[i] + " ");
    }

    public static void skriv(Object[] a)
    {
        skriv(a,0,a.length);
    }

    public static void skrivln(Object[] a, int fra, int til)
    {
        skriv(a,fra,til);
        System.out.println();
    }

    public static void skrivln(Object[] a)
    {
        skrivln(a,0,a.length);
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

    public static double harmonisk(int n)
    {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) sum += 1.0/i;
        return sum;
    }

    public static void kopier(int[] a, int i, int[] b, int j, int ant)
    {
        for (int n = i + ant; i < n; ) b[j++] = a[i++];
    }

    public static void snu(int[] a, int v, int h)  // snur intervallet a[v:h]
    {
        while (v < h) bytt(a, v++, h--);
    }

    public static void snu(int[] a, int v)  // snur fra og med v og ut tabellen
    {
        snu(a, v, a.length - 1);
    }

    public static void snu(int[] a)  // snur hele tabellen
    {
        snu(a, 0, a.length - 1);
    }

    public static boolean nestePermutasjon(int[] a) // finner neste permutasjon
    {
        int i = a.length - 2;                    // i starter nest bakerst
        while (i >= 0 && a[i] > a[i + 1]) i--;   // går mot venstre
        if (i < 0) return false;                 // a = {n, n-1, . . . , 2, 1}

        int j = a.length - 1;                    // j starter bakerst
        while (a[j] < a[i]) j--;                 // stopper når a[j] > a[i]
        bytt(a,i,j); snu(a,i + 1);               // bytter og snur

        return true;                             // en ny permutasjon
    }

    public static int inversjoner(int[] a)
    {
        int antall = 0;  // antall inversjoner
        for (int i = 0; i < a.length - 1; i++)
        {
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[i] > a[j]) antall++;  // en inversjon siden i < j
            }
        }
        return antall;
    }

    public static boolean erSortert(int[] a)  // legges i samleklassen Tabell
    {
        for (int i = 1; i < a.length; i++)      // starter med i = 1
            if (a[i-1] > a[i]) return false;      // en inversjon

        return true;
    }


    public static int søkUsortert(int[] a, int verdi)  // bruker vaktpost istedenfor i < a.length - 1 (Litt meire effektivt)
    {
        int sist = a.length - 1;
        int tmp = a[sist];  // tar vare på den siste
        a[sist] = verdi;    // verdi blir vaktpost

        for (int i = 0; ; i++)  // i < a.length er tatt vekk
            if (verdi == a[i])    // dette blir sant før eller senere
            {
                a[sist] = tmp;  // legger den siste tilbake
                if (i == sist) return verdi == tmp ? sist : -1;
                else return i;
            }
    }


    public static int lineærsøk(int[] a, int verdi)
        /*
         * k = -(p + 1) , p = -(k + 1)
         * p = posisjon
         */
    {
        if (a.length == 0 || verdi > a[a.length-1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = 0; for( ; a[i] < verdi; i++);  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }

    public static int lineærsøkFraHogre(int[] a, int verdi)    // vi leter motsatt vei, dvs. starter bakerst
    {
        if (a.length == 0 || verdi < a[0])
            return -1;  // verdi er mindre enn den største

        int i = a.length - 1; for( ; a[i] > verdi; i--);

        return verdi == a[i] ? i : -(i + 2);
    }

    public static int lineærsøk(int[] a, int k, int verdi)
    {
        if (k < 1)
            throw new IllegalArgumentException("Må ha k > 0!");

        int j = k - 1;
        for (; j < a.length && verdi > a[j]; j += k);

        int i = j - k + 1;  // søker i a[j-k+1:j]
        for (; i < a.length && verdi > a[i]; i++);

        if (i < a.length && a[i] == verdi) return i;  // funnet
        else return -(i + 1);
    }

    public static int kvadratrotsøk(int[] a, int verdi)
    {
        return lineærsøk(a,(int)Math.sqrt(a.length),verdi);
    }

    /*
    // første versjon
    public static int binærsøk(int[] a, int fra, int til, int verdi)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v <= h)    // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;      // heltallsdivisjon - finner midten
            int midtverdi = a[m];   // hjelpevariabel for midtverdien

            if (verdi == midtverdi) return m;          // funnet
            else if (verdi > midtverdi) v = m + 1;     // verdi i a[m+1:h]
            else  h = m - 1;                           // verdi i a[v:m-1]
        }

        return -(v + 1);    // ikke funnet, v er relativt innsettingspunkt
    }



    // 2. versjon av binærsøk - returverdier som for Programkode 1.3.6 a)
    public static int binærsøk(int[] a, int fra, int til, int verdi)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;    // v og h er intervallets endepunkter

        while (v <= h)  // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;     // heltallsdivisjon - finner midten
            int midtverdi = a[m];  // hjelpevariabel for  midtverdien

            if (verdi > midtverdi) v = m + 1;        // verdi i a[m+1:h]
            else if (verdi < midtverdi) h = m - 1;   // verdi i a[v:m-1]
            else return m;                           // funnet
        }

        return -(v + 1);   // ikke funnet, v er relativt innsettingspunkt
    }
     */

    // 3. versjon av binærsøk - returverdier som for Programkode 1.3.6 a) - Denne er mest effektiv
    public static int binærsøk(int[] a, int fra, int til, int verdi)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v < h)  // obs. må ha v < h her og ikke v <= h
        {
            int m = (v + h)/2;  // heltallsdivisjon - finner midten

            if (verdi > a[m]) v = m + 1;   // verdi må ligge i a[m+1:h]
            else  h = m;                   // verdi må ligge i a[v:m]
        }
        if (h < v || verdi < a[v]) return -(v + 1);  // ikke funnet
        else if (verdi == a[v]) return v;            // funnet
        else  return -(v + 2);                       // ikke funnet
    }

    public static int binærsøk(int[] a, int verdi)  // søker i hele a
    {
        return binærsøk(a,0,a.length,verdi);  // bruker metoden over
    }

    public static void utvalgssortering(int[] a) // Uten hjelpemetoder
    {
        for (int i = 0; i < a.length - 1; i++) {
            int m = i;             // indeks til den foreløpig minste
            int minverdi = a[i];  // verdien til den foreløpig minste

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < minverdi) {
                    minverdi = a[j];  // ny minste verdi
                    m = j;            // indeksen til ny minste verdi
                }
            }
            // bytter om a[i] og a[m]
            /*
            Siden me veit at a[m] er lik minverdi kan vi korte ned koden.
            * int temp = a[i];
            * a[i] = a[m];
            * a[m] = temp;
             */
            a[m] = a[i];
            a[i] = minverdi;

        }
    }

    public static int utvalgssorteringM(int[] a, int fra, int til) // Intervall/hjelpemetoder
    {
        fratilKontroll(a.length, fra, til);
        int antall = 0;                     // antall ganger m og i ikkje er like
        for (int i = fra; i < til - 1; i++)
        {
            int m = min(a, i, til); // posisjonen til den minste
            if (m != i) bytt(a, i, m);  // to hjelpemetoder
            else antall++;
        }
        return antall;
    }

    public static int utvalgssorteringM(int[] a) // Med hjelpemetoder
    {
        return utvalgssorteringM(a, 0, a.length-1);
    }

    public static int usortertsøk(int[] a, int verdi)  // tabell og søkeverdi
    {
        for (int i = 0; i < a.length; i++)  // går gjennom tabellen
            if (verdi == a[i]) return i;      // verdi funnet - har indeks i

        return -1;                          // verdi ikke funnet
    }

    public static void innsettingssortering(int[] a) {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            int verdi = a[i], j = i - 1;      // verdi er et tabellelemnet, j er en indeks
            for (; j >= 0 && verdi < a[j]; j--) a[j + 1] = a[j];  // sammenligner og flytter
            a[j + 1] = verdi;                 // j + 1 er rett sortert plass
        }
    }
    public static void innsettingssortering(int[] a, int fra, int til)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)

        for (int i = fra + 1; i < til; i++)  // a[fra] er første verdi
        {
            int temp = a[i];  // flytter a[i] til en hjelpevariabel

            // verdier flyttes inntil rett sortert plass i a[fra:i> er funnet
            int j = i-1; for (; j >= fra && temp < a[j]; j--) a[j+1] = a[j];

            a[j+1] = temp;  // verdien settes inn på rett sortert plass
        }
    }

    public static <T extends Comparable<? super T>>
    void innsettingssortering(T[] a)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks
            // sammenligner og forskyver:
            for (; j >= 0 && verdi.compareTo(a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }
    public static void shell(int[] a, int k)
    {
        for (int i = k; i < a.length; i++)
        {
            int temp = a[i], j = i - k;
            for ( ; j >= 0 && temp < a[j]; j -= k) a[j + k] = a[j];
            a[j + k] = temp;
        }
    }           // Programkode 1.3.8 f)

    public static int sammenlign(String s1, String s2)
    {
        int n1 = s1.length();    // lengden til s1
        int n2 = s2.length();    // lengden til s2

        int n = n1 < n2 ? n1 : n2;    // den minste av n1 og n2

        for (int i = 0; i < n; i++)
        {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 != c2) return c1 - c2;
        }
        return n1 - n2;
    }

    public static <T> void
    innsettingssortering(T[] a, Komparator<? super T> c)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && c.compare(verdi,a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

}