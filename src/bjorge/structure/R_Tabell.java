package bjorge.structure;

import java.util.Arrays;

//Tabell for rekursive metoder
public class R_Tabell {
    //Rekursift binær søk
    public static int binarySearchRecursive(int[] values,int search_value, int l, int r){
        int middle = (l + r) / 2;
        if(r-l == 0) {
            if (values[middle] == search_value) {
                return middle;
            }
            else {
                return -middle;
            }
        }
        if (values[middle] <= search_value) {
            if (values[middle]==search_value){
                return middle;
            }
            return binarySearchRecursive(values, search_value, l+1, r);
        }
        else {
            return binarySearchRecursive(values, search_value, l, r-1);
        }
    }

    //Rekursift utskrift av permutasjoner
    public static void recursive_permutation(int[] values, int k){
        //Sånn som eg forstod det så vil den rukursive funkdjonen ikkje gå videre når den blir printet ut, spørr om dette
        if (k == values.length-1){
            System.out.println(Arrays.toString(values));
        }
        for (int i = k; i < values.length ; i++) {
            Tabell.bytt(values, i, k);
            recursive_permutation(values, k+1);
            Tabell.bytt(values, k, i);
        }
    }

    //Oppgave 8
    // Summen av heltallene fra k til n der k <= n.
    // Lag en metode public static int sum(int k, int n) som finner denne summen,
    // og gjør det ved å bruke «splitt og hersk».
    public static int sum(int k, int n)
    {
        if (n == k) return n;
        int m = (n + k)/2;
        return sum(k,m) + sum(m+1, n);
    }
    // n og k er byttet om i pensum og er feil kode
    // Pensum koden skriver ut 36 med k = 3 og n = 6, når den kal slrive ut 18.

    public static int euklid(int a, int b)
    {

        if (b == 0) return a;
        int r = a % b;            // r er resten
        return euklid(b,r);       // rekursivt kall
    }
    public static int sum(int n)       // summen av tallene fra 1 til n
    {
        if (n == 1) return 1;            // summen av 1 er lik 1
        return sum(n - 1) + n;           // summen av de  n – 1 første + n
    }
    public static int sum(int[] a, int n)   // summen av de n første
    {
        if (n == 1) return a[0];       // summen er verdien selv
        return sum(a,n-1) + a[n-1];    // summen av de n-1 første + a[n-1]
    }
    public static int sum(int[] a, int v, int h)   // intervallet a[v:h]
    {
        if (v == h) return a[v];   // summen av én verdi er verdien selv
        int m = (v + h)/2;         // finner midten
        return sum(a,v,m) + sum(a,m+1,h);  // summen av de to halvdelene
    }
    public static int fib(int n)         // det n-te Fibonacci-tallet
    {
        if (n <= 1) return n;              // fib(0) = 0, fib(1) = 1
        else return fib(n-1) + fib(n-2);   // summen av de to foregående
    }

    public static int sifferrot(int n)
    {
        n %= 9;
        return n == 0 ? 9 : n;
    }

    public static int fakultet(int n)
    {
        return n < 2 ? 1 : fakultet(n-1)*n;
    }

}
