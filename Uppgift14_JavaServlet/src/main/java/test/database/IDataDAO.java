package test.database;


import java.util.List;

import test.Book;



public interface IDataDAO {
	public List<Book> fetchBooks();
}