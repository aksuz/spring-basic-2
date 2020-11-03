package spring.basic.module2;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    private List<Product> cart;

    public ProductService() {
        Product p1 = new Product("product1", getRandomPrice());
        Product p2 = new Product("product2", getRandomPrice());
        Product p3 = new Product("product3", getRandomPrice());
        Product p4 = new Product("product4", getRandomPrice());
        Product p5 = new Product("product5", getRandomPrice());

        cart = new ArrayList<>();
        cart.add(p1);
        cart.add(p2);
        cart.add(p3);
        cart.add(p4);
        cart.add(p5);
    }

    private double getRandomPrice() {
        double minimumPrice = 50d;
        double maximumPrice = 300d;

        double randomNumber = minimumPrice + new Random().nextDouble() * (maximumPrice - minimumPrice);
        BigDecimal roundedNumber = new BigDecimal(randomNumber).setScale(2, RoundingMode.HALF_UP);
        double randomPrice = roundedNumber.doubleValue();

        return randomPrice;
    }

    public List<Product> getCart() {
        return cart;
    }
}
