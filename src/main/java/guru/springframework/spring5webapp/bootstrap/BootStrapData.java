package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnston");
        Book noEJB = new Book("J2EE Development without EJB","2364754857");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher pedguin = new Publisher("Pedguin", "Road Street", "London", "England", "NW1 4ND");
        publisherRepository.save(pedguin);

        ddd.setPublisher(pedguin);
        pedguin.getBooks().add(ddd);
        noEJB.setPublisher(pedguin);
        pedguin.getBooks().add(noEJB);

        bookRepository.save(ddd);
        bookRepository.save(noEJB);
        publisherRepository.save(pedguin);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books:" + bookRepository.count());
        System.out.println("Number of Publishers:" + publisherRepository.count());
        System.out.println("Publisher - pedguin - numbers of books: " + pedguin.getBooks().size());
    }
}
