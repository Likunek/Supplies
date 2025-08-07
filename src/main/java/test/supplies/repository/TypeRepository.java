package test.supplies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.supplies.model.Type;

public interface TypeRepository  extends JpaRepository<Type, Integer> {
}
