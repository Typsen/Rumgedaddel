import java.util.Arrays;

public class ArrayListe implements Liste {
  /**
   * Das eigentliche Array.
   */
  private String[] array;

  /**
   * Zählt die Anzahl der ArrayListen.
   */
  private int arrayListenZaehler;

  /**
   * Der Name der Liste
   */
  private String arrayListenName;

  /**
   * Gibt den aktuell letzten Index des Arrays an
   */
  private int letzterIndex;

  public ArrayListe(String listenName) {
    this.array = new String[0];
    this.arrayListenName = "Array-Liste\nNr: " + arrayListenZaehler + "\nName: " + listenName;
    arrayListenZaehler++;
  }


  @Override
  public void anhaengen(String text) {
    array = this.vergroesserArray(array);
    letzterIndex = array.length - 1;
    array[letzterIndex] = text;
  }

  @Override
  public void aussortieren(String text) {
    int index = this.findeErstenIndex(text, array);
    for (int i = index; i < array.length; i++) {
      if (i + 1 < array.length) {
        array[i] = array[i + 1];
      }
    }
    array = this.verkleinerArray(array);
  }

  @Override
  public void einsortieren(String text, int index) {
    array = this.vergroesserArray(array);
    String first = array[index];
    String second = array[index + 1];
    array[index] = text;

    for (int i = index + 1; i < array.length; i++) {
      array[i] = first;
      first = second;
      if (i < array.length - 1) {
        second = array[i + 1];
      }
    }
  }

  @Override
  public void ersetzen(String text, int index) {
    array[index] = text;
  }

  @Override
  public String anschauen(int index) {
    return array[index];
  }

  @Override
  public void machLeer() {
    array = null;
  }

  @Override
  public void printListe() {
    System.out.println(arrayListenName);
    System.out.println("Die Liste hat " + (letzterIndex + 1) + " Elemente.");
    for (int i = 0; i < array.length; i++) {
      System.out.println("[" + i + "] " + array[i]);
    }
  }

  /**
   * Vergrößert das Array um einen Index.
   *
   * @param altesArray
   * @return vergroessertes Array
   */
  private String[] vergroesserArray(String[] altesArray) {
    array = Arrays.copyOf(altesArray, altesArray.length + 1);
    return array;
  }

  /**
   * Verkleinert das Array um einen Index.
   * @param altesArray
   * @return
   */
  private String[] verkleinerArray(String[] altesArray) {
    array = Arrays.copyOf(altesArray, altesArray.length - 1);
    return array;
  }

  /**
   * Findet den ersten Index dessen Inhalt gleich zu dem String text ist.
   *
   * @param text
   * @param array
   * @return index
   */
  private int findeErstenIndex(String text, String[] array) {
    int index = 0;
    while (array[index] != (text)) {
      index++;
    }
    return index;
  }
}
