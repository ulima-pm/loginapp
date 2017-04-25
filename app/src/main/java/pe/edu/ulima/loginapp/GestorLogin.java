package pe.edu.ulima.loginapp;

import android.widget.Toast;

public class GestorLogin {
    public boolean login(String usuario, String password){
        if (usuario.equals("android")
                && password.equals("1234")){
            // Login correcto
            return true;

        }else{
            // Login incorrecto
            return false;

        }
    }
}
