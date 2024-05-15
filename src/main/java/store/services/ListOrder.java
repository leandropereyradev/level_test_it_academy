package store.services;

import store.model.order.Order;

import java.util.List;

public class ListOrder {
    public static boolean listPendingOrders(List<Order> orders) {
        if (orders.stream().allMatch(Order::getDeliveryStatus)) {
            System.out.println("There are no pending orders to display.");

            return false;
        }

        orders.forEach(order -> {
            if (!order.getDeliveryStatus())
                System.out.println(order);

        });

        return true;
    }

    public static void listDeliveredOrders(List<Order> orders) {
        if (orders.stream().noneMatch(Order::getDeliveryStatus)) {
            System.out.println("There are no delivered orders to display.");

            return;
        }

        orders.forEach(order -> {
            if (order.getDeliveryStatus())
                System.out.println(order);

        });

    }
}
