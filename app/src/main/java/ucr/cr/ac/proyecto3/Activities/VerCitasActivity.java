package ucr.cr.ac.proyecto3.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ucr.cr.ac.proyecto3.Api.ApiPacientes;
import ucr.cr.ac.proyecto3.MainActivity;
import ucr.cr.ac.proyecto3.R;
import ucr.cr.ac.proyecto3.adapter.RecyclerCitasAdapter;
import ucr.cr.ac.proyecto3.model.Alergia;
import ucr.cr.ac.proyecto3.model.Cita;
import ucr.cr.ac.proyecto3.model.CitasResponse;

public class VerCitasActivity extends AppCompatActivity {
    Bundle extras;
    private RecyclerView recyclerView;
    private RecyclerCitasAdapter listcitasAdapter;
    private TextView titulo;
    private CitasResponse citas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_citas);

         extras = getIntent().getExtras();
        listcitasAdapter = new RecyclerCitasAdapter(this);
        obtenercitas();

    }


    public void configrecycler(){


        recyclerView = (RecyclerView) findViewById(R.id.recyclercitasid);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listcitasAdapter);

        listcitasAdapter.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cita cita = new Cita();
                cita = listcitasAdapter.getDataset().get(recyclerView.getChildAdapterPosition(v));
                verDetallesCitaActivity(cita);

            }
        });

    }

    public void obtenercitas(){

        Call<CitasResponse> citasResponseCall = ApiPacientes.getUserService().userCitas(extras.getString("Cedula"));


        citasResponseCall.enqueue(new Callback<CitasResponse>() {
            @Override
            public void onResponse(Call<CitasResponse> call, Response<CitasResponse> response) {

                if(response.isSuccessful()){


                    listcitasAdapter.addListCita(response.body().getListacitas());

                    if(response.body().getListacitas().get(0).getCod_cita()!=0){
                        configrecycler();
                    }else{
                        TextView titulo = findViewById(R.id.citas_aviso);
                        recyclerView = (RecyclerView) findViewById(R.id.recyclercitasid);
                        recyclerView.setVisibility(View.GONE);
                        titulo.setVisibility(View.VISIBLE);

                    }




                }else{
                    Log.d("OnResponse","error: "+ response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<CitasResponse> call, Throwable t) {
                Log.d("OnFailure","error: "+t.getMessage() );
            }

        });


    }

    public void verDetallesCitaActivity(Cita cita){
        Intent i = new Intent(this, DetallesCitaActivity.class);
        i.putExtra("Cod_cita",cita.getCod_cita());
        i.putExtra("Centro_salud",cita.getNombre_centro_salud());
        i.putExtra("Especialidad",cita.getNombre_especialidad());
        i.putExtra("Medico",cita.getMedico());
        i.putExtra("Fecha_hora",cita.getFecha_hora());
        i.putExtra("Descripcion",cita.getCita_descripcion());

        startActivity(i);

    }

}