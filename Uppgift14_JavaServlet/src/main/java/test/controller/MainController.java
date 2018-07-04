package test.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import test.Book;

import test.database.DataDAO;
import test.database.IDataDAO;

import javax.validation.Valid;


@Controller
public class MainController {

    @Autowired
    private IDataDAO dataDao;
/*
    @GetMapping("/books")
    public String books(Map<String, Object> model, String query1) {

        List<Book> bookList = dataDao.fetchBooks();

        model.put("books", bookList);

        return "books";
    }*/

    @GetMapping("/index")
    public String index(Map<String, Object> model, String query1) {
        return "index";
    }

    @GetMapping("/addbooks")
    public  String addbooks(@ModelAttribute("Book")Book book) {

        return "addbooks";
    }

    @PostMapping("/addbooks")
    public String addbook(@ModelAttribute("Book")Book book) {
        dataDao.addbook(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "/editbook/{id}")
    public String editBook(Map<String, Object> model, @ModelAttribute("book") Book b, @PathVariable int id) {
        model.put("book", dataDao.getBookById(id));
        return "editbook";
    }

    @PostMapping(value = "/savebook")
    public String saveBook(@ModelAttribute("Book")Book book){
        dataDao.update(book);
        return  "redirect:/books";
    }

    @GetMapping("/books")
    public String books(Map<String, Object> model, @RequestParam(name="search", required=false) String search, String query1) {

        System.out.println(search);

        if (search == null) {
            List<Book> b = dataDao.fetchBooks();
            model.put("books", b);
        } else {
            List<Book> b = dataDao.fetchSelectedBooks(search);
            model.put("books", b);
        }
        return "books";
    }

    @RequestMapping(value="/deletebook/{id}",method = RequestMethod.GET)
    public String deleteBook(@PathVariable int id){
        dataDao.delete(id);
        return  "redirect:/books";
    }
}