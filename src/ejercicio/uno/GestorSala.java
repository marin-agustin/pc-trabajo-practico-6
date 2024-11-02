package ejercicio.uno;

import java.util.Random;

public class GestorSala implements Runnable {

    private int temperatura;
    private SalaMuseo salaMuseo;

    public GestorSala(SalaMuseo salaMuseo) {
        this.salaMuseo = salaMuseo;
    }

    public void run() {
        Random random = new Random();
        while (true) {
            try {
                temperatura = 25 + random.nextInt(11);
                salaMuseo.notificarTemperatura(temperatura);
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
