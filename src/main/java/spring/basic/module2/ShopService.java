package spring.basic.module2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private ShopStart shopStart;
    private ShopPlus shopPlus;
    private ShopPro shopPro;
    private ProductService productService;

    @Autowired
    public ShopService(ShopStart shopStart, ShopPlus shopPlus, ShopPro shopPro, ProductService productService) {
        this.shopStart = shopStart;
        this.shopPlus = shopPlus;
        this.shopPro = shopPro;
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showCart() {
        List<Product> cart = productService.getCart();

        shopStart.calculateTotalPrice(cart);
        shopStart.displayTotalPrice();

        shopPlus.calculateTotalPrice(cart);
        shopPlus.displayTotalPrice();

        shopPro.calculateTotalPrice(cart);
        shopPro.displayTotalPrice();
    }
}
