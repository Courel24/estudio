package co.edu.unisabana.usuario.service;


import co.edu.unisabana.usuario.service.model.User;
import co.edu.unisabana.usuario.service.user.RegisterUserService;
import co.edu.unisabana.usuario.service.user.port.RegisterUserPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RegisterUserServiceTest {

  @InjectMocks
  private RegisterUserService registerBookLibrary;

  @Mock
  private RegisterUserPort port;

  @Test
  void Given_userNameIsNull_When_invoke_registerUser_Then_throwIllegalArgument() {
    User user = new User(null, null, null, 18, true, true);
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      registerBookLibrary.registerUser(user);
    });
  }

  @Test
  void Given_userAgeMinor18_When_invoke_registerUser_Then_throwRuntime() {
    User user = new User(1, "Dani", "Saavedra", 17, true, true);
    Assertions.assertThrows(RuntimeException.class, () -> {
      registerBookLibrary.registerUser(user);
    });
  }

  @Test
  void Given_userOk_When_registerUser_Then_return_10() {
    User user = new User(2, "Dani", "Saavedra", 32, true, true);
    Mockito.when(port.addNewUser(user)).thenReturn(true);
    int resultado = registerBookLibrary.registerUser(user);

    Assertions.assertEquals(10, resultado);
    Mockito.verify(port).addNewUser(user);
  }

}
