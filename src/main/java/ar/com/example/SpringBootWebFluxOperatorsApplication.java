package ar.com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

@SpringBootApplication
@Slf4j
public class SpringBootWebFluxOperatorsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebFluxOperatorsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Flux<String> nombres = Flux.just("Maximiliano","Marta","Yesica","Luciana","Karen", "Marcelo")
        .doOnNext(e-> {
            if(e.isEmpty()){
                throw new RuntimeException("Hay un elemento vacio");
            }            else{
                System.out.println("Elemento: " + e);
            }
        })        ;
        nombres.subscribe(e-> log.info("Elemento:" + e),
                error -> log.error(error.getMessage()));
    }
}
