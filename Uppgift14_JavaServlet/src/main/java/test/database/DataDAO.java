package test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import test.Book;


@Transactional
@Repository
public class DataDAO implements IDataDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public DataDAO(){}

	@Override
	public List<Book> fetchBooks() {
		String query = "SELECT * from book";
		return jdbcTemplate.query(query, new BookMapper());
	}

	@Override
	public List<Book> fetchSelectedBooks(String search) {
		String prepared = "'%" + search + "%'";
		String query = "SELECT * from book WHERE title LIKE " + prepared;

		return (List<Book>) jdbcTemplate.query(query, new BookMapper());

	}

	@Override
	public void addbook(Book book) {
		jdbcTemplate.update(
				"INSERT INTO book (title, description) VALUES (?, ?)", book.getTitle(),book.getDescription());

	}

	@Override
	public int update(Book book){
		String query = "UPDATE book SET title = ?, description = ? WHERE id = ?";

		return jdbcTemplate.update(query, book.getTitle(), book.getDescription(), book.getId());

	}

	@Override
	public int delete(int id){
		String query = "delete from book where id = "+id+"";
		return jdbcTemplate.update(query);
	}

	@Override
	public Book getBookById(int id){
		String query = "SELECT * from book WHERE id=?";
		return jdbcTemplate.queryForObject(query, new Object[]{id},new BookMapper());
	}
}