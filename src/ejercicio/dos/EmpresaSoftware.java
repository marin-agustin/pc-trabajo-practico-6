package ejercicio.dos;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class EmpresaSoftware {

    private int cantNotebooks;
    private int cantLibros;
    private ReentrantLock llave = new ReentrantLock();
    private Condition puedeEsperar = llave.newCondition();

    public EmpresaSoftware(int cantNotebooks, int cantLibros) {
    this.cantNotebooks = cantNotebooks;
    this.cantLibros = cantLibros;
    }

    public void empezarTrabajo(String nombre) {
        llave.lock();
        try {
            while (cantNotebooks == 0 && cantLibros == 0) {
                System.out.println("no hay recursos necesarios para empezar a trabajar, " + nombre + " debe esperar");
                puedeEsperar.await();
            }
            System.out.println(nombre + " toma una notebook y un libro y comienza a trabajar");
            cantNotebooks--;
            cantLibros--;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            llave.unlock();
        }
    }

    public void terminarTrabajo(String nombre) {
        llave.lock();
        try {
            System.out.println(nombre + " termino de trabajar, libera su notebook y libro");
            cantNotebooks++;
            cantLibros++;
            puedeEsperar.signal();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            llave.unlock();
        }
    }

}
