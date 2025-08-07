package com.EcommerceApplication.Repository;


import com.EcommerceApplication.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
