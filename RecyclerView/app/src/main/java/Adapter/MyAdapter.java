package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kevinbui.recyclerview.DetailsActivity;
import com.example.kevinbui.recyclerview.R;

import org.w3c.dom.Text;

import java.util.List;

import Model.ListItem;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private Context context;
    private List<ListItem> listItems;

    public MyAdapter(Context context, List listitem) {
        this.context = context;
        this.listItems = listitem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // View that holds our list
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, int i) {

        ListItem item = listItems.get(i);
        viewHolder.name.setText(item.getName());
        viewHolder.description.setText(item.getDescription());
        viewHolder.rating.setText(item.getRating());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    // Holds all the items in our listrow
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name;
        public TextView description;
        public TextView rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            name = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            rating = (TextView) itemView.findViewById(R.id.rating);
        }

        @Override
        public void onClick(View v) {
            // Get position of the row clicked or tapped
            int position = getAdapterPosition();

            ListItem item = listItems.get(position);
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("name", item.getName());
            intent.putExtra("description", item.getDescription());
            intent.putExtra("rating", item.getRating());

            context.startActivity(intent);


            Toast.makeText(context, item.getName(), Toast.LENGTH_LONG).show();
        }
    }
}
