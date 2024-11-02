package ejercicio.dos;

public class Main {

    public static void main(String[] args) {

        EmpresaSoftware empresaSoftware = new EmpresaSoftware(3, 3);

        for (int i = 0; i < 9; i++) {
            Empleado empleado = new Empleado(i + "", empresaSoftware);
            Thread empleadoThread = new Thread(empleado);
            empleadoThread.start();
        }

    }

}
