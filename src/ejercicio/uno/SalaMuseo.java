package ejercicio.uno;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SalaMuseo {

    ReentrantLock lock = new ReentrantLock();
    Condition puedeEntrar = lock.newCondition();
    Condition puedeEntrarJubilado = lock.newCondition();
    private int capacidadMax = 50;
    private int capacidadTempMax = 35;
    private int capacidadActual = 0;
    private int tUmbralMax = 30;
    private int tUmbralActual;


    public void entrarSala(String nombre) {
        lock.lock();
        try {
            while ((tUmbralActual >= tUmbralMax && capacidadActual >= capacidadTempMax) ||
                    (tUmbralActual < tUmbralMax && capacidadActual >= capacidadMax)) {
                System.out.println(nombre + " no puede entrar actualmente a la sala");
                puedeEntrar.await();
            }
            capacidadActual++;
            System.out.println("la persona " + nombre + " accedio a la sala");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void entrarJubilado(String nombre) {
        lock.lock();
        try {
            while ((tUmbralActual >= tUmbralMax && capacidadActual >= capacidadTempMax) ||
                    (tUmbralActual < tUmbralMax && capacidadActual >= capacidadMax)) {
                System.out.println(nombre + " no puede entrar actualmente");
                puedeEntrarJubilado.await();
            }
            capacidadActual++;
            System.out.println("el jubilado " + nombre + " accedio a la sala");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void salirSala(String nombre) {
        lock.lock();
        try {
            capacidadActual--;
            System.out.println(nombre + " salio de la sala");
            if (tUmbralActual < tUmbralMax || capacidadActual < capacidadTempMax) {
                puedeEntrarJubilado.signal();
            }
            puedeEntrar.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void notificarTemperatura(int temperaturaActual) {
        lock.lock();
        try {
            tUmbralActual = temperaturaActual;
            if (temperaturaActual < tUmbralMax || capacidadActual < capacidadTempMax) {
                puedeEntrarJubilado.signal();
            }
            puedeEntrar.signalAll();
        } finally {
            lock.unlock();
        }
    }

}
