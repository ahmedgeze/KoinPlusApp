package com.example.ahmetserdargeze.koinplusapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmetserdargeze on 28.03.2018.
 */

public class Result {
    @SerializedName("messages")
    @Expose
    public Boolean messages;
    @SerializedName("result")
    @Expose
    public ArrayList<Rv_object_coin> result = null;

    public Result() {
    }



    public Boolean getMessages() {
        return messages;
    }

    public void setMessages(Boolean messages) {
        this.messages = messages;
    }

    public ArrayList<Rv_object_coin> getResult() {
        return result;
    }

    public void setResult(ArrayList<Rv_object_coin> result) {
        this.result = result;
    }

}