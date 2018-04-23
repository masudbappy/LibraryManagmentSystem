package com.masudbappy.unillib.services;

import com.masudbappy.unillib.entities.Author;
import com.masudbappy.unillib.entities.Book;
import com.masudbappy.unillib.entities.Publisher;
import com.masudbappy.unillib.entities.Student;
import com.masudbappy.unillib.repositories.AuthorRepository;
import com.masudbappy.unillib.repositories.BookRepository;
import com.masudbappy.unillib.repositories.PublisherRepository;
import com.masudbappy.unillib.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final StudentRepository studentRepository;


    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository,
                       PublisherRepository publisherRepository, StudentRepository studentRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.studentRepository = studentRepository;
    }

    public Book saveBook(Book book){
        if (book == null) throw new IllegalArgumentException("Book can not be null");
        if (book.getAuthor() !=null && book.getAuthor().getAuthorId() == null){
            Author author = this.authorRepository.save(book.getAuthor());
            book.setAuthor(author);
        }
        if (book.getPublisher() != null && book.getPublisher().getPublisherId() == null){
            Publisher publisher = this.publisherRepository.save(book.getPublisher());
            book.setPublisher(publisher);
        }
        if (book.getStudent() != null && book.getStudent().getStudentId() == null){
            Student student = this.studentRepository.save(book.getStudent());
            book.setStudent(student);
        }
        return this.bookRepository.save(book);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }
}
