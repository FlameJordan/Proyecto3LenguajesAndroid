package ucr.cr.ac.proyecto3.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import ucr.cr.ac.proyecto3.R;

public class DetallesCitaActivity extends AppCompatActivity {
    Bundle extras;
    TextView cod_cita;
    TextView centro_salud;
    TextView especialidad;
    TextView medico;
    TextView fecha_hora;
    TextView descripcion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_cita);

        extras = getIntent().getExtras();
        cod_cita = findViewById(R.id.codigocitadetalles);
        centro_salud = findViewById(R.id.cita_centrosalud);
        especialidad = findViewById(R.id.cita_especialidad);
        medico = findViewById(R.id.cita_medico);
        fecha_hora = findViewById(R.id.citafecha_hora);
        descripcion = findViewById(R.id.cita_descripcion);

        cod_cita.setText(""+extras.getInt("Cod_cita"));
        centro_salud.setText(""+extras.getString("Centro_salud"));
        especialidad.setText(""+extras.getString("Especialidad"));
        medico.setText(""+extras.getString("Medico"));
        fecha_hora.setText(""+extras.getString("Fecha_hora"));
        descripcion.setText(""+extras.getString("Descripcion"));


    }
}