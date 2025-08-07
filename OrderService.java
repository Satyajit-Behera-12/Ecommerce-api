package com.EcommerceApplication.Service;

import com.EcommerceApplication.Dto.OrderDTO;
import com.EcommerceApplication.Entity.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(OrderDTO orderDTO);
    List<Order> getAllOrders();
}
