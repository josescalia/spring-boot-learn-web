package org.josescalia.blog.simple.config;

import org.apache.log4j.Logger;
import org.josescalia.blog.simple.model.Author;
import org.josescalia.blog.simple.model.Book;
import org.josescalia.blog.simple.model.Publisher;
import org.josescalia.blog.simple.repository.AuthorRepository;
import org.josescalia.blog.simple.repository.BookRepository;
import org.josescalia.blog.simple.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by josescalia on 03/02/16.
 */
@Component
public class DataInitializer {
    static Logger logger = Logger.getLogger(DataInitializer.class.getName());

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    BookRepository bookRepository;

    @PostConstruct  //need to trigger this to fill up firstData
    public void initData(){
        logger.info("Init Data Invoked");
        if(((List<Author>) authorRepository.findAll()).size() == 0) { //detect if no data on authorTable
            List<Author> authorList = new ArrayList<Author>();

            logger.info("No Data in table author");
            Author author = new Author();
            author.setAuthorName("Josescalia");
            author.setAuthorAddress("Jakarta");
            authorList.add(author);

            author = new Author();
            author.setAuthorName("Somebody");
            author.setAuthorAddress("Anywhere");
            authorList.add(author);

            authorRepository.save(authorList);

            Publisher publisher = new Publisher();
            publisher.setPublisherName("Gemah Ripah Loh Jinawi Press");
            publisher = publisherRepository.save(publisher);


            Book book = new Book();
            book.setAuthor(authorRepository.findOne((long)1));
            book.setBookTitle("Java 2nd Edition");
            book.setPublisher(publisher);
            bookRepository.save(book);

        }
    }
}
