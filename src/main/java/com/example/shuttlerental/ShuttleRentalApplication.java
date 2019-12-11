package com.example.shuttlerental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(FraudChannels.class)
@SpringBootApplication
public class ShuttleRentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShuttleRentalApplication.class, args);
	}

}
