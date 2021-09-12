package bjorge.live.week35;

public class Live {
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
