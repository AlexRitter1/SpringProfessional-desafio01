package com.devsuperior.desafio.services;

import com.devsuperior.desafio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order){
        double ship = 0.0;
        if (order.getBasic() < 100.0) {
            return ship = 20.0;
        } else if (order.getBasic() >= 100.0 && order.getBasic() <= 200.0) {
            return ship = 12.0;
        } else {
            return ship; //=0
        }
    }
}
