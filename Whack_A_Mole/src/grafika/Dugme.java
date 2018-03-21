package grafika;

import java.awt.*;

public class Dugme extends Button{

    private Color primarna;
    private Color sekundarna;

    public Dugme() {
        this.primarna = new Color(0x1B221E);
        this.sekundarna = new Color(0xFFF728);
        this.setBackground(primarna);
    }

    public Color getPrimarna() {
        return primarna;
    }

    public Color getSekundarna() {
        return sekundarna;
    }

    public void osvetli() {
        this.setBackground(sekundarna);
    }

    public void podrazumevana() {
        this.setBackground(primarna);
    }
}
