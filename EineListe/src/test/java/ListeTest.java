import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ListeTest {

  Liste liste;

  @BeforeEach
  void aufsetzen() {
    liste = new KistenListe("Kisten Liste");
    // liste = new ArrayListe("Array Liste");
    // liste = new MarvinsListe();
  }

  @Test
  void anhaengenUndAnschauen() {
    // Gegeben
    liste.anhaengen("moin");

    // Wenn
    String ergebnis = liste.anschauen(0);

    // Dann
    assertThat(liste.laenge()).isEqualTo(1);
    assertThat(ergebnis).isEqualTo("moin");
  }

  @Test
  void anhaengenUndAnschauen_mehrereElemente() {
    // Gegeben
    liste.anhaengen("moin");
    liste.anhaengen("was");
    liste.anhaengen("geht");

    // Wenn
    String ergebnis1 = liste.anschauen(0);
    String ergebnis2 = liste.anschauen(1);
    String ergebnis3 = liste.anschauen(2);

    // Dann
    assertThat(liste.laenge()).isEqualTo(3);
    assertThat(ergebnis1).isEqualTo("moin");
    assertThat(ergebnis2).isEqualTo("was");
    assertThat(ergebnis3).isEqualTo("geht");
  }

  @Test
  void anhaengenUndAnschauen_Null() {
    // Gegeben
    liste.anhaengen(null);

    // Wenn
    String ergebnis = liste.anschauen(0);

    // Dann
    assertThat(ergebnis).isEqualTo(null);
  }

  @Test
  void anschauen_IndexZuGross() {
    // Wenn, Dann
    assertThatExceptionOfType(IndexOutOfBoundsException.class)
      .isThrownBy(() -> liste.anschauen(0));
  }

  @Test
  void anschauen_IndexZuKlein() {
    // Wenn, Dann
    assertThatExceptionOfType(IndexOutOfBoundsException.class)
      .isThrownBy(() -> liste.anschauen(-1));
  }

  @Test
  void aussortieren() {
    // Gegeben
    liste.anhaengen("moin");
    liste.anhaengen("was");
    liste.anhaengen("geht");

    // Wenn
    liste.aussortieren("was");
    String ergebnis1 = liste.anschauen(0);
    String ergebnis2 = liste.anschauen(1);

    // Dann
    assertThat(liste.laenge()).isEqualTo(2);
    assertThat(ergebnis1).isEqualTo("moin");
    assertThat(ergebnis2).isEqualTo("geht");
  }

  @Test
  void aussortieren_elementGibtEsNicht() {
    // Gegeben
    liste.anhaengen("moin");
    liste.anhaengen("was");
    liste.anhaengen("geht");

    // Wenn
    liste.aussortieren("nicht");
    String ergebnis1 = liste.anschauen(0);
    String ergebnis2 = liste.anschauen(1);
    String ergebnis3 = liste.anschauen(2);

    // Dann
    assertThat(liste.laenge()).isEqualTo(3);
    assertThat(ergebnis1).isEqualTo("moin");
    assertThat(ergebnis2).isEqualTo("was");
    assertThat(ergebnis3).isEqualTo("geht");
  }


  @Test
  void aussortieren_null() {
    // Gegeben
    liste.anhaengen("moin");
    liste.anhaengen("was");
    liste.anhaengen("geht");

    // Wenn
    liste.aussortieren("nicht");
    String ergebnis1 = liste.anschauen(0);
    String ergebnis2 = liste.anschauen(1);
    String ergebnis3 = liste.anschauen(2);

    // Dann
    assertThat(liste.laenge()).isEqualTo(3);
    assertThat(ergebnis1).isEqualTo("moin");
    assertThat(ergebnis2).isEqualTo("was");
    assertThat(ergebnis3).isEqualTo("geht");
  }

  @Test
  void einsortieren() {
    // Gegeben
    liste.anhaengen("moin");
    liste.anhaengen("was");
    liste.anhaengen("geht");

    // Wenn
    liste.einsortieren("doch", 1);
    String ergebnis1 = liste.anschauen(0);
    String ergebnis2 = liste.anschauen(1);
    String ergebnis3 = liste.anschauen(2);
    String ergebnis4 = liste.anschauen(3);

    // Dann
    assertThat(liste.laenge()).isEqualTo(4);
    assertThat(ergebnis1).isEqualTo("moin");
    assertThat(ergebnis2).isEqualTo("doch");
    assertThat(ergebnis3).isEqualTo("was");
    assertThat(ergebnis4).isEqualTo("geht");
  }

  @Test
  void einsortieren_vorne() {
    // Wenn
    liste.einsortieren("geht", 0);
    liste.einsortieren("was", 0);
    liste.einsortieren("moin", 0);
    String ergebnis1 = liste.anschauen(0);
    String ergebnis2 = liste.anschauen(1);
    String ergebnis3 = liste.anschauen(2);

    // Dann
    assertThat(liste.laenge()).isEqualTo(3);
    assertThat(ergebnis1).isEqualTo("moin");
    assertThat(ergebnis2).isEqualTo("was");
    assertThat(ergebnis3).isEqualTo("geht");
  }

  @Test
  void einsortieren_hinten() {
    // Gegeben
    liste.anhaengen("moin");
    liste.anhaengen("was");
    liste.anhaengen("geht");

    // Wenn
    liste.einsortieren("ab", 3);
    String ergebnis = liste.anschauen(3);

    // Dann
    assertThat(liste.laenge()).isEqualTo(4);
    assertThat(ergebnis).isEqualTo("ab");
  }

  @Test
  void einsortieren_null() {
    // Gegeben
    liste.anhaengen("moin");
    liste.anhaengen("was");
    liste.anhaengen("geht");

    // Wenn
    liste.einsortieren(null, 1);
    String ergebnis1 = liste.anschauen(0);
    String ergebnis2 = liste.anschauen(1);
    String ergebnis3 = liste.anschauen(2);
    String ergebnis4 = liste.anschauen(3);

    // Dann
    assertThat(liste.laenge()).isEqualTo(4);
    assertThat(ergebnis1).isEqualTo("moin");
    assertThat(ergebnis2).isEqualTo(null);
    assertThat(ergebnis3).isEqualTo("was");
    assertThat(ergebnis4).isEqualTo("geht");
  }

  @Test
  void einsortieren_indexZuGross() {
    // Wenn, Dann
    assertThatExceptionOfType(IndexOutOfBoundsException.class)
      .isThrownBy(() -> liste.einsortieren("moin", 1));
  }

  @Test
  void einsortieren_indexZuKlein() {
    // Wenn, Dann
    assertThatExceptionOfType(IndexOutOfBoundsException.class)
      .isThrownBy(() -> liste.einsortieren("moin", -1));
  }

  @Test
  void ersetzen() {
    // Gegeben
    liste.anhaengen("moin");
    liste.anhaengen("was");
    liste.anhaengen("geht");

    // Wenn
    liste.ersetzen("servus", 0);
    String ergebnis1 = liste.anschauen(0);
    String ergebnis2 = liste.anschauen(1);
    String ergebnis3 = liste.anschauen(2);

    // Dann
    assertThat(liste.laenge()).isEqualTo(3);
    assertThat(ergebnis1).isEqualTo("servus");
    assertThat(ergebnis2).isEqualTo("was");
    assertThat(ergebnis3).isEqualTo("geht");
  }

  @Test
  void ersetzen_indexZuGross() {
    // Wenn, Dann
    assertThatExceptionOfType(IndexOutOfBoundsException.class)
      .isThrownBy(() -> liste.ersetzen("servus", 0));
  }

  @Test
  void ersetzen_indexZuKlein() {
    // Wenn, Dann
    assertThatExceptionOfType(IndexOutOfBoundsException.class)
      .isThrownBy(() -> liste.ersetzen("servus", -1));
  }

  @Test
  void machLeer() {
    // Gegeben
    liste.anhaengen("moin");
    liste.anhaengen("was");
    liste.anhaengen("geht");

    // Wenn
    liste.machLeer();

    // Dann
    assertThat(liste.laenge()).isEqualTo(0);
  }
}
