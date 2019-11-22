package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Aplication {

    public static void main(String[] args) {
        SpringApplication.run(Aplication.class, args);
    }

    @Bean(name = "HelloServiceFactory")
    public HelloServiceFactory helloFactory(){
        return new HelloServiceFactory();
    }

    @Bean(name = "HelloServicePython")
    public HelloService helloServicePython() throws Exception{
        return helloFactory().getObject();
    }
}
