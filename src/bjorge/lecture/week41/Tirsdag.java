package bjorge.lecture.week41;

import java.util.Stack;

public class Tirsdag {

    public static
    int stackBasedFactorial(int n) {
        // Me treng comparable-interface,
        // derfor INteger g ikkje int
        Stack<Integer> factorial_Stack= new Stack<Integer>();

        /*
        // Ikkje lov nå:
         int result = 1;
         for (int i = 1; i <= n; i++) {
             result = result * n;
         }
         return result;

        */
        int result = 1;
        // push, add, addHead, ...
        factorial_Stack.push(n);
        while (!factorial_Stack.isEmpty()) {
            Integer current = factorial_Stack.pop();
            result = result * current;
            if (n > 1){
                n =n-1;
                factorial_Stack.push(n);
            }
        }
        return result;
    }
}
