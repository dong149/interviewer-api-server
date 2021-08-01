package com.interview.api.repository.category;

import com.interview.api.entity.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category,Long> {
}
