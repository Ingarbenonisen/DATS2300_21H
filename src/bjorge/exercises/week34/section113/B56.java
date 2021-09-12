package bjorge.exercises.week34.section113;
import bjorge.exercises.week34.section112.A123;


public class B56 {
    //Metoden skal legge min og max i eit array inn i eit nytt 2 element array
    public static int[] minmaxPos(int[] a){
        int min = A123.min(a);
        int max = A123.maks1(a);
        return new int[]{min, max};
    }

    public static long fak(int n){
        if (n<=1){
            return 1;
        }
        return n*fak(n-1);
    }


}
