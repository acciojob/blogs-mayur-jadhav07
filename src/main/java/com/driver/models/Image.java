package com.driver.models;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;
    private String description;
    private String dimensions;

    @ManyToOne
    @JoinColumn
    private Blog blog;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Image(){

    }

    public Image(String description, String dimension) {
        this.description = description;
        this.dimensions = dimension;
    }

    public Image(int imageId, String description, String dimensions) {
        this.imageId = imageId;
        this.description = description;
        this.dimensions = dimensions;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}