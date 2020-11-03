package spring.basic.module2;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShopStart implements Shop {
    double total = 0;

    @Override
    public double calculateTotalPrice(List<Product> cart) {
        for (Product product : cart) {
            total += product.getPrice();
        }
        return total;
    }

    @Override
    public void displayTotalPrice() {
        System.out.println("Shop START - total price = " + total);
    }
}
