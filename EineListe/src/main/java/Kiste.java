public class Kiste{

  /**
   * Die vorherige Kiste der Liste
   */
  private Kiste vorherigeKiste;

  /**
   * Die nächste Kiste der Liste
   */
  private Kiste naechstKiste;

  /**
   * Der inhalt der Kiste.
   */
  private String inhalt;

  /**
   * Eindeutige und einmalige Nummer der Kiste
   */
  private int kistenNummer;

  /**
   * Statischer Zähler für die Kistennummer
   */
  private static int kistenZaehler;

  /**
   * Index der Kiste in ihrer Kistenliste.
   */
  private int kistenIndex;

  public Kiste (String inhalt) {
    this.kistenNummer = kistenZaehler;
    this.inhalt = inhalt;
    kistenZaehler++;
  }

  public Kiste getVorherigeKiste() {
    return vorherigeKiste;
  }

  public Kiste getNaechstKiste() {
    return naechstKiste;
  }

  public String getInhalt() {
    return inhalt;
  }

  public int getKistenIndex() {
    return kistenIndex;
  }

  public void setVorherigeKiste(Kiste vorherigeKiste) {
    this.vorherigeKiste = vorherigeKiste;
  }

  public void setNaechstKiste(Kiste naechstKiste) {
    this.naechstKiste = naechstKiste;
  }

  public void setInhalt(String inhalt) {
    this.inhalt = inhalt;
  }

  public void setKistenIndex(int kistenIndex) {
    this.kistenIndex = kistenIndex;
  }
}
