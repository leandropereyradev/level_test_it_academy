public class Repartidor {
    private String nombre;
    private boolean disponible = true;

    public Repartidor(String nombre) {
        this.nombre = nombre;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
