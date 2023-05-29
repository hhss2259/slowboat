package slowboat.slowboat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import slowboat.slowboat.model.Entity.Writer;

public interface WriterRepository extends JpaRepository<Writer, String> {


}
