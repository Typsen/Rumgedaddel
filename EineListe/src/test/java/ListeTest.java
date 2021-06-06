import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ListeTest {

    Liste liste;

    @BeforeEach
    void aufsetzen() {
        liste = new KistenListe("kistenListe");
    }

    @Test void anschauen() {
        // Gegeben
        liste.anhaengen("moin");

        // Wenn
        String ergebnis = liste.anschauen(0);

        // Dann
        assertThat(ergebnis).isEqualTo("moin");
    }

    @Test void anhaengen() {

    }

    @Test void aussortieren() {

    }

    @Test void einsortieren() {

    }

    @Test void ersetzen() {

    }

    @Test void machLeer() {

    }


}
