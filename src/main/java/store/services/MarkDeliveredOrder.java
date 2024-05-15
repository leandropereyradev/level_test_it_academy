package store.services;

import store.model.order.Order;

import java.util.List;
import java.util.Scanner;

import static store.services.ListOrder.listPendingOrders;
import static store.services.NextInt.getNextInt;

public class MarkDeliveredOrder {
    public static void markDelivered(
            Scanner scanner,
            List<Order> orders
    ) {
        while (listPendingOrders(orders)) {
            System.out.println("Please choose the order number to mark as delivered:");

            int orderNumber;

            try {
                orderNumber = getNextInt(scanner);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid order number.");
                continue;
            }

            for (Order order : orders) {
                if (order.getID() == orderNumber) {
                    order.setDelivered(true);
                    order.getDELIVERYMAN().setAvailable(true);

                    System.out.println("Order marked as delivered.");
                    scanner.nextLine();
                    return;
                }
            }

            System.out.println("Order not found: " + orderNumber);
            scanner.nextLine();
        }
    }
}
