package guru.springframework.spring6webapp.service;

import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repository.PublisherRepository;

public interface PublisherService {


    Iterable<Publisher> findAll();
}
