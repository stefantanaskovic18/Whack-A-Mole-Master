package grafika;

import dogadjaji.KlikNaDugmeIgre;
import program.Igra;

import java.awt.*;
import java.awt.event.*;

public class Prozor extends Frame {

    private Dugme[][] dugmici;
    private Button start;
    private Label pogodci;
    private Label promasaji;
    private Label vreme;
    private Label bodovi;

    public static int brojPogodaka;
    public static int brojPromasaja;
    public static int ukupnoBodova;

    public Label getPogodci() {
        return pogodci;
    }

    public Label getPromasaji() {
        return promasaji;
    }

    public Label getVreme() {
        return vreme;
    }



    public Prozor() {

        super("Whack a button");
        setLayout(null);
        setBounds(50, 50, 370, 600);
        brojPogodaka = 0;
        brojPromasaja = 0;
        ukupnoBodova = 0;

        init();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private void init() {

        pogodci = new Label("Pogodaka: "+brojPogodaka);
        pogodci.setBounds(10, 400, 100, 30);
        pogodci.setFont(new Font("Timew New Roman", 4, 14));
        add(pogodci);

        promasaji = new Label("Promasaja: "+brojPromasaja);
        promasaji.setBounds(10, 400+20, 100, 30);
        promasaji.setFont(new Font("Timew New Roman", 4, 14));
        add(promasaji);

        vreme = new Label("Vreme: ");
        vreme.setBounds(10, 400+60, 100, 30);
        vreme.setFont(new Font("Timew New Roman", 4, 14));
        add(vreme);

        bodovi = new Label("Bodovi: "+ukupnoBodova);
        bodovi.setBounds(10, 400+40, 100, 30);
        bodovi.setFont(new Font("Timew New Roman", 4, 14));
        add(bodovi);



        this.start = new Button("START GAME");
        start.setBounds(105, 400+100, 150, 50);
        start.setBackground(new Color(0xCB0008));
        start.setForeground(Color.WHITE);
        start.setFont(new Font("Timew New Roman", 4, 14));
        add(start);

        int sirina = 10;
        int visina = 40;
        dugmici = new Dugme[5][5];
        for(int i=0; i<dugmici.length; i++) {
            for(int j=0; j<dugmici[i].length; j++) {
                dugmici[i][j] = new Dugme();
                dugmici[i][j].setBounds(sirina, visina, 70, 70);
                add(dugmici[i][j]);
                sirina += 70;
                dugmici[i][j].addActionListener(new KlikNaDugmeIgre(dugmici[i][j], pogodci, promasaji, bodovi));
                dugmici[i][j].setEnabled(false);
            }
            visina += 70;
            sirina = 10;
        }

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setEnabled(false);
                Igra i = new Igra(dugmici, vreme, start, pogodci, promasaji, bodovi);

            }
        });



    }
}
