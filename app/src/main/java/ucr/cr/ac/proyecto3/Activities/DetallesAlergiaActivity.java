package ucr.cr.ac.proyecto3.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import ucr.cr.ac.proyecto3.R;

public class DetallesAlergiaActivity extends AppCompatActivity {
    Bundle extras;
    TextView cod_alergia;
    TextView cedula_paciente;
    TextView nombre_alergia;
    TextView descripcion_alergia;
    TextView fecha_diagnostico;
    TextView medicamentos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        extras = getIntent().getExtras();
        setContentView(R.layout.activity_detalles_alergia);
        cod_alergia = findViewById(R.id.alergia_codigo);
        cedula_paciente = findViewById(R.id.alergia_cedula);
        nombre_alergia = findViewById(R.id.alergia_nombre);
        descripcion_alergia = findViewById(R.id.alergia_descripcion);
        fecha_diagnostico = findViewById(R.id.alergia_fecha);
        medicamentos = findViewById(R.id.alergia_medicamentos);

        cod_alergia.setText(""+extras.getInt("Cod_alergia"));
        cedula_paciente.setText(""+extras.getString("Cedula_paciente"));
        nombre_alergia.setText(""+extras.getString("Nombre_alergia"));
        descripcion_alergia.setText(""+extras.getString("Descripcion_alergia"));
        fecha_diagnostico.setText(""+extras.getString("Fecha_diagnostico"));
        medicamentos.setText(""+extras.getString("Medicamentos"));
    }
}