package com.mirraim.e_lib_clients.data;

import com.mirraim.e_lib_clients.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BookRepository extends CrudRepository<Book, Long> {
}
