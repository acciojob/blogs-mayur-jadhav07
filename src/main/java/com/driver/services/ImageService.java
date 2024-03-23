package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Optional<Blog> blogOptional = blogRepository2.findById(blogId);
        if(blogOptional.isPresent()){
            Blog blog = blogOptional.get();
            Image image = new Image(description, dimensions);
            image.setBlog(blog);
            return imageRepository2.save(image);
        }
        return null;
    }

    public void deleteImage(Integer id){
        Optional<Image> imageOptional = imageRepository2.findById(id);
        if (imageOptional.isPresent()) {
            imageRepository2.deleteById(id);
        } else {
            throw new IllegalArgumentException("Image with id " + id + " not found");
        }
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        // Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        try {
            Optional<Image> imageOptional = imageRepository2.findById(id);
            if (imageOptional.isPresent()) {
                Image image = imageOptional.get();
                String[] imageDimensionsArray = image.getDimensions().split("X");
                if (imageDimensionsArray.length != 2) {
                    throw new IllegalArgumentException("Invalid image dimensions format");
                }
                int imageWidth = Integer.parseInt(imageDimensionsArray[0]);
                int imageHeight = Integer.parseInt(imageDimensionsArray[1]);
                String[] screenDimensionsArray = screenDimensions.split("X");
                if (screenDimensionsArray.length != 2) {
                    throw new IllegalArgumentException("Invalid screen dimensions format");
                }
                int screenWidth = Integer.parseInt(screenDimensionsArray[0]);
                int screenHeight = Integer.parseInt(screenDimensionsArray[1]);
                int count = (screenWidth / imageWidth) * (screenHeight / imageHeight);
                return count;
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error processing image or screen dimensions: " + e.getMessage());
        }
        return 0;
    }
}
