package ir.amin.springcore5.data.jpa.booksample;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByTitleContainsOrderByTitleAsc(String title);
}
