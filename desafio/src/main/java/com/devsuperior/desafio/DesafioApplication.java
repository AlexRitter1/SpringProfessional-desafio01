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

	@Autowired
	private ShippingService shippingService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

		Order order = new Order();

		System.out.print("\nSet code: ");
		order.setCode(scanner.nextInt());
		scanner.nextLine(); // Consome a quebra de linha

		System.out.print("\nSet basic: ");
		while (true) {
			try {
				order.setBasic(scanner.nextDouble());
				scanner.nextLine(); // Consome a quebra de linha
				break;
			} catch (InputMismatchException e) {
				System.out.print("Valor inválido, tente novamente: ");
				scanner.nextLine(); // Limpa o buffer
			}
		}

		System.out.print("\nSet discount: ");
		while (true) {
			try {
				order.setDiscount(scanner.nextDouble());
				scanner.nextLine(); // Consome a quebra de linha
				break;
			} catch (InputMismatchException e) {
				System.out.print("Valor inválido, tente novamente: ");
				scanner.nextLine(); // Limpa o buffer
			}
		}

		double total = orderService.total(order) + shippingService.shipment(order);
		System.out.println("-----------------------");
		System.out.println("Code: " + order.getCode() + "\nTotal: " + total);
		System.out.println("-----------------------");

	}
}
