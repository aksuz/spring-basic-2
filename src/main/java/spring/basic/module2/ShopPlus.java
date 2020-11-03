package spring.basic.module2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Stream;

@Component
public class ShopPlus implements Shop {

    @Value("${store-regulations.vat}")
    int vat;

    double total = 0;

    @Override
    public double calculateTotalPrice(List<Product> cart) {
        total = cart.stream()
                .mapToDouble(Product::getPrice)
                .sum();
        return total;
    }

    private BigDecimal calculateVat() {
        return new BigDecimal(total * vat / 100).setScale(2, RoundingMode.HALF_DOWN);
    }

    private BigDecimal getFinalPrice() {
        BigDecimal finalPrice = BigDecimal.valueOf(total).add(calculateVat());
        return finalPrice.setScale(2, RoundingMode.HALF_DOWN);
    }

    @Override
    public void displayTotalPrice() {
        System.out.println();
        System.out.println("Shop PLUS");
        System.out.println("- total price = " + total);
        System.out.println("- vat = " + calculateVat());
        System.out.println("Final price = " + getFinalPrice());
    }

}
