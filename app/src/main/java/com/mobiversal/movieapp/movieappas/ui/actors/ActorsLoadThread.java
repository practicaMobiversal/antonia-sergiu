package com.mobiversal.movieapp.movieappas.ui.actors;
import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.Nullable;
import com.mobiversal.movieapp.movieappas.database.AppDatabase;
import com.mobiversal.movieapp.movieappas.model.Actor;
import java.util.List;

public abstract class ActorsLoadThread extends AsyncTask<Void, Void, List<Actor>> {
    private Context context;

    public ActorsLoadThread(Context context) {
        this.context = context;
    }

    @Override
    protected List<Actor> doInBackground(Void... voids) {
        return AppDatabase.getInstance(context).actorDao().getAllActors();
    }

    @Override
    protected void onPostExecute(List<Actor> actors) {
        super.onPostExecute(actors);
        onDone(actors);

    }

    protected abstract void onDone(@Nullable List<Actor> actors);
}