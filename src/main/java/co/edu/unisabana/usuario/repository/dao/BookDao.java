package co.edu.unisabana.usuario.repository.dao;

import co.edu.unisabana.usuario.exception.PreliminaryRegisterException;
import co.edu.unisabana.usuario.repository.dao.entity.BookEntity;
import co.edu.unisabana.usuario.repository.dao.repository.BookRepository;
import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.port.AddBookPort;
import co.edu.unisabana.usuario.service.library.port.RegisterBookPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class BookDao implements RegisterBookPort, AddBookPort {

    private final BookRepository repository;

    @Override
    public void registerBook(Book newBook) {
        BookEntity bookEntity = BookEntity.fromModel(newBook);
        repository.save(bookEntity);
    }

    @Override
    public boolean addBook(String name) {
        // for (BookEntity book : listBooks) {
        //    if (book.getName().equals(name)) {
        //        book.setQuantity(book.getQuantity() + 1);
        //       return true;
        //   }
        // }
        //Para evitar confusiones futuras, se debe crear excepciones personalizadas conforme existan reglas de negocio
        //que las ameriten. POR FAVOR AGREGUEN CONTEXTO
        throw new PreliminaryRegisterException(name);
    }
}
