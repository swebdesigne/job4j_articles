package ood.lsp.order;

public class OrderStockValidator {
    public boolean isValid(Order order) {
        for (Item item : order.getItems()) {
            if (!item.isInStock()) {
                return false;
            }
        }
        return true;
    }
}
