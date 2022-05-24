package Configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"Products","ProductCart","CartOperations"})
public class ApplicationConfiguration {

}
