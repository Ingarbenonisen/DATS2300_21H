package bjorge.lecture.week38;

import bjorge.structure.R_Tabell;
import bjorge.structure.Tabell;

import java.util.Arrays;

public class Recursive {
    public static void main(String[] args) {
        /*
        int[] tallTabell = {1, 2, 4, 8, 17, 19, 22};
        for (int i = 0; i < 25; i++) {
            System.out.println(i + " - " + R_Tabell.binarySearchRecursive(tallTabell, i, 0, tallTabell.length-1));
        }
         */
         /*
        int[] values = {1,2,3};
        recursive_permutation(values, 0);
          */
    }
    //Rekursift binær søk
    /*
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

     */
    //Rekursive permutasjoner
     /*
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
      */

}
