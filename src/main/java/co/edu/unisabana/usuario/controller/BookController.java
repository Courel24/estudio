package co.edu.unisabana.usuario.controller;

import co.edu.unisabana.usuario.dto.BookDto;
import co.edu.unisabana.usuario.dto.BookReponse;
import co.edu.unisabana.usuario.service.library.RegisterBookLibrary;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.unisabana.usuario.service.library.SearchBookLibrary;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {

    private final RegisterBookLibrary registerBookLibrary;
    private final SearchBookLibrary searchBookLibrary;

    // Pendiente validar uso de exception handler
    // explicar camel case
    @PostMapping("/register")
    @ResponseBody
    public BookReponse registerBook(@RequestBody BookDto bookDto) {
        int result = registerBookLibrary.registerBook(bookDto.toModel());
        if (result == 1) {
            return new BookReponse("Actualizada cantidad");
        }
        return new BookReponse("Nuevo libro registrado");


    }

    @GetMapping("/search")
    public List<BookDto> findBooks() {
        return searchBookLibrary.searchBooks()
                .stream()
                .map(BookDto::fromModel)
                .collect(Collectors.toList());
    }

}
