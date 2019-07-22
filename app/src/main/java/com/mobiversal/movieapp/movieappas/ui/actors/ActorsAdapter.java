package com.mobiversal.movieapp.movieappas.ui.actors;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.mobiversal.movieapp.movieappas.R;
import com.mobiversal.movieapp.movieappas.model.Actor;
import com.mobiversal.movieapp.movieappas.utils.ImageLoader;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import static com.mobiversal.movieapp.movieappas.utils.Constants.BASE_IMAGE_URL;
import static com.mobiversal.movieapp.movieappas.utils.Constants.IMAGE_SIZE;

public class ActorsAdapter extends RecyclerView.Adapter<ActorsAdapter.ActorsViewHolder> {


    List<Actor> actors;
    public List<Integer> actorId;

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public ActorsAdapter(List<Actor> actors) {

        this.actors = actors;
        actorId = new ArrayList<>();
    }

    public List<Integer> getActorId() {
        return actorId;
    }

    @NonNull
    @Override
    public ActorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.view_actor_item, parent, false);
        return new ActorsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorsViewHolder holder, int position) {
        holder.onBind(actors.get(position));
    }

    @Override
    public int getItemCount() {
        return actors.size();
    }

    class ActorsViewHolder extends RecyclerView.ViewHolder {


        ImageView actorimage;
        TextView actortext;
        CheckBox actorcheckbox;


        public ActorsViewHolder(@NonNull View itemView) {
            super(itemView);
            actorimage = itemView.findViewById(R.id.im_actor);
            actortext = itemView.findViewById(R.id.tv_actorText);
            actorcheckbox = itemView.findViewById(R.id.check_actor);


        }

        public void onBind(Actor actor) {
            ImageLoader.loadUrl(actorimage, BASE_IMAGE_URL + IMAGE_SIZE + actor.getImageUrl(), actorimage.getContext());
            actortext.setText(actor.getName());
            setCheckboxOnClick(actor);
        }


        private void setCheckboxOnClick(Actor actor) {

            actorcheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {

                if (isChecked) {
                    actorId.add(actor.getId());
                    Log.d("Actor ID is", actor.getName() + isChecked);
                } else {

                    actorId.remove(new Integer(actor.getId()));
                    Log.d("Actor is  removed", actor.getName());
                }
            });
        }
    }
}

