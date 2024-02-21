package sem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sem.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
