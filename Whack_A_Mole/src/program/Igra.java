package program;

import grafika.Dugme;
import grafika.Prozor;

import java.awt.*;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Igra extends Thread {

    private Dugme[][] dugmici;
    private Label vreme;
    private Vreme v;
    private Button start;
    private Label pogodci;
    private Label promasaji;
    private Label bodovi;

    public Igra(Dugme[][] dugmici, Label vreme, Button start, Label pogodci, Label promasaji, Label bodovi) {
        this.dugmici = dugmici;
        this.vreme = vreme;
        this.start = start;
        this.pogodci = pogodci;
        this.promasaji = promasaji;
        this.bodovi = bodovi;
        for (int i = 0; i < dugmici.length; i++) {
            for (int j = 0; j < dugmici[i].length; j++) {
                dugmici[i][j].setEnabled(true);
            }
        }
        start();
    }

    public void run() {
        Random gen = new Random();
        v = new Vreme(vreme);
        Prozor.brojPromasaja = 0;
        Prozor.brojPogodaka = 0;
        Prozor.ukupnoBodova = 0;
        pogodci.setText("Pogodaka: " + Prozor.brojPogodaka);
        promasaji.setText("Promasaja: " + Prozor.brojPromasaja);
        bodovi.setText("Bodovi: " + Prozor.ukupnoBodova);

        while (true)
            if (v.getBrojacSekundi() <= 30) {
                if (v.getBrojacSekundi() <= 0) {
                    start.setEnabled(true);
                    for (int i = 0; i < dugmici.length; i++) {
                        for (int j = 0; j < dugmici[i].length; j++) {
                            dugmici[i][j].setEnabled(false);
                        }
                    }
                    break;
                }
                uradi(5, gen);
            } else
                uradi(3, gen);
    }

    private void uradi(int broj, Random gen) {
        for (int i = 0; i < broj; i++) {
            int x = gen.nextInt(5);
            int y = gen.nextInt(5);
            dugmici[x][y].osvetli();
        }

        try {
            sleep(gen.nextInt(700) + 800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < dugmici.length; i++) {
            for (int j = 0; j < dugmici.length; j++) {
                dugmici[i][j].podrazumevana();
            }
        }
        try {
            sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
