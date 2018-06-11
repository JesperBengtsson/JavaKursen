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



}