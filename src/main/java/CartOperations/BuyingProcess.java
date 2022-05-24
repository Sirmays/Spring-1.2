package CartOperations;

import ProductCart.Cart;
import Products.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class BuyingProcess {
    private ProductRepository productRepository;
    private Cart cart;
    Scanner sc = new Scanner(System.in);

    public BuyingProcess(ProductRepository productRepository, Cart cart) {
        this.productRepository = productRepository;
        this.cart = cart;
    }

    public void cartService() {

        mainMenu(sc);

    }

    public void mainMenu(Scanner sc) {
        cart.printProducts();
        System.out.println("Ожидаются операции с продуктами[1-добавить продукт,2-удалить продукт; выход - уйти]: ");

        while (true) {
            String str = sc.nextLine();
            if (str.equals("1")) {
                addProducts(sc);
                break;
            }
            if (str.equals("2")) {
                removeProducts(sc);
                break;
            }
            if (str.equals("выход")) {
                System.out.println("До свидания!");
                break;
            }
        }

    }

    public void addProducts(Scanner sc) {
        System.out.println("Просьба, выбрать нужный продукт (0-выйти в главное меню):");
        productRepository.printAllProduct();
        while (true) {
            String str = sc.nextLine();
            if (str.equals("0")) {
                mainMenu(sc);
                break;
            } else {
                cart.addProduct(Integer.parseInt(str));
                cart.printProducts();
                productRepository.printAllProduct();
            }
        }
    }

    public void removeProducts(Scanner sc) {
        System.out.println("Просьба, выбрать продукт для удаления (0-выйти в главное меню):");
        cart.printProducts();
        while (true) {
            String str = sc.nextLine();
            if (str.equals("0")) {
                mainMenu(sc);
                break;
            } else {
                cart.removeProduct(Integer.parseInt(str));
                cart.printProducts();
            }
        }

    }


}


