package spring.basic.module2;

import java.util.List;

public interface Shop {
    double calculateTotalPrice(List<Product> cart);
    void displayTotalPrice();
}
