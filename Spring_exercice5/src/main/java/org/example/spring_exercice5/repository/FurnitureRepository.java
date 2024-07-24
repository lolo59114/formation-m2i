package org.example.spring_exercice5.repository;

import org.example.spring_exercice5.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
}
