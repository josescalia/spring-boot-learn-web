package org.josescalia.blog.simple.controller;

import org.apache.log4j.Logger;
import org.josescalia.blog.simple.model.Author;
import org.josescalia.blog.simple.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by josescalia on 03/02/16.
 */
@Controller
public class AuthorController {

    static Logger logger = Logger.getLogger(AuthorController.class.getName());

    @Autowired
    public AuthorRepository authorRepository;

    @RequestMapping(value = "/service/json/author/list", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Author> getList() {
        return (List<Author>) authorRepository.findAll();
    }


    @RequestMapping(value = "/author/list", method = RequestMethod.GET)
    public String getList(Map<String, Object> objectMap) {
        objectMap.put("authorList", (List<Author>) authorRepository.findAll());
        return "author/list";
    }


    @RequestMapping(value = "/author/edit", method = RequestMethod.GET)
    public String edit(@RequestParam Long id, Map<String, Object> objectMap) {
        Author author = authorRepository.findOne(id);
        objectMap.put("model", author);
        return "/author/edit";
    }

    @RequestMapping(value = "/service/json/author/save", method = RequestMethod.POST)
    public @ResponseBody String saveAuthor(Author author) {
        try {
            authorRepository.save(author);
            return "Save Succeed";
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "Save Failed : " + e.getMessage();
        }
    }


}
