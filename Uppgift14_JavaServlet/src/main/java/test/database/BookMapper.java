package test.database;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import test.Book;

public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book aBook = new Book();
		aBook.setId(rs.getInt("id"));
		aBook.setTitle(rs.getString("title"));
		aBook.setDescription(rs.getString("description"));	
		return aBook;
	}
}
