package slowboat.slowboat.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import slowboat.slowboat.model.Entity.Boat;
import slowboat.slowboat.model.Entity.Category;

import java.util.List;

public interface BoatRepositoryCustom {

   Boat findMaxBoat();

   int findMaxBoatId();
   Boat findBoatRandomly();

   Page<Boat> getBoatByCategory(Category category, Pageable pageable);
}
