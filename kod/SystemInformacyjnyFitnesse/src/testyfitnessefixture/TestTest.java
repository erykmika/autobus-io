package testyfitnessefixture;

import fit.ColumnFixture;
import java.util.IllegalFormatCodePointException;


// Do usuniecia
// Aby sprawdzic czy Fitnesse dziala
public class TestTest extends ColumnFixture {

    String dane[];

    public boolean dodajProdukt() throws IllegalFormatCodePointException {
        return 1 == liczbaProduktow();
    }

    public int liczbaProduktow() {
        return 1;
    }
}
