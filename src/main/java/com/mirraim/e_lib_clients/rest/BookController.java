package com.mirraim.e_lib_clients.rest;

import com.mirraim.e_lib_clients.entity.Book;
import com.mirraim.e_lib_clients.service.BookService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private static final String TAG = "Книги клиента";

    private final BookService bookService;

    @ApiOperation(value = "Получить список книг клиента по id", tags = {TAG})
    @GetMapping("client/{id}/books")
    public List<Book> getBooks(@PathVariable("id") Long id) {
        return bookService.getClientBooks(id);
    }

    @ApiOperation(value = "Получить последнюю книгу клиента по id", tags = {TAG})
    @GetMapping("client/{id}/current")
    public Book getLastBook(@PathVariable("id") Long id) {
        return bookService.getLast(id);
    }

    @ApiOperation(value = "Получить книгу клиента по id", tags = {TAG})
    @GetMapping("client/{clientId}/books/{bookId}/read")
    public Book getBook(@PathVariable("bookId") Long id) {
        return bookService.getBook(id);
    }

    @ApiOperation(value = "Добавить книгу клиенту", tags = {TAG})
    @PostMapping("client/{id}/book/add")
    public Book addBook(@PathVariable("id") Long id, @RequestBody Book book) {
        return bookService.addBook(id, book.getGeneralBookId());
    }

    @ApiOperation(value = "Закрыть книгу", tags = {TAG})
    @PostMapping("client/{clientId}/books/{bookId}/close")
    public Book changeProgress(@PathVariable("bookId") Long bookId, @RequestBody Book book) {
        return bookService.changeProgress(bookId, book.getProgress());
    }
}
