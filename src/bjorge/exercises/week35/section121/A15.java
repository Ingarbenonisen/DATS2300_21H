package bjorge.exercises.week35.section121;

public class A15 {
    // Metoden maks(int[] a, int fra, int til)   Programkode 1.2.1 b)
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
    // Metoden maks(int[] a)                     Programkode 1.2.1 c)
    public static int minTabell(int[] a)  // bruker hele tabellen
    {
        return minHalvaapentI(a,0,a.length);     // kaller metoden over
    }

}
