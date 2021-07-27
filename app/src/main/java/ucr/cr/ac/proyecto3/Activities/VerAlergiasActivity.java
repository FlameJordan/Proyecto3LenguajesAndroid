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
import ucr.cr.ac.proyecto3.adapter.RecyclerAlergiasAdapter;
import ucr.cr.ac.proyecto3.adapter.RecyclerCitasAdapter;
import ucr.cr.ac.proyecto3.model.Alergia;
import ucr.cr.ac.proyecto3.model.AlergiaResponse;
import ucr.cr.ac.proyecto3.model.Cita;
import ucr.cr.ac.proyecto3.model.CitasResponse;

public class VerAlergiasActivity extends AppCompatActivity {
    Bundle extras;
    private RecyclerView recyclerView;
    private RecyclerAlergiasAdapter listalergiasAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_alergias);


        extras = getIntent().getExtras();


        listalergiasAdapter = new RecyclerAlergiasAdapter(this);
        obteneralergias();


    }


public void configrecycler(){
    recyclerView = (RecyclerView) findViewById(R.id.recycleralergiasid);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(listalergiasAdapter);
    listalergiasAdapter.setOnclickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Alergia alergia = new Alergia();
            alergia = listalergiasAdapter.getDataset().get(recyclerView.getChildAdapterPosition(v));
            verDetallesAlergiaActivity(alergia);

        }
    });
}



    public void obteneralergias(){

        Call<AlergiaResponse> alergiaResponseCall = ApiPacientes.getUserService().userAlergias(extras.getString("Cedula"));
        alergiaResponseCall.enqueue(new Callback<AlergiaResponse>() {
            @Override
            public void onResponse(Call<AlergiaResponse> call, Response<AlergiaResponse> response) {
                if(response.isSuccessful()){

                    listalergiasAdapter.addListCita(response.body().getListaalergias());
                    if(!response.body().getListaalergias().isEmpty()){
                        configrecycler();
                    }else{
                        TextView titulo = findViewById(R.id.alergia_aviso);
                        recyclerView = (RecyclerView) findViewById(R.id.recycleralergiasid);
                        recyclerView.setVisibility(View.GONE);
                        titulo.setVisibility(View.VISIBLE);
                    }

                }else{
                    Log.d("OnResponse","error: "+ response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<AlergiaResponse> call, Throwable t) {
                Log.d("OnFailure","error: "+t.getMessage() );
            }
        });

    }


    public void verDetallesAlergiaActivity(Alergia alergia){
        Intent i = new Intent(this, DetallesAlergiaActivity.class);
        i.putExtra("Cod_alergia",alergia.getCod_alergia());
        i.putExtra("Cedula_paciente",alergia.getCedula_paciente());
        i.putExtra("Nombre_alergia",alergia.getNombre_alergia());
        i.putExtra("Descripcion_alergia",alergia.getDescripcion_alergia());
        i.putExtra("Fecha_diagnostico",alergia.getFecha_diagnostico());
        i.putExtra("Medicamentos",alergia.getMedicamentos());
        startActivity(i);

    }






}