package com.devsuperior.desafio.services;

import com.devsuperior.desafio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public double total(Order order){

        // Calcula o valor do desconto
        double desconto = order.getBasic() * (order.getDiscount() / 100.0);

        // Calcula o valor final
        double total = order.getBasic() - desconto;

        return total;
    }
}
