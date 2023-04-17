package co.edu.unisabana.usuario.repository.dao;

import co.edu.unisabana.usuario.repository.dao.entity.BookEntity;
import co.edu.unisabana.usuario.repository.dao.repository.BookRepository;
import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.port.SearchBookPort;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class SearchBookDao implements SearchBookPort {

    private final BookRepository repository;

    @Override
    public boolean validateExistsBook(String nameBook) {
       // AtomicBoolean exists = new AtomicBoolean(false);
       // listBooks.forEach(book -> {
         //   if (book.getName().equals(nameBook)) {
          //      exists.set(true);
         //   }
        //});

        return false;
    }

    @Override
    public List<Book> searchBooks() {
        return repository.findAll()
                .stream()
                .map(BookEntity::toModel)
                .collect(Collectors.toList());
    }
}
