public interface Liste {
  /**
   * Hängt einen String hinten an die Liste an.
   * @param text
   */
  void anhaengen(String text);

  /**
   * Sortiert den ersten String text aus der Liste aus
   * @param text
   */
  void aussortieren(String text);

  /**
   * Sortiert einen String text an der Stelle int index ein. Der restliche Inhalt wird einen index
   * nach hinten verschoben.
   * @param text
   * @param index
   */
  void einsortieren(String text, int index);

  /**
   * Ersetzt einen String durch den String text an der Stelle int index.
   * @param text
   * @param index
   */
  void ersetzen(String text, int index);

  /**
   * Liefert den Inhalt String indexInhalt zurück
   * @param index
   */
  String anschauen(int index);

  /**
   * Leert die gesamte Liste
   */
  void machLeer();

  /**
   * Printet die Liste auf der Konsole
   */
  void printListe();

  /**
   * Gibt die Laenge der Kiste als int zurück.
   */
  int laenge();
}
