package testyfitnessefixture;

import fit.Fixture;
import systeminformacyjny.kontroler.Aplikacja;

public class SetUp extends Fixture {

    static Aplikacja aplikacja;

    public SetUp() {
        aplikacja = new Aplikacja();
    }
}
