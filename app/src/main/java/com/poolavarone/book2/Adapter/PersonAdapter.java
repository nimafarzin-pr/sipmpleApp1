package com.poolavarone.book2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.poolavarone.book2.ContentActivity;
import com.poolavarone.book2.Model.Person;
import com.poolavarone.book2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    private List<com.poolavarone.book2.Model.Person> personlist;

    public PersonAdapter(Context context, List<Person> personlist) {
        this.context = context;
        this.personlist = personlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder myviewholde = (ItemViewHolder) holder;
        myviewholde.item.setAnimation(AnimationUtils.loadAnimation(context,R.anim.item_anim));
        myviewholde.name.setText(personlist.get(position).getName());
        myviewholde.field.setText(personlist.get(position).getField());/////////////


        myviewholde.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent  intent= new Intent( context, ContentActivity.class);
                intent.putExtra("ID",personlist.get(position).getId());
                intent.putExtra("NAME",personlist.get(position).getName());
                intent.putExtra("FIELD",personlist.get(position).getField());
                intent.putExtra("DISC",personlist.get(position).getDisc());
                context.startActivity(intent);
            }
        });

        }



    @Override
    public int getItemCount() {
        return personlist.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView name, field;
        RelativeLayout item;



        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name_id);
            field = (TextView) itemView.findViewById(R.id.field_id);
            item= (RelativeLayout) itemView.findViewById(R.id.item_idd);
        }
    }
    public void filterlist(List<Person> filterlist){
        personlist = filterlist;
        notifyDataSetChanged();
    }
}
