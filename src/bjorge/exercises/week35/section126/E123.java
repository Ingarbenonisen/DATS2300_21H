package bjorge.exercises.week35.section126;

public class E123 {
//Oppgave 1 nestMaks metoden har 2n-3 samenlikninger
    //Oppgave 2: Ein tabell der deito største verdien er lengst til høgre i tabellen
    public static int[] nestMaks(int[] a) // ny versjon
    {
        int n = a.length;     // tabellens lengde
        if (n < 2) throw      // må ha minst to verdier
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");


        int m = 0;      // m er posisjonen til største verdi
        int nm = 1;     // nm er posisjonen til nest største verdi

        // bytter om m og nm hvis a[1] er større enn a[0]
        if (a[1] > a[0]) { //sammnligning: 1
            m = 1;
            nm = 0;
        }

        int maksverdi = a[m];                // største verdi
        int nestmaksverdi = a[nm];           // nest største verdi

        for (int i = 2; i < n; i++)

        {
            if (a[i] > nestmaksverdi) //sammenligning: n-2

            {
                if (a[i] > maksverdi) //sammenligning: n-2 ? 1 + 2(n-2)=2n-3

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
    public static int maks(int[] a)   // versjon 2 av maks-metoden
    {
        int m = 0;               // indeks til største verdi
        int maksverdi = a[0];    // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdateres
        }
        return m;   // returnerer indeks/posisjonen til største verdi

    } // maks
    /*Oppgave 3:
    I maks-metoden er det ingen forskjell når det gjelder sammenligninger.
    Uansett hvordan en tabell med lengde n ser ut, må det utføres n − 1 sammenligninger for å finne den største verdien.
    Men hvis vi bruker den versjonen av maks-metoden vi har i Programkode 1.1.4,
    så er det også mulig å ta med de tilordningene som utføres når a[i] > maksverdi er sann.
    De blir det flest av hvis tabellen er sortert stigende og færrest av hvis den største ligger først.
     */
}
