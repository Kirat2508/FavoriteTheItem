package com.myapp.kirat.favoritetheitem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

public class AdapterMainList extends RecyclerView.Adapter<AdapterMainList.ViewHolder> {
       private List<Message> messageList;
    private Context context;
    FavoriteDatabase favoriteDatabase  ;
    Boolean isFavoruite =true;


    public AdapterMainList(List<Message> messageList, Context context) {
        this.messageList = messageList;
        this.context = context;
    }

    @Override
    public AdapterMainList.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

//        MyAsyncTasks asyncTask = new MyAsyncTasks();
//        asyncTask.execute(Url);

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_list_row, parent, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final AdapterMainList.ViewHolder holder, final int position) {


        final Message message = messageList.get(position);

        holder.TITLE_QUERY.setText(message.getTITLE_MESSAGE());
        holder.DESCRIPTION.setText(message.getDESCRIPTION());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,message.getTITLE_MESSAGE(), Toast.LENGTH_SHORT).show();

//                Intent intent = new Intent(v.getContext(),BookingDetails.class);
//                intent.putExtra("customer name",holder.TITLE_QUERY.getText().toString());
//                intent.putExtra("Total Prize",holder.TITLE_QUERY.getText().toString());
//                v.getContext().startActivity(intent);

            }
        });
        holder.button.setOnClickListener(new View.OnClickListener() {
            String title = holder.TITLE_QUERY.getText().toString();
            String des = holder.DESCRIPTION.getText().toString();
            @Override
            public void onClick(View v) {
                favoriteDatabase = new FavoriteDatabase(v.getContext());

                Boolean b = favoriteDatabase.addData(title,des);
                if(!isFavoruite) {
                    if (b) {

                        Toast.makeText(context, "Added to favourites", Toast.LENGTH_SHORT).show();
                        isFavoruite = true;
                    }
                    else{
                        Toast.makeText(context, "Please try again later!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



//                try {
//
//                    arr = object.getJSONArray("articles");
//                    JSONObject obj1 = arr.getJSONObject(position);
//                    Toast.makeText(context, obj1.toString(), Toast.LENGTH_SHORT).show();
//                    url1 = obj1.getString("url");
////                  Toast.makeText(MainActivity.this, url1, Toast.LENGTH_SHORT).show();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//
//                Intent i = new Intent(context, WebHost.class);
//                i.putExtra("jsonObject", url1);
//                context.startActivity(i);
    }
    private int getRandomMaterialColor(String typeColor) {
        int returnColor = Color.GRAY;
        int arrayId = context. getResources().getIdentifier("mdcolor_" + typeColor, "array", context.getPackageName());

        if (arrayId != 0) {
            TypedArray colors = context.getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.GRAY);
            colors.recycle();
        }
        return returnColor;
    }


    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView TITLE_QUERY;
        public TextView DESCRIPTION;
        public Button button;





        public ViewHolder(View itemView) {
            super(itemView);
            TITLE_QUERY = (TextView) itemView.findViewById(R.id.title);
            DESCRIPTION = (TextView) itemView.findViewById(R.id.description);
            //   MARK = (TextView) itemView.findViewById(R.id.mark);
            button = (Button)itemView.findViewById(R.id.fav);

            //  favoriteButton.setFavorite(false,false);




        }
    }

}

