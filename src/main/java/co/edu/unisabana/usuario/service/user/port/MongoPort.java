package co.edu.unisabana.usuario.service.user.port;

import co.edu.unisabana.usuario.service.model.User;

public interface MongoPort {

  boolean addNewUser(User user);
}
