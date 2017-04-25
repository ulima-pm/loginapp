package pe.edu.ulima.loginapp;

import android.content.Intent;
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

    public static final int COD_REQ = 1000;

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
                Intent intent = new Intent();
                intent.setClass(this, ActivityDestino.class);
                Bundle data = new Bundle();
                data.putString(
                        "NOMBRE_USUARIO",
                        eteUsername.getText().toString()
                );
                data.putInt("NUMERO", 10);
                intent.putExtras(data);
                startActivityForResult(intent, COD_REQ);
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

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == COD_REQ){
            int valorEntero = data.getIntExtra("VALOR", 0);
        }
    }
}
