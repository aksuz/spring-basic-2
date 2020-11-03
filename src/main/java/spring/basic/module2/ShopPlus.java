package spring.basic.module2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShopPlus  implements Shop {

    @Value("${store-regulations.vat}")
    int vat;

    double total = 0;

    @Override
    public double calculateTotalPrice(List<Product> cart) {
        double sum = 0;
        for (Product product : cart) {
            sum += product.getPrice();
        }
        total = sum + getVat(sum);
        return total;
    }

    @Override
    public void displayTotalPrice() {
        System.out.println("Shop PLUS - total price = " + total);
    }

    private double getVat(double total) {
        return total * vat / 100;
    }
}
