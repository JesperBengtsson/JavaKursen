package test.database;


import java.util.List;

import test.Book;



public interface IDataDAO {
	public List<Book> fetchBooks();
	public void addbook(Book book);
	public int update(Book book);
	int delete(int id);
	Book getBookById(int id);
	List<Book> fetchSelectedBooks(String search);
}