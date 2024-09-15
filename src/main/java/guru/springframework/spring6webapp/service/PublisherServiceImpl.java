package guru.springframework.spring6webapp.service;

import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repository.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {

    PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }
    @Override
    public Iterable<Publisher> findAll() {
        return publisherRepository.findAll();
    }
}
