package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repository.AuthorRepository;
import guru.springframework.spring6webapp.repository.BookRepository;
import guru.springframework.spring6webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    BookRepository bookRepository;
    AuthorRepository authorRepository;
    PublisherRepository publisherRepository;

    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository,
                         PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("1234");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEjb = new Book();
        noEjb.setTitle("NoEjb");
        noEjb.setIsbn("12345");

        Author rodSaved = authorRepository.save(rod);
        Book savedNoEjb = bookRepository.save(noEjb);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(savedNoEjb);

        Publisher publisher = new Publisher();
        publisher.setName("My publisher");
        publisher.setAddress("address");
        publisher.setCity("city");
        publisher.setState("state");

        Publisher savedPublisher = publisherRepository.save(publisher);

        dddSaved.setPublisher(savedPublisher);
        savedNoEjb.setPublisher(savedPublisher);

        bookRepository.save(dddSaved);
        bookRepository.save(savedNoEjb);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);


        System.out.println("In Bootstrap");
        System.out.println("Books Count : " + bookRepository.count());
        System.out.println("Authors Count : " + authorRepository.count());
        System.out.println("Publisher Count : " + publisherRepository.count());


    }


}
