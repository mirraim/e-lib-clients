package com.mirraim.e_lib_clients.service.impl;

import com.mirraim.e_lib_clients.data.BookRepository;
import com.mirraim.e_lib_clients.entity.Book;
import com.mirraim.e_lib_clients.entity.Client;
import com.mirraim.e_lib_clients.exception.NotFoundBookException;
import com.mirraim.e_lib_clients.service.BookService;
import com.mirraim.e_lib_clients.service.ClientsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private ClientsService clientsService;
    @Override
    @Transactional
    public Book addBook(Long clientId, Long generalBookId) {
        clientsService.getClient(clientId);
        Book book = Book.builder()
                .generalBookId(generalBookId)
                .clientId(clientId)
                .progress(0)
                .build();
        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public List<Book> getClientBooks(Long clientId) {
        Client client = clientsService.getClient(clientId);
        return client.getClientBooks();
    }

    @Override
    @Transactional
    public Book getLast(Long clientId) {
        Client client = clientsService.getClient(clientId);
        return client.getClientBooks().stream()
                .filter(book -> book.getLastReading() != null)
                .max(Comparator.comparing(Book::getLastReading))
                .orElseThrow(NotFoundBookException::new);
    }

    @Override
    public Book getBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(NotFoundBookException::new);
        book.setLastReading(Instant.now());
        return book;
    }

    @Override
    @Transactional
    public Book changeProgress(Long bookId, int progress) {
        Book book = bookRepository.findById(bookId).orElseThrow(NotFoundBookException::new);
        book.setProgress(progress);
        book.setLastReading(Instant.now());
        return book;
    }
}
