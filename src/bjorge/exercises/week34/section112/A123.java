package bjorge.exercises.week34.section112;
//1
//Array     8 4 17 6 20 1 11 15 3 18 9  2  7  19

//Posisjon  0 1 3  4 5  6  7 8  9 10 11 12 13 14
// Den minste verdien ligger i posisjon 6

//2
public class A123 {
    public static int maks1(int[] a)  // a er en heltallstabell
    {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m = 0;  // indeks til foreløpig største verdi (m for maks)

        for (int i = 1; i < a.length; i++) // obs: starter med i = 1
        {
            if (a[i] > a[m]) m = i;  // indeksen oppdateres
        }

        return m;  // returnerer indeksen/posisjonen til største verdi

    } // maks
    public static int min(int[] a){

        // a er ein heiltallstabell
        if (a.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen a er tom!");
        }
        //3 Bruk mindre eller er lik tegn for å finne det minste tallet lengst ut i arrayet.
        int m = 0; // indeks til foreløbig minste verdi (m for min)
        for(int i = 1; i < a.length; ++i){ // Obs starter med 1.
            if(a[i] <= a[m]){
                m = i; // indeksen oppdateres
            }
        }
      return m;
    }
}


