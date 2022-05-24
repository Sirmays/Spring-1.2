import CartOperations.BuyingProcess;
import Configuration.ApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        BuyingProcess bp = context.getBean(BuyingProcess.class);

        bp.cartService();
    }
}
