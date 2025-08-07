package test.supplies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.supplies.model.ListTrailer;

public interface TrailerListRepository extends JpaRepository<ListTrailer, Integer> {
}
