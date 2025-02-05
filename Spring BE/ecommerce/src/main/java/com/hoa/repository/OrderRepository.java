package com.hoa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hoa.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	@Query("SELECT o From Order o Where o.user.id = :userId And (o.orderStatus = 'PLACED' OR o.orderStatus = 'CONFIRMED' OR o.orderStatus = 'SHIPPED' OR o.orderStatus = 'DELIVERED')")
	public List<Order> getUserOrders(@Param("userId") Long userId);
}
