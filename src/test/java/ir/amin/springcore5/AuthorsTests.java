package ir.amin.springcore5;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ir.amin.springcore5.data.jpa.booksample.Author;
import ir.amin.springcore5.data.jpa.booksample.AuthorRepository;
import ir.amin.springcore5.data.jpa.booksample.Book;
import ir.amin.springcore5.data.jpa.booksample.BookRepository;

@DataJpaTest
public class AuthorsTests {

	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	BookRepository bookRepository;

	/**
	 * @TODO It must be Repair
	 */
	@Test
	public void shouldFindAuthorByBookTitles() {
		Book book1 = createBook("book1");
		Book book2 = createBook("book2");
		Book book3 = createBook("book3");
		Book book4 = createBook("book4");
		Book book5 = createBook("book5");
		
		bookRepository.save(book1);
		bookRepository.save(book2);
		bookRepository.save(book3);
		bookRepository.save(book4);
		bookRepository.save(book5);
		
		List<Book> authors1Books = new ArrayList<Book>();
		authors1Books.add(book1);
		authors1Books.add(book2);
		

		List<Book> authors2Books = new ArrayList<Book>();
		authors2Books.add(book3);
		authors2Books.add(book4);
		authors2Books.add(book5);
		
		Author author1 = createAuthor("Author1" , authors1Books);
		Author author2 = createAuthor("Author2" , authors2Books);
		
		authorRepository.save(author1);
		authorRepository.save(author2);
	
		List<Author> findByBooksTitle = authorRepository.findByBooksTitle("book3");
		
		 Assertions.assertThat(findByBooksTitle).hasSize(1);
		 Assertions.assertThat(findByBooksTitle.get(0)).isEqualToComparingFieldByField(book3);
		
	}


	private Author createAuthor(String string, List<Book> authors2Books) {
		Author author = new Author();
		author.setFirstName("Amin");
		author.setLastName("Arab");
		author.setBooks(authors2Books);
		return author;
	}


	private Book createBook(String string) {
		Book book = new Book();
		book.setTitle(string);
		return book;
	}
	
	
}
