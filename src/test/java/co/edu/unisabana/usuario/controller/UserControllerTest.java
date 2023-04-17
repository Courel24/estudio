package co.edu.unisabana.usuario.controller;

import co.edu.unisabana.usuario.dto.UserDTO;
import co.edu.unisabana.usuario.dto.UserDTOResponse;
import co.edu.unisabana.usuario.service.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "test")

public class UserControllerTest  {
    private String PATH_USERGREETING = "/hello";
    private String PATH_USERDATA = "/data";
    private String PATH_USERSEARCH = "/search?q=";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void given_hello_when_invoke_greeting_then_return_message(){
        ResponseEntity<String> result = restTemplate.getForEntity(PATH_USERGREETING,String.class);
        Assertions.assertEquals("Hola Mundo",result.getBody());
    }

    @Test
    void given_dataRequest_when_invoke_dataUser_then_return_userdto(){
        UserDTO userDTO = new UserDTO("d","s",20);
        ResponseEntity<UserDTO> result = restTemplate.getForEntity(PATH_USERDATA, UserDTO.class);
        Assertions.assertEquals(userDTO, result.getBody());

    }

    @Test
    void given_variable_when_invoke_dataUserWithPathVariable_then_return_userDTO(){
        String variable = "Yuca";
        UserDTO userDTO = new UserDTO(variable,"s",1);
        String otroDato = "Papa";
        ResponseEntity<UserDTO> result = restTemplate.getForEntity(PATH_USERDATA+"/"+variable+"/"+otroDato,UserDTO.class);
        Assertions.assertEquals(userDTO,result.getBody());
    }

    @Test
    void testSearch(){
        List<UserDTO> lista = new ArrayList<>();
        lista.add(new UserDTO("laura", "Espitia", 19));
        lista.add(new UserDTO("laura", "Piraneque", 19));

        UserDTOResponse userDTOResponse =new UserDTOResponse(lista);
        String q = "laura";
        ResponseEntity<UserDTOResponse> result = restTemplate.getForEntity(PATH_USERSEARCH+q, UserDTOResponse.class);
        Assertions.assertEquals(userDTOResponse,result.getBody());


    }


}
