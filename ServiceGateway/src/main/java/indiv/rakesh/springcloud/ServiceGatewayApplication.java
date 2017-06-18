package indiv.rakesh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import indiv.rakesh.springcloud.filters.AccessLogFilter;

@SpringBootApplication
@EnableZuulProxy
public class ServiceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceGatewayApplication.class, args);
	}
	
	
	@Bean
	public AccessLogFilter accessLogFilter(){
		return new AccessLogFilter();
	}
}
