public class Producto {

    private int ID = 0;
    private String producto;
    private double precio;
    private String regalo;

    public Producto(String producto, double precio, String regalo) {
        this.ID++;
        this.producto = producto;
        this.precio = precio;
        this.regalo = regalo;
    }

    public String getProduct(){
        return this.producto;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getID(){
        return this.ID;
    }
}
