package ucr.cr.ac.proyecto3.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import ucr.cr.ac.proyecto3.R;
import ucr.cr.ac.proyecto3.model.Cita;

public class RecyclerCitasAdapter extends RecyclerView.Adapter<RecyclerCitasAdapter.ViewHolderCitas>
implements View.OnClickListener {


    private ArrayList<Cita> dataset;
    private Context context;
    private View.OnClickListener listener;



    public RecyclerCitasAdapter (Context context){
        this.context = context;
        this.dataset = new ArrayList<>();
    }


    @Override
    public ViewHolderCitas onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        view.setOnClickListener(this);
        return new ViewHolderCitas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolderCitas holder, int position) {
        Cita c = this.dataset.get(position);
        Log.d("Lista de Citas","Citas: "+c.getCod_cita() );
        holder.centro_salud.setText(c.getNombre_centro_salud());
        holder.fecha_hora.setText(c.getFecha_hora());


    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }


    public void addListCita(ArrayList<Cita> listCita) {
        this.dataset.addAll(listCita);
        notifyDataSetChanged();
    }

    public ArrayList<Cita> getDataset() {
        return this.dataset;
    }

    @Override
    public void onClick(View v) {
    if(listener!=null){
    listener.onClick(v);
    }
    }


    public void setOnclickListener(View.OnClickListener listener){
        this.listener =listener;
    }

    public class ViewHolderCitas extends RecyclerView.ViewHolder {

        TextView centro_salud;
        TextView fecha_hora;

        public ViewHolderCitas(@NonNull @NotNull View itemView) {
            super(itemView);
            centro_salud = (TextView) itemView.findViewById(R.id.centrosalud);
            fecha_hora = (TextView) itemView.findViewById(R.id.fechacita);
        }
    }
}
