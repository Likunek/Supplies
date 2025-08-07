package test.supplies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.supplies.model.View;

public interface ViewRepository  extends JpaRepository<View, Integer> {
}
