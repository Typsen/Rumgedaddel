public class Main {
  public static void main(String[] args) {
    checkKistenListeSachen();
    checkArrayListenSachen();
  }

  private static void checkKistenListeSachen() {
    Liste kl0 = new KistenListe("Eine Kistenliste");
    Kiste boeseKiste = new Kiste("Drei");

    //Anhängen
    kl0.anhaengen("Null");
    kl0.anhaengen("Eins");
    kl0.anhaengen("Zwei");
    kl0.anhaengen(boeseKiste.getInhalt());
    kl0.anhaengen("Vier");
    kl0.anhaengen("Fünf");
    kl0.anhaengen(boeseKiste.getInhalt());

    //Aussortieren
    kl0.aussortieren("Eins");
    kl0.aussortieren("Vier");

    //Einsortieren
    kl0.einsortieren("Ich bin der Neue", 1);

    //Ersetzen
    kl0.ersetzen("Weggedrückt", 0);

    //Print
    kl0.printListe();

    //Leer
    kl0.machLeer();
  }

  private static void checkArrayListenSachen() {
    Liste al0 = new ArrayListe("Eine Array Liste");

    //Anhängen
    al0.anhaengen("Null");
    al0.anhaengen("Eins");
    al0.anhaengen("Zwei");
    al0.anhaengen("Drei");
    al0.anhaengen("Vier");
    al0.anhaengen("Fünf");

    //Aussortieren
    al0.aussortieren("Null");

    //Einsortieren
    al0.einsortieren("Ich bin der neue", 1);

    //Ersetzen
    al0.ersetzen("ersetzt", 2);

    //Print
    al0.printListe();

    //Leer
  }
}
