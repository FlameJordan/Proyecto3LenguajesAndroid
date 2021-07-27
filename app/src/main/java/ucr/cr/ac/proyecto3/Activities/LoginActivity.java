package ucr.cr.ac.proyecto3.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ucr.cr.ac.proyecto3.Api.ApiPacientes;
import ucr.cr.ac.proyecto3.MainActivity;
import ucr.cr.ac.proyecto3.R;
import ucr.cr.ac.proyecto3.Request.LoginRequest;
import ucr.cr.ac.proyecto3.model.LoginResponse;


public class LoginActivity extends AppCompatActivity {
    private EditText ti_cedula;
    private EditText ti_password;
    private Button btn_login;
    private Button btn_registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         ti_cedula = findViewById(R.id.usercedula);
         ti_password = findViewById(R.id.password);
         btn_login = findViewById(R.id.login);
         btn_registro = findViewById(R.id.btn_registro);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(TextUtils.isEmpty(ti_cedula.getText().toString()) || TextUtils.isEmpty(ti_password.getText().toString())){

                Toast.makeText(LoginActivity.this,"Cedula/Contraseña requeridas",Toast.LENGTH_SHORT).show();

                }else{
                     login();
            }
        }
    });


        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registro();
            }
        });
  }


  public void login(){


        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setCedula(ti_cedula.getText().toString());
        loginRequest.setContrasenna(ti_password.getText().toString());

      Call<LoginResponse> loginResponseCall = ApiPacientes.getUserService().userLogin(loginRequest);

      loginResponseCall.enqueue(new Callback<LoginResponse>() {
          @Override
          public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

              if(response.isSuccessful()){

                  if(response.body().getVerificar().equalsIgnoreCase("Valido")){
                      Toast.makeText(LoginActivity.this,"Bienvenido",Toast.LENGTH_SHORT).show();
                      mainActivity();
                  }

              }else{

                  Toast.makeText(LoginActivity.this,"Fallo",Toast.LENGTH_LONG).show();

              }

          }

          @Override
          public void onFailure(Call<LoginResponse> call, Throwable t) {

              Toast.makeText(LoginActivity.this,"Error: "+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

          }
      });
  }


  public void registro(){
      Intent i = new Intent(this, SignUpActivity.class);
      startActivity(i);
  }

    public void mainActivity(){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("Cedula",ti_cedula.getText().toString());

        startActivity(i);
    }

}





