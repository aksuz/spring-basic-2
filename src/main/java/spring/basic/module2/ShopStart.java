package spring.basic.module2;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShopStart implements Shop {
    double total = 0;

    @Override
    public double calculateTotalPrice(List<Product> cart) {
        total = cart.stream()
                .mapToDouble(Product::getPrice)
                .sum();
        return total;
    }

    @Override
    public void displayTotalPrice() {
        System.out.println();
        System.out.println("Shop PLUS");
        System.out.println("- total price = " + total);
    }

}
