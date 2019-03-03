package Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import Model.ListItem;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private Context context;
    private List<ListItem> listItems;

    public MyAdapter(Context context, List listitem) {

    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    // Holds all the items in our listrow
    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
