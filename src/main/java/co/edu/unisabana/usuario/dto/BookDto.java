package co.edu.unisabana.usuario.dto;

import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.model.CategoryBook;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private String name;
    private int year;
    private String author;
    private String rated;
    private String category;


    public Book toModel() {
        boolean rRated = rated.equals("Adult");
        return new Book(this.name, this.year, this.author, rRated, CategoryBook.fromString(category));
    }

    public static BookDto fromModel(Book book) {
        return new BookDto(book.getName(), book.getYear(), book.getAuthor(), String.valueOf(book.isRRated()), book.getCategory().name());
    }
}
