package com.mobiversal.movieapp.movieappas.ui.actors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.mobiversal.movieapp.movieappas.R;
import com.mobiversal.movieapp.movieappas.model.Actor;
import com.mobiversal.movieapp.movieappas.utils.ImageLoader;
import java.util.List;
import static com.mobiversal.movieapp.movieappas.utils.Constants.BASE_IMAGE_URL;
import static com.mobiversal.movieapp.movieappas.utils.Constants.IMAGE_SIZE;

public class ActorsAdapter extends RecyclerView.Adapter<ActorsAdapter.ActorsViewHolder> {
    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    List<Actor> actors;

    public ActorsAdapter(List<Actor> actors) {
        this.actors = actors;
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
            ImageLoader.loadUrl(actorimage,BASE_IMAGE_URL+IMAGE_SIZE+actor.getImageUrl(), actorimage.getContext());
            actortext.setText(actor.getName());


        }
    }


}
