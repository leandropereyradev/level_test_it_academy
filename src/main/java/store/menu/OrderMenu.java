package store.menu;

import store.model.delivery.DeliveryMethod;

public class OrderMenu {
    public static void printDeliveryMethodOptions() {
        for (DeliveryMethod method : DeliveryMethod.values())
            System.out.println("\t" + method.getOPTION() + ". " +
                    method.getMETHOD() +
                    "\n\tAdditional cost on the total: " + method.getPERCENTAGE() + "\n"
            );

        System.out.print("Select an option: ");
    }
}
