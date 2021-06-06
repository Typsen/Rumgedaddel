public class MarvinsKnoten {
    private String inhalt;

    private MarvinsKnoten vorherigerKnoten;
    private MarvinsKnoten naechsterKnoten;

    public MarvinsKnoten(String inhalt) {
        this.inhalt = inhalt;
    }

    public String getInhalt() {
        return inhalt;
    }

    public void setInhalt(String inhalt) {
        this.inhalt = inhalt;
    }

    public MarvinsKnoten getVorherigerKnoten() {
        return vorherigerKnoten;
    }

    public void setVorherigerKnoten(MarvinsKnoten vorherigerKnoten) {
        this.vorherigerKnoten = vorherigerKnoten;
    }

    public MarvinsKnoten getNaechsterKnoten() {
        return naechsterKnoten;
    }

    public void setNaechsterKnoten(MarvinsKnoten naechsterKnoten) {
        this.naechsterKnoten = naechsterKnoten;
    }
}
