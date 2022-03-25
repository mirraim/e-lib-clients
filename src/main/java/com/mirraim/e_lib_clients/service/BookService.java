package com.mirraim.e_lib_clients.service;

import com.mirraim.e_lib_clients.entity.Book;

import java.util.List;

public interface BookService {

    Book addBook(Long clientId, Long generalBookId);
    List<Book> getClientBooks(Long clientId);
    Book getLast(Long clientId);

    Book getBook(Long bookId);

    Book changeProgress(Long bookId, int progress);
}
