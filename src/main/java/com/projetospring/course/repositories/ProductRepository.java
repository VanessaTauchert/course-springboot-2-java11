package com.projetospring.course.repositories;

import com.projetospring.course.entities.Category;
import com.projetospring.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
