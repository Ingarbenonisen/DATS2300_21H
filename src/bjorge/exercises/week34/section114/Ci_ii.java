package bjorge.exercises.week34.section114;

// 1. Hvor mange grunnleggende operasjoner utfører Programkode 1.1.4
//  i) 10, 5, 7, 2, 9, 1, 3, 8, 4, 6
//  ii) 1, 2, 3, 4, 5, 6, 7, 8, 9, 10

// maks # 1 + 2 + 1 + n + n-1 + 2(n-1) + x*3 + 1 = 5 - 3 + 4n + 3x
// = 4n + 3x + 2
// i) n =10, x= 0, 4*10+ 3*0 + 2 = 42
// ii) n=10, x=9, 4*10 + 3*9 + 2= 69
public class Ci_ii {
    public static int maks2(int[] a)   // versjon 2 av maks-metoden
    {
        int m = 0;               // indeks til største verdi    #1
        int maksverdi = a[0];    // største verdi               #2

        for (int i = 1; i < a.length; i++) {                 // # 1 + n + n-1 = n-1 + n
            if (a[i] > maksverdi)                            // # n-1 + n-1 = 2(n-1)
            {                                                                   //#x*
                maksverdi = a[i];     // største verdi oppdateres               //#2
                m = i;                // indeks til største verdi oppdateres #  //#1
            }
        }
        return m;   // returnerer indeks/posisjonen til største verdi           //#1

    }


}
