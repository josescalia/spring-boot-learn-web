package org.josescalia.blog.simple.controller;

import org.apache.log4j.Logger;
import org.josescalia.blog.simple.model.Publisher;
import org.josescalia.blog.simple.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by josescalia on 06/02/16.
 */
@Controller
public class PublisherController {

    static Logger logger = Logger.getLogger(PublisherController.class.getName());

    @Autowired
    private PublisherRepository publisherRepository;

    @RequestMapping(value = "/publisher/list")
    public String getPublisherList(Map<String, Object> objectMap) {
        objectMap.put("publisherList", publisherRepository.findAll());
        return "/publisher/list";
    }


    @RequestMapping(value = "/publisher/edit", method = RequestMethod.GET)
    public String edit(@RequestParam Long id, Map<String, Object> objectMap) {
        Publisher publisher = publisherRepository.findOne(id);
        objectMap.put("model", publisher);
        return "/publisher/edit";
    }

    @RequestMapping(value = "/service/json/publisher/save", method = RequestMethod.POST)
    public @ResponseBody String savePublisher(Publisher publisher) {
        try {
            publisherRepository.save(publisher);
            return "Save Succeed";
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "Save Failed : " + e.getMessage();
        }
    }
}
