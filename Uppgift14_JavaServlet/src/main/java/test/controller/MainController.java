package test.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.Book;

import test.database.DataDAO;
import test.database.IDataDAO;


@Controller
public class MainController {

    @Autowired
    private IDataDAO dataDao;

    @GetMapping("/books")
    public String books(Map<String, Object> model, String query1) {

        List<Book> bookList = dataDao.fetchBooks();

        model.put("books", bookList);

        return "books";
    }

    @GetMapping("/index")
    public String index(Map<String, Object> model, String query1) {
        return "index";
    }

    @RequestMapping("/addbooks")
    public String addbooks(Map<String, Object> model, String query1) {
        return "addbooks";
    }

    @GetMapping("/editbook")
    public String editbook(Map<String, Object> model, String query1) {
        return "editbook";
    }

    @GetMapping("/searchbook")
    public String searchbook(Map<String, Object> model, String query1) {
        return "searchbook";
    }

    @GetMapping("/deletebook")
    public String deletebook(Map<String, Object> model, String query1) {
        return "deletebook";
    }
}