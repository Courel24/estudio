package co.edu.unisabana.usuario.util;

import co.edu.unisabana.usuario.service.model.User;

public class FactoryTest {

  public static User createUser(boolean vip){
    User user = new User();
    user.setName("Daniel");
    user.setAge(19);
    user.setVip(vip);
    return user;
  }
}
