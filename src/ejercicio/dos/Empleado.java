package ejercicio.dos;

public class Empleado implements Runnable {

    private String nombre;
    private EmpresaSoftware empresaSoftware;

    public Empleado(String nombre, EmpresaSoftware empresaSoftware) {
        this.nombre = nombre;
        this.empresaSoftware = empresaSoftware;
    }

    @Override
    public void run() {
        while (true) {
            try {
                empresaSoftware.empezarTrabajo(nombre);
                Thread.sleep(3000);
                empresaSoftware.terminarTrabajo(nombre);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
