package ir.amin.springcore5.data.jpa.booksample;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	 
	List<Author> findByBooksTitle(String title);
 
}
