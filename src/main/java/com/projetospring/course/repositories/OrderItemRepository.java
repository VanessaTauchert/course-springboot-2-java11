package com.projetospring.course.repositories;

import com.projetospring.course.entities.OrderItem;
import com.projetospring.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
