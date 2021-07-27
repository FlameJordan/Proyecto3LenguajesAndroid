package ucr.cr.ac.proyecto3.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import ucr.cr.ac.proyecto3.R;

public class DetallesVacunaActivity extends AppCompatActivity {
    Bundle extras;
    TextView cedula_paciente;
    TextView vacuna_nombre;
    TextView fecha_apli;
    TextView proxima_dosis;
    TextView centro_salud;
    TextView descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_vacuna);
        extras = getIntent().getExtras();
        cedula_paciente = findViewById(R.id.cedula_paciente_vacuna);
        vacuna_nombre = findViewById(R.id.vacuna_nombre);
        fecha_apli = findViewById(R.id.vacuna_fechaapli);
        proxima_dosis = findViewById(R.id.vacuna_fechaproxi);
        centro_salud = findViewById(R.id.vacuna_centrosalud);
        descripcion = findViewById(R.id.vacuna_descripcion);

        cedula_paciente.setText(""+extras.getString("Cedula"));
        vacuna_nombre.setText(""+extras.getString("Vacuna"));
        fecha_apli.setText(""+extras.getString("Fecha1"));
        proxima_dosis.setText(""+extras.getString("Fecha2"));
        centro_salud.setText(""+extras.getString("Centrosalud"));
        descripcion.setText(""+extras.getString("Descripcion"));




    }
}