package ejercicio.tres;

public class Main {

    public static void main(String[] args) {

        Cocina cocina = new Cocina(3, 3, 3);

        Cocinero cocineroCarne = new Cocinero("Luigi", "carne", cocina);
        Cocinero cocineroPasta = new Cocinero("Mario", "pasta", cocina);
        Cocinero cocineroVegetal = new Cocinero("Fabio", "vegetal", cocina);

        Thread cocineroCarneThread = new Thread(cocineroCarne);
        Thread cocineroPastaThread = new Thread(cocineroPasta);
        Thread cocineroVegetalThread = new Thread(cocineroCarne);

        cocineroCarneThread.start();
        cocineroPastaThread.start();
        cocineroVegetalThread.start();

    }

}
