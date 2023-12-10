package com.anshul.buzzme;

public class ModelStory {
    String story;

    public ModelStory(){

    }

    public ModelStory(String story, String sender, String timestamp) {
        this.story = story;
        this.sender = sender;
        this.timestamp = timestamp;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    String sender,timestamp;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
