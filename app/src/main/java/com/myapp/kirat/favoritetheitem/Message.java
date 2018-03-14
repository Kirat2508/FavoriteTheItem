package com.myapp.kirat.favoritetheitem;

/**
 * Created by Ravi Tamada on 21/02/17.
 * www.androidhive.info
 */

public class Message {
    private String TITLE_MESSAGE;
    private String DESCRIPTION;


    public String getTITLE_MESSAGE() {
        return TITLE_MESSAGE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }


    public Message(String TITLE_MESSAGE, String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
        this.TITLE_MESSAGE = TITLE_MESSAGE;


    }
}
