package test.supplies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.supplies.model.Waybill;

public interface WaybillRepository  extends JpaRepository<Waybill, Integer> {
}
