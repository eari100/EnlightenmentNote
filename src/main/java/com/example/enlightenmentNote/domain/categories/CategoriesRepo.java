package com.example.enlightenmentNote.domain.categories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriesRepo extends JpaRepository<Categories, UUID> {
}
