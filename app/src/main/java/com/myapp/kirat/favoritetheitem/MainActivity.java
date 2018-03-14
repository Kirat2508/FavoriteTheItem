package com.myapp.kirat.favoritetheitem;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView QUERY_VIEW;
    List<Message> QUERY_ITEMS;
    AdapterMainList Q_ADAPTER;
    FavoriteDatabase favoriteDatabase;
    List<FavouriteModel> favouriteList;
    String title  ;
    String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        favoriteDatabase = new FavoriteDatabase(this);
        QUERY_VIEW = (RecyclerView) findViewById(R.id.recycler_query);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getApplicationContext());
        Log.d("debugMode", "The application stopped after this");
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        description = intent.getStringExtra("description");
//        Intent intent = getIntent().getExtras()


        QUERY_VIEW.setLayoutManager(mLayoutManager);
        QUERY_ITEMS = new ArrayList<>();
        QUERY_ITEMS.add(
                new Message(
                        "HELLO",
                        "BHK YGP* GG IUG &IG HUIG "
                )
        );

        QUERY_ITEMS.add(
                new Message(
                        "Fjnrg",
                        "seegmk.s'ge "
                )
        );

        QUERY_ITEMS.add(
                new Message(
                        "sgsgrg",
                        "seegmk.s'geosfejoiisogeijosegjiiowapopa "
                )
        );

        QUERY_ITEMS.add(
                new Message(
                        "khf2lgheiulg",
                        "kskddndnmlepeprkfmcmckclffrorit "
                )
        );

        QUERY_ITEMS.add(
                new Message(
                        "Fjnrg",
                        "segrko;ktb4-ob-=rgtbknl;rvjkw;nwfj"
                )
        );

        QUERY_ITEMS.add(
                new Message(
                        "djskslf",
                        "efbfvnvvndkslkforpffkfkvfcvnvvovovvovovovowkwkkqmswkdkflfk "
                )
        );

        Q_ADAPTER = new AdapterMainList(QUERY_ITEMS, getApplicationContext());
        QUERY_VIEW.setAdapter(Q_ADAPTER);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_fav) {

            Cursor cTemp = favoriteDatabase.getListContents(title,description);
            if (cTemp.moveToNext()) {
                showFavourites();
            }
        } else {
            Toast.makeText(this, "No Favourites!", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    private void showFavourites() {

        favouriteList.clear();
        Cursor data ;
        data = favoriteDatabase.getListContents(title,description);
        while (data.moveToNext()){
            favouriteList.add(new FavouriteModel(data.getString(1),data.getString(2)));
        }
       FavoriteAdapter cha = new FavoriteAdapter( favouriteList,this) ;
        cha.notifyDataSetChanged();
        QUERY_VIEW.setAdapter(cha);

    }

}






