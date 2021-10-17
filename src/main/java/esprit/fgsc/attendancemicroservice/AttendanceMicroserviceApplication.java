package esprit.fgsc.attendancemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AttendanceMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceMicroserviceApplication.class, args);
	}

}
