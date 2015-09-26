package Modelo;

public class DAO {
    public Usuario exist(Usuario u){
        if (u.getMail().equalsIgnoreCase("j@j.com")){
            //mail OK
            if (u.getPass().equalsIgnoreCase("1122")){
                //pass OK
                return new Usuario(u.getMail(), u.getPass(), "Martín");
            }
            else{
                //Pass incorrecta
                Usuario newUser = new Usuario(u.getMail(), u.getPass(), "Martín");
                newUser.agregarError(new Error(100,"Password incorrecta"));
                return newUser;
            }
        }
        else{
            //mail incorrecto
            Usuario newUser = new Usuario(u.getMail(), u.getPass(), "Martín");
            newUser.agregarError(new Error(200,"Mail incorrecto"));
            return newUser;
        }
    }
}
