package work.chen.jpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JpaDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(JpaDemoApplication.class, args);
  }

}
