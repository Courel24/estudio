package co.edu.unisabana.usuario.service;


import co.edu.unisabana.usuario.service.library.RegisterBookLibrary;
import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.model.CategoryBook;
import co.edu.unisabana.usuario.service.library.port.AddBookPort;
import co.edu.unisabana.usuario.service.library.port.RegisterBookPort;
import co.edu.unisabana.usuario.service.library.port.SearchBookPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RegisterBookLibraryTest {

  @InjectMocks
  private RegisterBookLibrary registerBookLibrary;

  @Mock
  private SearchBookPort searchBookPort;

  @Mock
  private AddBookPort addBookPort;

  @Mock
  private RegisterBookPort registerBookPort;


/*
  public int registerBook(Book book) {
    boolean exists = searchBookPort.validateExistsBook(book.getName());
    if (exists) {
      addBookPort.addBook(book.getName());
      return 1;
    } else {
      registerBookPort.registerBook(book);
      return 2;
    }
  }
 */

  @Test
  void given_libro_existen_when_invoke_registerBook_then_return_1() {
    Mockito.when(searchBookPort.validateExistsBook("Los pecados de los Devs")).thenReturn(true);
    Book libro = new Book("Los pecados de los Devs", 1991, "Daniel", true, CategoryBook.EBOOK);
    int result = registerBookLibrary.registerBook(libro);
    assertEquals(1, result);
    Mockito.verify(addBookPort).addBook(libro.getName());
  }

}
