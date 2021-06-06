public class KistenListe implements Liste {

  /**
   * Die erste Kiste der Liste
   */
  private Kiste ersteKiste;

  /**
   * Die aktuell betrachtete Kiste als Objektvariable anstatt lokaler Variable in Methoden.
   */
  private Kiste aktuelleKiste;

  /**
   * Der Name der Kistenliste
   */
  private String kistenListenName;

  /**
   * Aktuelle Länge der Kistenliste.
   */
  private int kistenListenLaenge;

  /**
   * Zähler aller Kistenlisten
   */
  private static int kistenListenZaehler;

  public KistenListe(String listenName) {
    this.kistenListenName = "Kisten-Liste\nNr: " + kistenListenZaehler + "\nName: " + listenName;
    kistenListenZaehler++;
  }

  @Override
  public void anhaengen(String text) {
    if (ersteKiste != null && this.vergleicheInhalt(text)) {
      aktuelleKiste = this.findeKiste(text);
      this.ersetzen(text, aktuelleKiste.getKistenIndex());
    }
    Kiste kiste = new Kiste(text);
    if (ersteKiste == null) {
      ersteKiste = kiste;
      kiste.setKistenIndex(0);
    } else {
      aktuelleKiste = ersteKiste;
      while (aktuelleKiste.getNaechstKiste() != null) {
        aktuelleKiste = aktuelleKiste.getNaechstKiste();
      }
      aktuelleKiste.setNaechstKiste(kiste);
      if (kiste != ersteKiste) {
        this.findeVorherigeKiste(kiste);
      }
      kiste.setKistenIndex(kiste.getVorherigeKiste().getKistenIndex() + 1);
    }
    kistenListenLaenge++;
  }

  @Override
  public void aussortieren(String text) {
    aktuelleKiste = this.findeKiste(text);
    if (aktuelleKiste.getVorherigeKiste() == null) {
      ersteKiste = aktuelleKiste.getNaechstKiste();
      ersteKiste.setVorherigeKiste(null);
    } else if (aktuelleKiste.getNaechstKiste() == null) {
      aktuelleKiste.getVorherigeKiste().setNaechstKiste(null);
    } else {
      aktuelleKiste.getNaechstKiste().setVorherigeKiste(aktuelleKiste.getVorherigeKiste());
      aktuelleKiste.getVorherigeKiste().setNaechstKiste(aktuelleKiste.getNaechstKiste());
      this.verringereWeitereKistenIndizes(aktuelleKiste);
      aktuelleKiste.setNaechstKiste(null);
    }
    aktuelleKiste.setVorherigeKiste(null);
    kistenListenLaenge--;
  }

  @Override
  public void einsortieren(String text, int index) {
    Kiste kiste = new Kiste(text);
    aktuelleKiste = this.findeKiste(index);
    kiste.setVorherigeKiste(aktuelleKiste.getVorherigeKiste());
    aktuelleKiste.getVorherigeKiste().setNaechstKiste(kiste);
    kiste.setNaechstKiste(aktuelleKiste);
    aktuelleKiste.setVorherigeKiste(kiste);
    this.erhoeheWeitereKistenIndizes(kiste);
    kistenListenLaenge++;
  }

  @Override
  public void ersetzen(String text, int index) {
    aktuelleKiste = this.findeKiste(index);
    aktuelleKiste.setInhalt(text);
  }

  @Override
  public String anschauen(int index) {
    aktuelleKiste = ersteKiste;
    while (aktuelleKiste.getKistenIndex() != index) {
      aktuelleKiste = aktuelleKiste.getNaechstKiste();
    }
    return aktuelleKiste.getInhalt();
  }

  @Override
  public void machLeer() {
    this.ersteKiste = null;
  }

  @Override
  public void printListe() {
    System.out.println(kistenListenName);
    System.out.println("Die Liste hat " + kistenListenLaenge + " Elemente.");
    if (ersteKiste == null) {
      System.out.println("Diese Liste ist leer.");
      return;
    }
    aktuelleKiste = ersteKiste;
    while (aktuelleKiste != null) {
      System.out.println("[" + aktuelleKiste.getKistenIndex() + "] " + aktuelleKiste.getInhalt());
      aktuelleKiste = aktuelleKiste.getNaechstKiste();
    }
    System.out.println();
  }

  @Override
  public int laenge() {
    return kistenListenLaenge;
  }

  /**
   * Findet die vorherige Kiste einer Kiste kiste.
   *
   * @param kiste
   */
  private void findeVorherigeKiste(Kiste kiste) {
    aktuelleKiste = ersteKiste;
    while (aktuelleKiste.getNaechstKiste() != kiste) {
      aktuelleKiste = aktuelleKiste.getNaechstKiste();
    }
    kiste.setVorherigeKiste(aktuelleKiste);
  }

  /**
   * Findet die erste Kiste mit dem Inhalt String text.
   *
   * @param text
   * @return aktuelleKiste
   */
  private Kiste findeKiste(String text) {
    aktuelleKiste = ersteKiste;
    while (aktuelleKiste.getInhalt() != text) {
      aktuelleKiste = aktuelleKiste.getNaechstKiste();
    }
    return aktuelleKiste;
  }

  /**
   * Findet die Kiste mit dem int index.
   *
   * @param index
   * @return aktuelleKiste
   */
  private Kiste findeKiste(int index) {
    aktuelleKiste = ersteKiste;
    while (aktuelleKiste.getKistenIndex() != index) {
      aktuelleKiste = aktuelleKiste.getNaechstKiste();
    }
    return aktuelleKiste;
  }

  private boolean vergleicheInhalt(String text) {
    aktuelleKiste = ersteKiste;
    while (aktuelleKiste.getInhalt() != text) {
      if (aktuelleKiste.getNaechstKiste() == null) {
        return false;
      }
      aktuelleKiste = aktuelleKiste.getNaechstKiste();
    }
    return true;
  }

  /**
   * Erhöht die Kistenindizes
   *
   * @param kiste
   */
  private void erhoeheWeitereKistenIndizes(Kiste kiste) {
    aktuelleKiste = kiste;
    aktuelleKiste.setKistenIndex(aktuelleKiste.getNaechstKiste().getKistenIndex());
    while (aktuelleKiste.getNaechstKiste() != null) {
      aktuelleKiste = aktuelleKiste.getNaechstKiste();
      aktuelleKiste.setKistenIndex(aktuelleKiste.getKistenIndex() + 1);
    }
  }

  /**
   * Verringert die Kistenindizes
   *
   * @param kiste
   */
  private void verringereWeitereKistenIndizes(Kiste kiste) {
    aktuelleKiste = kiste;
    aktuelleKiste.setKistenIndex(aktuelleKiste.getVorherigeKiste().getKistenIndex());
    while (aktuelleKiste.getNaechstKiste() != null) {
      aktuelleKiste = aktuelleKiste.getNaechstKiste();
      aktuelleKiste.setKistenIndex(aktuelleKiste.getVorherigeKiste().getKistenIndex() + 1);
    }
    aktuelleKiste = kiste;
    kiste.setKistenIndex(-1);
  }
}
