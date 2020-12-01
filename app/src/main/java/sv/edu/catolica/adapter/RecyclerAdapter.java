package sv.edu.catolica.adapter;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import sv.edu.catolica.R;
import sv.edu.catolica.model.Itemlis;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.ReyclerHolder>{
    private RecyclerItemClick itemClick;
    private List<Itemlis> items;
    private List<Itemlis> originalItems;

    public RecyclerAdapter(List<Itemlis> items, RecyclerItemClick itemClick) {
        this.items = items;
        this.itemClick = itemClick;
        this.originalItems = new ArrayList<>();
        originalItems.addAll(items);
    }

    @NonNull
    @Override
    public ReyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_view, parent,false);

        return new ReyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReyclerHolder holder, final int position) {
        Itemlis item = items.get(position);
        holder.imgItem.setImageResource(item.getImgResource());
        holder.tvTitulo.setText(item.getTitulo());
        holder.tvtNoticia.setText(item.getNoticias());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.itemClick(item);

            }
        });

    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public void filter(final String strSearch) {
        if (strSearch.length() == 0) {
            items.clear();
            items.addAll(originalItems);
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                items.clear();
                List<Itemlis> collect = originalItems.stream()
                        .filter(i -> i.getTitulo().toLowerCase().contains(strSearch))
                        .collect(Collectors.toList());

                items.addAll(collect);
            }
            else {
                items.clear();
                for (Itemlis i : originalItems) {
                    if (i.getTitulo().toLowerCase().contains(strSearch)) {
                        items.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }



    public static class ReyclerHolder extends RecyclerView.ViewHolder{
        private ImageView imgItem;
        private TextView tvTitulo;
        private TextView tvtNoticia;
        public ReyclerHolder(@NonNull View itemView){
            super(itemView);
            imgItem=itemView.findViewById(R.id.imgItem);
            tvTitulo=itemView.findViewById(R.id.tvTitulo);
            tvtNoticia=itemView.findViewById(R.id.tvNoticia);

        }
    }
    public interface RecyclerItemClick {
        void itemClick(Itemlis item);
    }
}
