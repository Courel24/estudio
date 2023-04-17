package co.edu.unisabana.usuario.service.library;

import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.model.CategoryBook;
import co.edu.unisabana.usuario.service.library.port.AddBookPort;
import co.edu.unisabana.usuario.service.library.port.RegisterBookPort;
import co.edu.unisabana.usuario.service.library.port.SearchBookPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RegisterBookLibraryTest {


    @InjectMocks
    private RegisterBookLibrary registerbook;


    @Mock
    private SearchBookPort searchBookPort;
    @Mock
    private RegisterBookPort registerBookPort;
    @Mock
    private AddBookPort addBookPort;
    @Test
    public void given_already_registered_book_when_invoke_registerBook_then_return_1 (){
        Book book = new Book("pepito",1500, "Roberto", true, CategoryBook.fromString("suave"));
        Mockito.when(searchBookPort.validateExistsBook(book.getName())).thenReturn(true);
        int result = registerbook.registerBook(book);
        Assertions.assertEquals(1,result);
        Mockito.verify(searchBookPort).validateExistsBook(book.getName());
        Mockito.verify(addBookPort).addBook(book.getName());
    }

    @Test
    public void given_new_book_invoke_registerbook_then_return_2(){
        Book book = new Book("pepito",1500, "Roberto", true, CategoryBook.fromString("suave"));
        Mockito.when(searchBookPort.validateExistsBook(book.getName())).thenReturn(false);
        int result = registerbook.registerBook(book);


        Assertions.assertEquals(2,result);
        Mockito.verify(searchBookPort).validateExistsBook(book.getName());
        Mockito.verify(registerBookPort).registerBook(book);
    }

}
