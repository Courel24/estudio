package co.edu.unisabana.usuario.repository.dao.repository;

import co.edu.unisabana.usuario.repository.dao.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
}
