package socios.presntation;

import socios.business.SGQ;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class JSGQ extends JFrame implements Observer {

    /** SGQ (Modelo) é o singleton */
    private SGQ sgq;

    public JSGQ() {

        this.sgq = new SGQ();

        /** Este JFrame regista-se como Observador do SGQ para poder actualizar o ecran */
        this.sgq.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
