package dao.spec;

import entity.Usuario;

public interface LoginDao {
   public Usuario validarlogin(String user);
   public Usuario validarEmail(String email);
}

