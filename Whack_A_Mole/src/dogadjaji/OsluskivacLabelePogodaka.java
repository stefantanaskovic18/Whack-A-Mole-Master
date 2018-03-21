package dogadjaji;

import grafika.Prozor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OsluskivacLabelePogodaka implements ActionListener{

    private Label l;

    public OsluskivacLabelePogodaka(Label l) {
        this.l = l;
    }

    public void actionPerformed(ActionEvent e) {
        l.setText("Broj pogodaka: "+ Prozor.brojPogodaka);
    }
}
