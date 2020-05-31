package rates.api.test.configuration;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:configuration/config.properties")
@ComponentScan(basePackages = {"rates.api.test", "rates.api"})
public class TestConfiguration {


}
