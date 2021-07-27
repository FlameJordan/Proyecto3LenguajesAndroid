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
import ucr.cr.ac.proyecto3.model.Vacuna;

public class RecyclerVacunasAdapter extends RecyclerView.Adapter<RecyclerVacunasAdapter.ViewHolderVacunas>
        implements View.OnClickListener{


    private ArrayList<Vacuna> dataset;
    private Context context;
    private View.OnClickListener listener;



    public RecyclerVacunasAdapter (Context context){
        this.context = context;
        this.dataset = new ArrayList<>();
    }


    @Override
    public int getItemCount() {
        return dataset.size();
    }


    public void addListVacuna(ArrayList<Vacuna> listVacuna) {
        this.dataset.addAll(listVacuna);
        notifyDataSetChanged();
    }

    public ArrayList<Vacuna> getDataset() {
        return this.dataset;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerVacunasAdapter.ViewHolderVacunas onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_vacunas,parent,false);
        view.setOnClickListener(this);
        return new RecyclerVacunasAdapter.ViewHolderVacunas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerVacunasAdapter.ViewHolderVacunas holder, int position) {
        Vacuna v = this.dataset.get(position);
        holder.fecha_aplicación.setText(v.getFecha_aplicacion());
        holder.nombre_vacuna.setText(v.getNombre_vacuna());
        holder.centro_salud.setText(v.getNombre_centro_salud());
    }

    public void setOnclickListener(View.OnClickListener listener){
        this.listener =listener;
    }

    public class ViewHolderVacunas extends RecyclerView.ViewHolder {

        TextView fecha_aplicación;
        TextView nombre_vacuna;
        TextView centro_salud;

        public ViewHolderVacunas(@NonNull @NotNull View itemView) {
            super(itemView);
            fecha_aplicación = (TextView) itemView.findViewById(R.id.item1);
            nombre_vacuna = (TextView) itemView.findViewById(R.id.item2);
            centro_salud = (TextView) itemView.findViewById(R.id.item3);

        }


    }

}
