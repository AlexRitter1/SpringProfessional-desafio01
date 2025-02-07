package com.devsuperior.desafio;

import com.devsuperior.desafio.entities.Order;
import com.devsuperior.desafio.services.OrderService;
import com.devsuperior.desafio.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Order order = new Order(1024, 150.0, 20.0);
		System.out.println("Código: " + order.getCode());
		System.out.println("Valor total: " + orderService.total(order));

		Order order2 = new Order(2282, 800.0, 10.0);
		System.out.println("Código: " + order2.getCode());
		System.out.println("Valor total: " + orderService.total(order2));

		Order order3 = new Order(1309, 95.90, 0.0);
		System.out.println("Código: " + order3.getCode());
		System.out.println("Valor total: " + orderService.total(order3));









	}
}
