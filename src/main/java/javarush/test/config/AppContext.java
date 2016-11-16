package javarush.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AppContext {
    @Autowired
    Environment environment;

    @Autowired
    HibernateConfig hibernateConfig;

    @Bean
    public AppInitialiser dataLoader(){
        return new AppInitialiser();
    }
}
