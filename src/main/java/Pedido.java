import java.util.List;

public class Pedido {
    private int ID = 0;
    private Cliente cliente;
    private List<Producto> productos;
    private Repartidor repartidor;
    private boolean status = false;
    private double precio_total = 0;

    public Pedido(Cliente cliente, List<Producto> productos, Repartidor repartidor) {
        this.ID ++;
        this.cliente = cliente;
        this.productos = productos;
        this.repartidor = repartidor;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setEntregado(boolean entregado) {
        this.status = entregado;
    }
}
