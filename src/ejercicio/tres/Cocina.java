package ejercicio.tres;

public class Cocina {

    private Ingrediente carne;
    private Ingrediente pasta;
    private Ingrediente vegetal;

    public Cocina(int cantCarne, int cantPasta, int cantVegetal) {
        this.carne = new Ingrediente(cantCarne);
        this.pasta = new Ingrediente(cantPasta);
        this.vegetal = new Ingrediente(cantVegetal);
    }

    public void tomarCarne(String nombre) {
        carne.tomarIngrediente();
        System.out.println("el cocinero " + nombre + " tomo carne");
    }

    public void tomarPasta(String nombre) {
        pasta.tomarIngrediente();
        System.out.println("el cocinero " + nombre + " tomo pasta");
    }

    public void tomarVegetal(String nombre) {
        vegetal.tomarIngrediente();
        System.out.println("el cocinero " + nombre + " tomo vegetal");
    }

    public void reponerCarne(String nombre) {
        carne.reponerIngrediente();
        System.out.println("el cocinero " + nombre + " repone carne");
    }

    public void reponerPasta(String nombre) {
        pasta.reponerIngrediente();
        System.out.println("el cocinero " + nombre + " repone pasta");
    }

    public void reponerVegetal(String nombre) {
        vegetal.reponerIngrediente();
        System.out.println("el cocinero " + nombre + " repone vegetal");
    }

}
