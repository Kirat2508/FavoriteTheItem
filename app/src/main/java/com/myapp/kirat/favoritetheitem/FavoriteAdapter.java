package com.myapp.kirat.favoritetheitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Dell on 3/13/2018.
 */

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private List<FavouriteModel> messageList;
    private Context context;

    public FavoriteAdapter(List<FavouriteModel> messageList, Context context) {
        this.messageList = messageList;
        this.context = context;
    }

    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_list_row, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final FavoriteAdapter.ViewHolder holder, final int position) {


        final FavouriteModel message = messageList.get(position);

        holder.TITLE_QUERY.setText(message.getTitle());
        holder.DESCRIPTION.setText(message.getDescription());


    }

        @Override
        public int getItemCount () {
            return messageList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView TITLE_QUERY;
            public TextView DESCRIPTION;


            public ViewHolder(View itemView) {
                super(itemView);
                TITLE_QUERY = (TextView) itemView.findViewById(R.id.title);
                DESCRIPTION = (TextView) itemView.findViewById(R.id.description);
                //   MARK = (TextView) itemView.findViewById(R.id.mark);

                //  favoriteButton.setFavorite(false,false);


            }
        }

    }

