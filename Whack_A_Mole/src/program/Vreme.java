package program;

import java.awt.*;

public class Vreme extends Thread{

    int brojacSekundi;
    Label vreme;

    public Vreme(Label vreme) {
        brojacSekundi = 60;
        this.vreme = vreme;
        start();
    }

    public void run() {
        while(brojacSekundi != 0) {
            brojacSekundi--;
            if(brojacSekundi < 10)
                vreme.setText("Vreme: 00:0"+brojacSekundi);
            else
                vreme.setText("Vreme: 00:"+brojacSekundi);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getBrojacSekundi() {
        return brojacSekundi;
    }
}
