package pe.edu.ulima.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, View.OnLongClickListener{
    EditText eteUsername, etePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eteUsername = (EditText) findViewById(R.id.eteUsername);
        etePassword = (EditText) findViewById(R.id.etePassword);
        Button butClick = (Button) findViewById(R.id.butClick);
        Button butSalir = (Button) findViewById(R.id.butSalir);

        butClick.setOnClickListener(this);
        butSalir.setOnLongClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // poner codigo
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.butClick){
            GestorLogin gestor = new GestorLogin();
            boolean login = gestor.login(
                    eteUsername.getText().toString(),
                    etePassword.getText().toString()
            );
            if (login){
                Toast.makeText(this, "Login correcto", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Error en login", Toast.LENGTH_LONG).show();
            }
        }else if (view.getId() == R.id.butSalir){
            // Deberia salir de la app
            finish();
        }


    }

    @Override
    public boolean onLongClick(View view) {
        finish();
        return false;
    }
}
