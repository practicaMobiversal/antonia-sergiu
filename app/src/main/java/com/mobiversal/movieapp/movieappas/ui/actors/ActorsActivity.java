package com.mobiversal.movieapp.movieappas.ui.actors;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import com.mobiversal.movieapp.movieappas.Network.RequestManager;
import com.mobiversal.movieapp.movieappas.Network.response.ActorsResponse;
import com.mobiversal.movieapp.movieappas.R;
import com.mobiversal.movieapp.movieappas.database.AppDatabase;
import com.mobiversal.movieapp.movieappas.model.Actor;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;





public class ActorsActivity extends AppCompatActivity {
    private RecyclerView rrecyclerview;
    private static final String TAG = ActorsActivity.class.getSimpleName();
    private ActorsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);
        rrecyclerview = findViewById(R.id.rv_actors);
        setUpRecyclerView();
        getActorsFromDataBase();

    }

    private void setUpRecyclerView() {
        LinearLayoutManager lln = new LinearLayoutManager(this);
        lln.setOrientation(RecyclerView.VERTICAL);
        adapter = new ActorsAdapter(new ArrayList<>());
        rrecyclerview.setAdapter(adapter);
        rrecyclerview.setLayoutManager(lln);
    }


    private void getActorsFromDataBase() {
        Call<ActorsResponse> request = RequestManager.getInstance().getPopularPeople();
        request.enqueue(new Callback<ActorsResponse>() {
            @Override
            public void onResponse(Call<ActorsResponse> call, Response<ActorsResponse> response) {
                AppDatabase.getInstance(ActorsActivity.this)
                        .actorDao();

                List<Actor> actors = response.body().getResults();
                adapter.setActors(actors);
                adapter.notifyDataSetChanged();

                for (Actor actor : actors) {
                    Log.d(TAG,actor.getName());
//                    AppDatabase.getInstance(ActorsActivity.this)
//                            .actorDao()
//                            .saveActor(actor);
                }
                getActorsOnClick();

            }

            @Override
            public void onFailure(Call<ActorsResponse> call, Throwable t) {
                Log.d(TAG, "Get actors failure:" + t.getMessage());
            }
        });
            }



    public void getActorsOnClick() {
        findViewById(R.id.save_actors).setOnClickListener(view -> {

            AppDatabase.getInstance(ActorsActivity.this).actorDao().deleteAll();
            for (Actor actor: adapter.getSelectedActors() ) {
                AppDatabase.getInstance(ActorsActivity.this).actorDao().saveActor(actor);
                Log.d(TAG, actor.getName());
            }
            onBackPressed();
        });
    }
}