package Products;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ProductRepository {
    private final List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product(1, "Хлеб", 100));
        products.add(new Product(2, "Молоко", 100));
        products.add(new Product(3, "Морковь", 100));
        products.add(new Product(4, "Вода", 100));
        products.add(new Product(5, "Яблоко", 100));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product findById(Integer id) {
        Product result = null;
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product a = iterator.next();
            if (id.equals(a.getId())) {
                result = a;
            }
        }
        return result;
    }

    public void printAllProduct() {
        System.out.println("Список продуктов в магазине:");
        System.out.println(products);
    }


    @Override
    public String toString() {
        return "ProductRepository{" + "products=" + products + '}';
    }

}
