package com.lasinisipsara.order_service.service;

import com.lasinisipsara.order_service.client.InventoryClient;
import com.lasinisipsara.order_service.dto.OrderRequest;
import com.lasinisipsara.order_service.model.Order;
import com.lasinisipsara.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    public void placeOrder(OrderRequest orderRequest){

        var isProductInStock=inventoryClient.isInStock(orderRequest.skuCode(),orderRequest.quantity());
        //map the orderRequest to Order
        if(isProductInStock){
            Order order=new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());

            //save the Order in database
            orderRepository.save(order);
        }else{
            throw new RuntimeException("product with skucode"+orderRequest.skuCode()+"not in stock");
        }


    }
}
