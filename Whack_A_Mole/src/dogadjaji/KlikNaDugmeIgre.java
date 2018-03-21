package dogadjaji;

import grafika.Dugme;
import grafika.Prozor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KlikNaDugmeIgre implements ActionListener {


    private Dugme dugme;
    private Label pogodci;
    private Label promasaji;
    private Label bodovi;

    public KlikNaDugmeIgre(Dugme dugme, Label pogodci, Label promasaji, Label bodovi) {
        this.dugme = dugme;
        this.pogodci = pogodci;
        this.promasaji = promasaji;
        this.bodovi = bodovi;
    }

    public void actionPerformed(ActionEvent e) {
        if (dugme.getBackground().toString().equals(dugme.getSekundarna().toString())) {
            Prozor.brojPogodaka++;
            Prozor.ukupnoBodova+=3;
            dugme.podrazumevana();
        } else {
            Prozor.brojPromasaja++;
            Prozor.ukupnoBodova--;
        }
        pogodci.setText("Pogodaka: "+Prozor.brojPogodaka);
        bodovi.setText("Bodovi: "+Prozor.ukupnoBodova);
        promasaji.setText("Promasaja: "+Prozor.brojPromasaja);
    }
}
