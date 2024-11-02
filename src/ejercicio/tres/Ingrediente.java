package ejercicio.tres;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Ingrediente {

    private int cantidad;
    private ReentrantLock llave = new ReentrantLock();
    private Condition espera = llave.newCondition();

    public Ingrediente(int cantidad) {
        this.cantidad = cantidad;
    }

    public void tomarIngrediente() {
        llave.lock();
        try {
            while (cantidad == 0) {
                espera.await();
            }
            cantidad--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            llave.unlock();
        }
    }

    public void reponerIngrediente() {
        llave.lock();
        try {
            cantidad++;
            espera.signal();
        } finally {
            llave.unlock();
        }
    }

}
