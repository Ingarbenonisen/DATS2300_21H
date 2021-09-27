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
        System.out.println(Arrays.toString(values));
        for (int i = k; i < values.length ; i++) {
            Tabell.bytt(values, i, k);
            //recursive_permutation(values, k+1);
            System.out.println(Arrays.toString(values));
            Tabell.bytt(values, k, i);
        }
    }
}
