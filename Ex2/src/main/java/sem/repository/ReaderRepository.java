package sem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sem.model.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
