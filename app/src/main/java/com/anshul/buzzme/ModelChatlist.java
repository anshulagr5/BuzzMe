package com.anshul.buzzme;


public class ModelChatlist {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public ModelChatlist() {
    }

    public ModelChatlist(String id,String timestamp) {
        this.id = id;
        this.timestamp=timestamp;
    }

    String id,timestamp;
}


