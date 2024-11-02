package ejercicio.tres;

public class Cocinero implements Runnable{

    private String nombre;
    private String elementoFaltante;
    private Cocina cocina;

    public Cocinero(String nombre, String especialidad, Cocina cocina) {
        this.nombre = nombre;
        this.elementoFaltante = especialidad;
        this.cocina = cocina;
    }

    @Override
    public void run() {
        while(true){
            try {
                if (elementoFaltante.equals("pasta")) {
                    cocina.tomarPasta(nombre);
                    Thread.sleep(15000);
                    cocina.reponerPasta(nombre);
                } else if (elementoFaltante.equals("carne")) {
                    cocina.tomarCarne(nombre);
                    Thread.sleep(1500);
                    cocina.reponerCarne(nombre);
                } else if (elementoFaltante.equals("vegetal")) {
                    cocina.tomarVegetal(nombre);
                    Thread.sleep(1500);
                    cocina.reponerVegetal(nombre);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
