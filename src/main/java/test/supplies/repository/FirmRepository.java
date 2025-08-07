package test.supplies.repository;

import test.supplies.model.Firm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirmRepository extends JpaRepository<Firm, Integer> {
}
