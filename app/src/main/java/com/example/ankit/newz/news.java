package com.example.ankit.newz;

public class news {

    public String title;
    public String description;
    public String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public news(String title, String description, String image) {

        this.title = title;
        this.description = description;
        this.image = image;
    }

    public news() {

    }
}
