package ProductCart;

import Products.Product;
import Products.ProductRepository;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Cart {

    private List<Product> productsInCart;
    private final ProductRepository productRepository;

    public Cart(List<Product> productsInCart, ProductRepository productRepository) {
        this.productsInCart = productsInCart;
        this.productRepository = productRepository;
    }

    public void addProduct(Integer id) {
        productsInCart.add(productRepository.findById(id));
    }

    public void removeProduct(Integer id) {
        Product result = null;
        Iterator<Product> iterator = productsInCart.iterator();
        while (iterator.hasNext()) {
            Product a = iterator.next();
            if (id.equals(a.getId())) {
                result = a;
            }
        }
        productsInCart.remove(result);

    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(List<Product> productsInCart) {
        this.productsInCart = productsInCart;
    }

    public void printProducts() {
        if (productsInCart.isEmpty()) {
            System.out.println("Сейчас в корзине пусто");
        } else {
            System.out.println("Сейчас в корзине: \n" + productsInCart);
        }

    }
}

