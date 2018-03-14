package com.myapp.kirat.favoritetheitem;

/**
 * Created by Dell on 3/13/2018.
 */

public class FavouriteModel {


    private String title ;
    private String description ;
//    private String address;
//    private String address_tags;
//    private String serial_no ;

    public FavouriteModel(String title, String description){

        this.title = title ;
        this.description = description ;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}
