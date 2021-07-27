package ucr.cr.ac.proyecto3.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ucr.cr.ac.proyecto3.Api.ApiPacientes;
import ucr.cr.ac.proyecto3.R;
import ucr.cr.ac.proyecto3.Request.CantonRequest;
import ucr.cr.ac.proyecto3.Request.DistritoRequest;
import ucr.cr.ac.proyecto3.Request.PacienteRequest;
import ucr.cr.ac.proyecto3.model.CantonResponse;
import ucr.cr.ac.proyecto3.model.DistritoResponse;
import ucr.cr.ac.proyecto3.model.PacienteResponse;

public class SignUpActivity extends AppCompatActivity {
    Spinner sp_provincia;
    Spinner sp_cantones;
    Spinner sp_distrito;
    Spinner sp_tipo_sangre;
    Spinner sp_estado_civil;
    EditText etxt_nombre;
    EditText etxt_apellido;
    EditText etxt_cedula;
    EditText etxt_contrasenna;
    EditText etxt_edad;
    EditText etxt_senna;
    EditText etxt_telefono1;
    EditText etxt_telefono2;
    EditText etxt_telefono3;
    Button btn_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        sp_provincia = findViewById(R.id.provincia_sp);
        sp_cantones= findViewById(R.id.canton_sp);
        sp_distrito = findViewById(R.id.distrito_sp);
        sp_tipo_sangre = findViewById(R.id.tipo_sangre_sp);
        sp_estado_civil = findViewById(R.id.estado_civil_sp);
        etxt_nombre = findViewById(R.id.nombrepciente);
        etxt_apellido = findViewById(R.id.apellido);
        etxt_cedula = findViewById(R.id.cedula);
        etxt_contrasenna = findViewById(R.id.contrasenna);
        etxt_edad = findViewById(R.id.edad_paciente);
        etxt_senna = findViewById(R.id.senna);
        etxt_telefono1 = findViewById(R.id.telefono1);
        etxt_telefono2 = findViewById(R.id.telefono2);
        etxt_telefono3 = findViewById(R.id.telefono3);
        btn_registrar = findViewById(R.id.btn_registrar);




        sp_provincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                cambioCanton(sp_provincia.getSelectedItem().toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp_cantones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(!sp_cantones.getSelectedItem().toString().isEmpty()) {
                    cambioDistrito(sp_cantones.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }



    public void cambioCanton(String provincia){

        CantonRequest cantonRequest = new CantonRequest();
        cantonRequest.setProvincia(provincia);
        Call<CantonResponse> cantonResponseCall = ApiPacientes.getUserService().userCanton(cantonRequest);


        cantonResponseCall.enqueue(new Callback<CantonResponse>() {
            @Override
            public void onResponse(Call<CantonResponse> call, Response<CantonResponse> response) {

                if(response.isSuccessful()){

                CantonResponse cantonResponse = new CantonResponse();
                cantonResponse.setCantones(response.body().getCantones());
                if(!cantonResponse.getCantones().isEmpty()){
                    sp_cantones.setAdapter(null);
                    ArrayList<String> listanombrecanton = new ArrayList<String>();

                    for(int i=0;i<cantonResponse.getCantones().size();i++){
                        listanombrecanton.add(cantonResponse.getCantones().get(i).getNombre_canton());
                    }

                    ArrayAdapter adapter = new ArrayAdapter(SignUpActivity.this, android.R.layout.simple_spinner_item,listanombrecanton);
                    sp_cantones.setAdapter(adapter);
                 }else{
                    sp_cantones.setAdapter(null);
                  }

                }else{
                    Log.d("OnResponse","error: "+ response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<CantonResponse> call, Throwable t) {
                Log.d("OnFailure","error: "+t.getMessage() );
            }
        });



        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(etxt_cedula.getText().toString()) || TextUtils.isEmpty(sp_distrito.getSelectedItem().toString()) || TextUtils.isEmpty(sp_cantones.getSelectedItem().toString()) ||TextUtils.isEmpty(etxt_telefono1.getText().toString()) || TextUtils.isEmpty(etxt_contrasenna.getText().toString())){

                    Toast.makeText(SignUpActivity.this,"Cedula/Contraseña/Nombre/Apellido/Telefono 1/Direccion requeridos",Toast.LENGTH_LONG).show();

                }else{
                    insertarPaciente();
                }
            }
        });

    }

