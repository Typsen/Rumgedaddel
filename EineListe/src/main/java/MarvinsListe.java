public class MarvinsListe implements Liste {

  private MarvinsKnoten ersterKnoten;

  @Override
  public void anhaengen(String text) {
    MarvinsKnoten neuerKnoten = new MarvinsKnoten(text);

    if (ersterKnoten == null) {  // Liste ist leer
      this.ersterKnoten = neuerKnoten;
    } else { // Liste ist nicht leer
      MarvinsKnoten vorherigerKnoten = null;
      MarvinsKnoten aktuellerKnoten = ersterKnoten;

      while (aktuellerKnoten != null) { // Finde den letzten Knoten
        vorherigerKnoten = aktuellerKnoten;
        aktuellerKnoten = aktuellerKnoten.getNaechsterKnoten();
      }
      vorherigerKnoten.setNaechsterKnoten(neuerKnoten); // Referenz hin
      neuerKnoten.setVorherigerKnoten(vorherigerKnoten); // Referenz zurück
    }
  }

  @Override
  public void aussortieren(String text) {
    if (ersterKnoten != null) { // Liste nicht leer
      if (ersterKnoten.getInhalt().equals(text)) { // Erster Knoten muss aussortiert werden
        ersterKnoten = ersterKnoten.getNaechsterKnoten();

        if (ersterKnoten != null) { // Neuer erster Knoten nicht leer
          ersterKnoten.setVorherigerKnoten(null); // Reference zurück
        }
      } else { // Erster Knoten nicht leer und erster Knoten nicht aussortiert
        MarvinsKnoten vorherigerKnoten = ersterKnoten;
        MarvinsKnoten aktuellerKnoten = ersterKnoten.getNaechsterKnoten();

        while (aktuellerKnoten != null) { // Durchsuche alle Knoten
          if (aktuellerKnoten.getInhalt().equals(text)) { // Aktuellen Knoten muss aussortiert werden
            vorherigerKnoten.setNaechsterKnoten(aktuellerKnoten.getNaechsterKnoten()); // Referenz hin
            MarvinsKnoten naechsterKnoten = aktuellerKnoten.getNaechsterKnoten();

            if (naechsterKnoten != null) { // Nächster Knoten nicht leer
              naechsterKnoten.setVorherigerKnoten(vorherigerKnoten); // Referenz zurück
            }
            break;
          }
          aktuellerKnoten = aktuellerKnoten.getNaechsterKnoten();
        }
      }
    }
  }

  @Override
  public void einsortieren(String text, int index) {
    if (index < 0) { // Invalider Index
      throw new IndexOutOfBoundsException(index);
    }

    if (index == laenge()) { // Knoten hinten einsortieren (= anhängen)
      anhaengen(text);
    } else { // Knoten mittig einsortieren
      MarvinsKnoten neuerKnoten = new MarvinsKnoten(text);

      if (index == 0) { // Knoten vorne einsortieren
        if (ersterKnoten != null) { // Erster Knoten nicht leer
          ersterKnoten.setVorherigerKnoten(neuerKnoten); // Referenz zurück
        }
        neuerKnoten.setNaechsterKnoten(ersterKnoten); // Referenz hin
        ersterKnoten = neuerKnoten;
      } else { // Knoten nicht vorne einsortieren
        MarvinsKnoten aktuellerKnoten = ersterKnoten;
        int zaehler = index;

        while (zaehler > 0) { // Finde richtige Position
          if (aktuellerKnoten == null) { // Index gibt es nicht
            throw new IndexOutOfBoundsException(index);
          }
          aktuellerKnoten = aktuellerKnoten.getNaechsterKnoten();
          zaehler--;
        }
        // Neuer Knoten
        neuerKnoten.setVorherigerKnoten(aktuellerKnoten.getVorherigerKnoten()); // Referenz zurück
        neuerKnoten.setNaechsterKnoten(aktuellerKnoten); // Referenz hin

        // Bisherige Knoten
        aktuellerKnoten.getVorherigerKnoten().setNaechsterKnoten(neuerKnoten); // Referenz hin
        aktuellerKnoten.setVorherigerKnoten(neuerKnoten); // Referenz zurück
      }
    }

  }

  @Override
  public void ersetzen(String text, int index) {
    if (index < 0) { // Invalider Index
      throw new IndexOutOfBoundsException(index);
    }

    MarvinsKnoten aktuellerKnoten = ersterKnoten;
    int zaehler = index;

    while (zaehler > 0) { // Finde richtige Position
      if (aktuellerKnoten == null) { // Index gibt es nicht
        throw new IndexOutOfBoundsException(index);
      }

      aktuellerKnoten = aktuellerKnoten.getNaechsterKnoten();
      zaehler--;
    }

    if (aktuellerKnoten == null) { // Index der richtigen Position gibt es nicht
      throw new IndexOutOfBoundsException(index);
    }
    aktuellerKnoten.setInhalt(text);
  }

  @Override
  public String anschauen(int index) {
    if (index < 0) { // Invalider Index
      throw new IndexOutOfBoundsException(index);
    }

    MarvinsKnoten aktuellerKnoten = ersterKnoten;
    int zaehler = index;

    while (zaehler > 0) { // Finde richtige Position
      if (aktuellerKnoten == null) { // Index gibt es nicht
        throw new IndexOutOfBoundsException(index);
      }

      aktuellerKnoten = aktuellerKnoten.getNaechsterKnoten();
      zaehler--;
    }
    if (aktuellerKnoten == null) { // Index der richtigen Position gibt es nicht
      throw new IndexOutOfBoundsException(index);
    }
    return aktuellerKnoten.getInhalt();
  }

  @Override
  public void machLeer() {
    ersterKnoten = null;
  }

  @Override
  public void printListe() {
    MarvinsKnoten aktuellerKnoten = ersterKnoten;

    while (aktuellerKnoten != null) { // Gehe alle Knoten durch
      System.out.print("[" + aktuellerKnoten.getInhalt() + "] ");
      aktuellerKnoten = aktuellerKnoten.getNaechsterKnoten();
    }
    System.out.println(); // Newline
  }

  @Override
  public int laenge() {
    MarvinsKnoten aktuellerKnoten = ersterKnoten;
    int zaehler = 0;

    while (aktuellerKnoten != null) { // Zähle alle Knoten
      aktuellerKnoten = aktuellerKnoten.getNaechsterKnoten();
      zaehler++;
    }
    return zaehler;
  }
}
