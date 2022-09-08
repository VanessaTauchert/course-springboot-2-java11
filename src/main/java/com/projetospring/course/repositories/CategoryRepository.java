package com.projetospring.course.repositories;

import com.projetospring.course.entities.Category;
import com.projetospring.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
