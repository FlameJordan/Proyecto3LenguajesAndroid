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
import ucr.cr.ac.proyecto3.model.Alergia;
import ucr.cr.ac.proyecto3.model.Cita;


public class RecyclerAlergiasAdapter extends RecyclerView.Adapter<RecyclerAlergiasAdapter.ViewHolderAlergias>
implements View.OnClickListener {

    private ArrayList<Alergia> dataset;

    public ArrayList<Alergia> getDataset() {
        return dataset;
    }

    private Context context;
    private View.OnClickListener listener;


    public RecyclerAlergiasAdapter (Context context){
        this.context = context;
        dataset = new ArrayList<>();
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerAlergiasAdapter.ViewHolderAlergias onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        view.setOnClickListener(this);
        return new RecyclerAlergiasAdapter.ViewHolderAlergias(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerAlergiasAdapter.ViewHolderAlergias holder, int position) {
        Alergia a = dataset.get(position);
        holder.nombre_alergia.setText(a.getNombre_alergia());
        holder.fecha_diagnostico.setText(a.getFecha_diagnostico());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addListCita(ArrayList<Alergia> listalergia) {
        dataset.addAll(listalergia);
        notifyDataSetChanged();
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


    public class ViewHolderAlergias extends RecyclerView.ViewHolder {
        TextView nombre_alergia;
        TextView fecha_diagnostico;

        public ViewHolderAlergias(@NonNull @NotNull View itemView) {
            super(itemView);

            nombre_alergia = (TextView) itemView.findViewById(R.id.centrosalud);
            fecha_diagnostico = (TextView) itemView.findViewById(R.id.fechacita);

        }
    }
}
