package slowboat.slowboat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import slowboat.slowboat.model.Entity.Boat;

public interface BoatRepository extends JpaRepository<Boat, Integer>, BoatRepositoryCustom {
}
