package de.ait.library.app.configuration;

import de.ait.library.app.repository.BookRepository;
import de.ait.library.app.repository.BookRepositoryInterface;
import de.ait.library.app.repository.BookRepositoryJDBC;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Value("${repository.type}")
    private String repositoryType;

    @Autowired
    private ConfigurableApplicationContext context;

    @Bean
    BookRepositoryInterface getRepository(){
        if(repositoryType.equalsIgnoreCase("list")){
            return context.getBean(BookRepository.class);
        }  else {
            return context.getBean(BookRepositoryJDBC.class);
        }
    }
    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

}
