package echoserver;

import echoserver.servlets.EchoServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class EchoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EchoApplication.class, args);
    }

    @Bean
    ServletRegistrationBean myServletRegistration() {
        ServletRegistrationBean srb = new ServletRegistrationBean();
        srb.setServlet(new EchoServlet());
        srb.setUrlMappings(Arrays.asList("/*"));
        return srb;
    }

}
