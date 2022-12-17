package ir.amin.springcore5.data.jpa.booksample;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

/**
 * @author aminarab
 *
 */
@Entity
public class Author {

	@Id
	@GeneratedValue
	Long id;
	
	@Version
	int version;
	
	@Column
	String firstName;
	
	@Column
	String lastName;
	
	@ManyToMany
	List<Book> books;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", version=" + version + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", books=" + books + "]";
	}
	
	
	
}
