package co.edu.unisabana.usuario.repository.dao.entity;

import co.edu.unisabana.usuario.service.library.model.Book;

import javax.persistence.*;

import co.edu.unisabana.usuario.service.library.model.CategoryBook;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "BOOK_ENTTITY")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookEntity {

    private String name;
    private int releaseYear;
    private String author;
    private boolean rRated;
    private String category;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int quantity;

    public BookEntity(String name, int year, String author, boolean rRated, String category, int quantity) {
        this.name = name;
        this.releaseYear = year;
        this.author = author;
        this.rRated = rRated;
        this.category = category;
        this.quantity = quantity;
    }

    public static BookEntity fromModel(Book book) {
        return new BookEntity(book.getName(), book.getYear(), book.getAuthor(), book.isRRated(), book.getCategory().name(), 1);
    }

    public Book toModel() {
        return new Book(this.name, this.releaseYear, this.author, this.rRated, CategoryBook.valueOf(this.category));
    }
}
