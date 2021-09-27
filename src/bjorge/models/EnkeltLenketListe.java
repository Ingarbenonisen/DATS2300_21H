package bjorge.models;

import java.util.Objects;
//Kommet til 3.3.2.f)
public class EnkeltLenketListe<T> implements Liste<T>
{
    @Override
    public boolean leggInn(T verdi) {
        return false;
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