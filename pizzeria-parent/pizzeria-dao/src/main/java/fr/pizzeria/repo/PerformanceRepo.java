package fr.pizzeria.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Performance;

public interface PerformanceRepo extends JpaRepository<Performance, Integer> {

}
