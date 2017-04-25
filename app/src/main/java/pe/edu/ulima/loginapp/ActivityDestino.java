package pe.edu.ulima.loginapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityDestino extends Activity
        implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destino);

        Button butRegresar = (Button) findViewById(R.id.butRegresar);
        butRegresar.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String nombreUsuario = data.getString("NOMBRE_USUARIO");
        int numero = data.getInt("NUMERO");

        Toast.makeText(
                this,
                "Hola " + nombreUsuario,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("VALOR", 200);
        setResult(300, intent);
        finish();
    }
}
