package spring.basic.module2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShopPro implements Shop {

    @Value("${store-regulations.vat}")
    int vat;
    @Value("${store-regulations.discount}")
    int discount;

    double total = 0;

    @Override
    public double calculateTotalPrice(List<Product> cart) {
        double sum = 0;
        for (Product product : cart) {
            sum += product.getPrice();
        }
        total = sum + getVat(sum) - getDiscount(sum);
        return total;
    }

    @Override
    public void displayTotalPrice() {
        System.out.println("Shop PRO - total price = " + total);
    }

    private double getDiscount(double total) {
        return total * discount / 100;
    }

    private double getVat(double total) {
        return total * vat / 100;
    }
}
