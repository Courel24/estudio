package co.edu.unisabana.usuario.controller;

import co.edu.unisabana.usuario.dto.BookDto;
import co.edu.unisabana.usuario.dto.BookReponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "test")
public class BookControllerTest {

    private String PATH_REGISTER="/book/register";
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    void registerbookTest(){

        BookDto bookDto = new BookDto("s",1,"a","true","suave");

        ResponseEntity<BookReponse> result = restTemplate.postForEntity(PATH_REGISTER, bookDto,BookReponse.class);

        Assertions.assertEquals(new BookReponse("Nuevo libro registrado"),result.getBody());

    }

}
