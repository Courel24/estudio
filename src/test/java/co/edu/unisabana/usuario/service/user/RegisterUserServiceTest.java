package co.edu.unisabana.usuario.service.user;

import co.edu.unisabana.usuario.service.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RegisterUserServiceTest {

    @InjectMocks
    private RegisterUserService registerUserService;

    @Test
    void given_null_name_When_invoke_registerUser_then_return_illegalEx(){
        User user = new User();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            registerUserService.registerUser(user);
        }, "The name cannot be empty");

    }

    @Test
    void given_age_less_than_19_When_invoke_registerUser_then_return_RuntimeEx(){

        User user = new User(1,"Tony","Perez",15,true,true);
        Assertions.assertThrows(RuntimeException.class, () -> {
            registerUserService.registerUser(user);
        }, "The age cannot be minior 18");
    }

    @Test
    void given_(){

    }


}
