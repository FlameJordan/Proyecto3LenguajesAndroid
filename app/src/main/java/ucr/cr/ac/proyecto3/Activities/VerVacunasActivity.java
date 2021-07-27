package ucr.cr.ac.proyecto3.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ucr.cr.ac.proyecto3.Api.ApiPacientes;
import ucr.cr.ac.proyecto3.R;
import ucr.cr.ac.proyecto3.adapter.RecyclerCitasAdapter;
import ucr.cr.ac.proyecto3.adapter.RecyclerVacunasAdapter;
import ucr.cr.ac.proyecto3.model.Alergia;
import ucr.cr.ac.proyecto3.model.Cita;
import ucr.cr.ac.proyecto3.model.CitasResponse;
import ucr.cr.ac.proyecto3.model.Vacuna;
import ucr.cr.ac.proyecto3.model.VacunaResponse;

public class VerVacunasActivity extends AppCompatActivity {
    Bundle extras;
    private RecyclerView recyclerView;
    private RecyclerVacunasAdapter listvacunasAdapter;
    private TextView titulo;
    private VacunaResponse vacunas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_vacunas);

        extras = getIntent().getExtras();
        listvacunasAdapter = new RecyclerVacunasAdapter(this);
        obtenervacunas();
    }

    public void obtenervacunas(){

        Call<VacunaResponse> vacunasResponseCall = ApiPacientes.getUserService().userVacuna(extras.getString("Cedula"));


        vacunasResponseCall.enqueue(new Callback<VacunaResponse>() {
            @Override
            public void onResponse(Call<VacunaResponse> call, Response<VacunaResponse> response) {

                if(response.isSuccessful()){


                    listvacunasAdapter.addListVacuna(response.body().getListavacunas());

                    if(!response.body().getListavacunas().isEmpty()){
                        configrecycler();
                    }else{
                        TextView titulo = findViewById(R.id.vacunas_aviso);
                        recyclerView = (RecyclerView) findViewById(R.id.recyclervacunasid);
                        recyclerView.setVisibility(View.GONE);
                        titulo.setVisibility(View.VISIBLE);

                    }

                }else{
                    Log.d("OnResponse","error: "+ response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<VacunaResponse> call, Throwable t) {
                Log.d("OnFailure","error: "+t.getMessage() );
            }

        });


    }


    public void configrecycler(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclervacunasid);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listvacunasAdapter);
        listvacunasAdapter.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vacuna vacuna = new Vacuna();
                vacuna = listvacunasAdapter.getDataset().get(recyclerView.getChildAdapterPosition(v));
                verDetallesVacunasActivity(vacuna);

            }
        });
    }

    public void verDetallesVacunasActivity(Vacuna vacuna){
        Intent i = new Intent(this, DetallesVacunaActivity.class);
        i.putExtra("Cedula",vacuna.getCedula_paciente());
        i.putExtra("Vacuna",vacuna.getNombre_vacuna());
        i.putExtra("Fecha1",vacuna.getFecha_aplicacion());
        i.putExtra("Fecha2",vacuna.getFecha_proxima_dosis());
        i.putExtra("Centrosalud",vacuna.getNombre_centro_salud());
        i.putExtra("Descripcion",vacuna.getDescripcion_vacuna_paciente());

        startActivity(i);

    }
}