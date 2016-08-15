package org.Banque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("spring-bean.xml") //1ere solution
public class BanqueApplication 
{
	public static void main(String[] args)
        {
            SpringApplication.run(BanqueApplication.class, args);
	}
}
