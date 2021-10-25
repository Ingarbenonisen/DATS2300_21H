package bjorge.exercises.week43;
// 5.2.6  Søking etter en verdi
public class E526_123 {
    /*
      private static <T> Node<T> balansert(T[] a, int v, int h)  // en rekursiv metode
  {
    if (v > h) return null;                       // tomt intervall -> tomt tre

    int m = (v + h)/2;                            // midten
    T verdi = a[m];                               // midtverdien

    while (v < m && verdi.equals(a[m-1])) m--;    // til venstre

    Node<T> p = balansert(a, v, m - 1);           // venstre subtre
    Node<T> q = balansert(a, m + 1, h);           // høyre subtre

    return new Node<>(verdi, p, q);               // rotnoden
  }
     */
}
