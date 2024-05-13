# Prueba de nivel - Especialización Java

### Delivery Bruumm

Una empresa de reparto de comida rápida necesita un programa de gestión de pedidos que
le permita realizar las siguientes funciones:

- ***Crear un nuevo pedido***
- ***Marcar un pedido como entregado***
- ***Listar los pedidos pendientes***
- ***Listar los pedido entregados***

1. Los pedidos cuentan con un ID autoincremental, un cliente, una lista de productos y un
repartidor.
Cuando se crea un pedido se le asigna un repartidor disponible de manera aleatoria.
Cuando el pedido se entrega, el repartidor se libera.


2. Los clientes tienen un nombre y una dirección de entrega.


3. Los repartidores cuentan con un nombre y una disponibilidad para realizar un pedido.
Estos pueden:
- Ir en bicicleta, lo que aumenta el precio del pedido en un 1%.


- Ir en moto, aumentando el total del pedido en un 2%.


- Ir a pie.

4. La empresa cuenta con tres tipos de productos:
- Burritos. Con un valor de 6.5€. Cuando un cliente compra un burrito se le regalará un
pin. (Se indicará mediante un mensaje por consola).


- Hamburguesas. Valor 8.9€. Cuando un cliente pide una hamburguesa se le regalará
una gorra. (Se indicará mediante un mensaje por consola).


- Kebab. Precio = 4.5€


- Pizza. Precio = 7.9€

5. Cuando ya no haya repartidores disponibles se arrojará una excepción que muestre un
mensaje de error y no permitirá crear un nuevo pedido.


6. No se podrá crear un pedido que no tenga cliente ni productos. Puedes manejarlo con
una excepción o una validación.