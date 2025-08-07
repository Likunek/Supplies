package test.supplies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.supplies.model.Passport;

public interface PassportRepository extends JpaRepository<Passport, Integer> {
}
