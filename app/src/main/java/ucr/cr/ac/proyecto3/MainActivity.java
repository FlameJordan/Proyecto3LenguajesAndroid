package ucr.cr.ac.proyecto3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ucr.cr.ac.proyecto3.Activities.LoginActivity;
import ucr.cr.ac.proyecto3.Activities.UpdatePacienteActivity;
import ucr.cr.ac.proyecto3.Activities.VerAlergiasActivity;
import ucr.cr.ac.proyecto3.Activities.VerCitasActivity;
import ucr.cr.ac.proyecto3.Activities.VerVacunasActivity;


public class MainActivity extends AppCompatActivity {
Button btn_vercitas;
    Button btn_veralergias;
    Button btn_datospersonales;
    Button btn_vervacunas;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         extras = getIntent().getExtras();

        if (extras==null) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }else{

            TextView t = findViewById(R.id.usuarioid);
            t.setText(extras.getString("Cedula"));

        }

        btn_vercitas = findViewById(R.id.btn_ver_citas);
        btn_veralergias = findViewById(R.id.btn_ver_alergias);

        btn_vervacunas = findViewById(R.id.btn_ver_vacunas);

        btn_vercitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irvercitas();
            }
        });

        btn_veralergias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irveralergias();
            }
        });

        btn_datospersonales = findViewById(R.id.btn_ver_editar);

        btn_datospersonales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irDatosPersonales();
            }
        });

        btn_vervacunas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irVerVacunas();
            }
        });

    }
    public void irvercitas(){
        Intent i = new Intent(this, VerCitasActivity.class);
        i.putExtra("Cedula",extras.getString("Cedula"));
        startActivity(i);
    }

    public void irveralergias(){
        Intent i = new Intent(this, VerAlergiasActivity.class);
        i.putExtra("Cedula",extras.getString("Cedula"));
        startActivity(i);
    }

    public void irDatosPersonales(){
        Intent i = new Intent(this, UpdatePacienteActivity.class);
        i.putExtra("Cedula",extras.getString("Cedula"));
        startActivity(i);
    }

    public void irVerVacunas(){
        Intent i = new Intent(this, VerVacunasActivity.class);
        i.putExtra("Cedula",extras.getString("Cedula"));
        startActivity(i);
    }

}