    public void cambioDistrito(String canton){
        DistritoRequest distritoRequest = new DistritoRequest();
        distritoRequest.setCanton(canton);
        Call<DistritoResponse> distritoResponseCall = ApiPacientes.getUserService().userDistrito(distritoRequest);

        distritoResponseCall.enqueue(new Callback<DistritoResponse>() {
            @Override
            public void onResponse(Call<DistritoResponse> call, Response<DistritoResponse> response) {

                if(response.isSuccessful()){

                    DistritoResponse distritoResponse = new DistritoResponse();

                    distritoResponse.setDistritos(response.body().getDistritos());

                    if(!distritoResponse.getDistritos().isEmpty()){
                        sp_distrito.setAdapter(null);
                        ArrayList<String> listanombrdistrito = new ArrayList<String>();

                        for(int i=0;i<distritoResponse.getDistritos().size();i++){
                            listanombrdistrito.add(distritoResponse.getDistritos().get(i).getNombre_distrito());
                        }

                        ArrayAdapter adapter = new ArrayAdapter(SignUpActivity.this, android.R.layout.simple_spinner_item,listanombrdistrito);
                        sp_distrito.setAdapter(adapter);
                    }else{
                        sp_distrito.setAdapter(null);
                    }

                }else{
                    Log.d("OnResponse","error: "+ response.errorBody());
                }



            }

            @Override
            public void onFailure(Call<DistritoResponse> call, Throwable t) {
                Log.d("OnFailure","error: "+t.getMessage() );
            }
        });


    }


    public void insertarPaciente(){
        PacienteRequest pacienteRequest = new PacienteRequest();
        pacienteRequest.setCedula_paciente(etxt_cedula.getText().toString());
        pacienteRequest.setApellido_paciente(etxt_apellido.getText().toString());
        pacienteRequest.setContrasenna(etxt_contrasenna.getText().toString());
        pacienteRequest.setNombre_paciente(etxt_nombre.getText().toString());
        pacienteRequest.setEdad_paciente(Integer.parseInt(etxt_edad.getText().toString()));
        pacienteRequest.setSeña(etxt_senna.getText().toString());
        String[] telefonos = new String[3];
        telefonos[0] =etxt_telefono1.getText().toString();
        telefonos[1] =etxt_telefono2.getText().toString();
        telefonos[2] =etxt_telefono3.getText().toString();
        pacienteRequest.setTelefonos(telefonos);
        pacienteRequest.setTipo_sangre(sp_tipo_sangre.getSelectedItem().toString());
        pacienteRequest.setEstado_civil(sp_estado_civil.getSelectedItem().toString());
        pacienteRequest.setProvincia(sp_provincia.getSelectedItem().toString());
        pacienteRequest.setCanton(sp_cantones.getSelectedItem().toString());
        pacienteRequest.setDistrito(sp_distrito.getSelectedItem().toString());

        Call<PacienteResponse> pacienteResponseCall = ApiPacientes.getUserService().userPaciente(pacienteRequest);
        pacienteResponseCall.enqueue(new Callback<PacienteResponse>() {
            @Override
            public void onResponse(Call<PacienteResponse> call, Response<PacienteResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(SignUpActivity.this,response.body().getRespuesta(),Toast.LENGTH_LONG).show();

                    if(response.body().getRespuesta().equalsIgnoreCase("Registrado")){
                        irLogin();
                    }
                }else{
                    Log.d("OnResponse","error:  "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PacienteResponse> call, Throwable t) {
                Log.d("OnFailure","error:  "+t.getMessage());
            }
        });

    }

public void irLogin(){
    Intent i = new Intent(this, LoginActivity.class);
    startActivity(i);
}

}