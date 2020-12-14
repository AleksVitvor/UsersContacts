package com.aleks._8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.mail.MessagingException;
import javax.mail.Session;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException, MessagingException {
		Sender.send();
		SpringApplication.run(Application.class, args);
	}

}
