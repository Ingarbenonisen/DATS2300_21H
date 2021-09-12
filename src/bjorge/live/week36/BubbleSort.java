package bjorge.live.week36;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] values = {5, 6, 9, 2, 8, 3, 1, 10, 32, 4, 7,};

        //To for-lokker
        // Ytre løkker: sortering ett tall per gjennomgang
        int index3 = binarySearchRecursive(values, 9, 0, values.length-1);
        System.out.println("Fant tallet på " + index3);
    }

    public static void binarySearch(int[] avlues, int search_values){
        // Søk etter 6
        // [a b c d e f g h i j ]
        // values.lenght = 10
        // midten = (values.lenght-1)/2
        // Intervaller: Halvåpent intervall:
        // [8, 10) => 8 9 vanlig for-løkke for(int i =8; i<10; i++)
        // (8, 10] => 9, 10
        // Lukket intervall:
        // [8, 10] => 8, 9, 10 => "vanlig" for-løkke: for(int i =8; i<=10; i++

        //Søk etter 6
        // [ L                 r ]
        // [ a b c d (e) f g h i j ]
        // [ 0 1 2 3 4 5 6 7 8 9 ]
        // values.lenght = 10
        // L = 0 //Left index 0
        // r = 9 //right index 9
        // m = (L+r) / 2 = (0+9) / 2 = 4 //middle
        // Tanke: (0.0 + 9.0) / 2 //NB! Gjør om til double fordi double tar meire plass enn int i datamaskinen

        // Tegneserie:
        //1
        // [ L       m          r ]
        // [ a b c d 9 f g h i j ]
        // [ 0 1 2 3 4 5 6 7 8 9 ]
        //2
        // [ L m   r             ]
        // [ a 2 c d 9 f g h i j ]
        // [ 0 1 2 3 4 5 6 7 8 9 ]
        //3
        // [   L m r             ]
        // [ a 2 5 d 9 f g h i j ]
        // [ 0 1 2 3 4 5 6 7 8 9 ]
        // (L+r) => (3+2) = 5/2 = 2
        //4
        // [       L r           ]
        // [ a 2 5 7 9 f g h i j ]
        // [ 0 1 2 3 4 5 6 7 8 9 ]
    }
    public static int binarySearchRecursive(int [] values, int search_value, int l, int r) {
        int m = (l + r) / 2;
        if(l>r){
            return -1;
        }
        if (values[m] > search_value) {
            r = m - 1;
            return binarySearchRecursive(values, search_value, l, r);
        } else if (values[m] > search_value) {
            l = m + 1;
            return binarySearchRecursive(values, search_value, l, r);
        } else if (values[m] == search_value) {
            return m;
        } else {
            //somethin wrong
            return -1;
        }
    }
}
