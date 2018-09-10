package com.example.springdatajpa.controller;

import com.example.springdatajpa.dao.BookDao;
import com.example.springdatajpa.entity.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookDao bookDao;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("bookList", bookDao.findAll());
        modelAndView.setViewName("bookList");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Book book) {
        bookDao.save(book);
        return "forward:/book/list";
    }

    @RequestMapping("/preUpdate/{id}")
    public ModelAndView preUpdate(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("book", bookDao.getOne(id));
        modelAndView.setViewName("bookUpdate");
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Book book) {
        bookDao.save(book);
        return "forward:/book/list";
    }

    @GetMapping("/delete")
    public String delete(Integer id) {
        bookDao.deleteById(id);
        return "forward:/book/list";
    }

    //模糊查询
    @ResponseBody
    @GetMapping("/queryByName")
    public List<Book> queryByName() {
        return bookDao.findByName("思想");
    }

    //随机查询两条数据
    @ResponseBody
    @GetMapping("/randomList")
    public List<Book> randomList() {
        return bookDao.randomList(2);
    }


    //多条件拼接查询
    @RequestMapping("/list2")
    public ModelAndView list2(Book book) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("bookList", bookDao.findAll(new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if (book != null) {
                    if (book.getName() != null && !"".equals(book.getName())) {
                        predicate.getExpressions().add(cb.like(root.get("name"), "%" + book.getName() + "%"));
                    }
                    if (book.getAuthor() != null && !"".equals(book.getAuthor())) {
                        predicate.getExpressions().add(cb.like(root.get("author"), "%" + book.getAuthor() + "%"));
                    }
                }

                return predicate;
            }
        }));
        modelAndView.setViewName("bookList");
        return modelAndView;
    }
}
