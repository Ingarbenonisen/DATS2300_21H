
package bjorge.models;

import java.util.Iterator;
import java.util.Objects;
//Kommet til 3.3.2.f)

public class EnkeltLenketListe<T> implements Liste<T>
{
    @Override
    public boolean leggInn(T verdi) {
        return false;
    }

    @Override
    public void leggInn(int indeks, T verdi) {

    }
    @Override
    public boolean inneholder(T verdi) {
        return false;
    }

    @Override
    public T hent(int indeks) {
        return null;
    }

    @Override
    public int indeksTil(T verdi) {
        return 0;
    }

    @Override
    public T oppdater(int indeks, T verdi) {
        return null;
    }

    @Override
    public boolean fjern(T verdi) {
        return false;
    }

    @Override
    public T fjern(int indeks) {
        return null;
    }

    @Override
    public int antall() {
        return 0;
    }

    @Override
    public boolean tom() {
        return false;
    }

    @Override
    public void nullstill() {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private static final class Node<T>       // en «nøstet» klasse
    {
        private T verdi;
        private Node<T> neste;

        private Node(T verdi, Node<T> neste)   // konstruktør
        {
            this.verdi = verdi; this.neste = neste;
        }
    }  // Node

    // her skal variabler, konstruktører og metoder komme
    // Instansvariabler
    private Node<T> hode, hale;   // referanser til første og siste node         // referanse til første node i listen
    private int antall;

    // Standarkonstruktør
    public EnkeltLenketListe()   // standardkonstruktør
    {
        hode = hale = null;               // hode er null
        antall = 0;                // ingen verdier - listen er tom
    }

}
