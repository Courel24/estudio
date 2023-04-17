package co.edu.unisabana.usuario.service.library;

import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.port.SearchBookPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SearchBookLibrary {

    private final SearchBookPort searchBookPort;

    public List<Book> searchBooks() {
        return searchBookPort.searchBooks();
    }
}
