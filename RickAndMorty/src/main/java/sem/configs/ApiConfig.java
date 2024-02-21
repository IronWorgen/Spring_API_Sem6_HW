package sem.configs;

import lombok.Data;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "rick-and-morty.url")
@Data
public class ApiConfig {
    private   String allCharacters;
    private   String Character;




}
