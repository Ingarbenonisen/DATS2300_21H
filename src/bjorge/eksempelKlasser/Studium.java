package bjorge.eksempelKlasser;

public enum Studium  // legges under package eksempelklasser
{
    Anvendt("Anvendt datateknologi"), // enumkonstanten Anvendt
    Data("Ingeniørfag - data"), // enumkonstanten Data
    Elektro("Ingeniørfag - elektronikk og informasjonsteknologi"),
    Enkeltemne("Enkeltemnestudent"),
    IT("Informasjonsteknologi") // enumkonstanten IT
    ;    // enumkonstanten Enkeltemne

    private final String fulltnavn;      // instansvariabel

    Studium(String fulltnavn) {
        this.fulltnavn = fulltnavn;
    }

    public String toString() {
        return fulltnavn;
    }
}

