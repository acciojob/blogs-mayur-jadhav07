package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        blogRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Optional<Image> imageOptional = imageRepository2.findById(id);
        if(imageOptional.isPresent()){
            Image image = imageOptional.get();
            String[] imageDimensionsArray = image.getDimension().split("x");
            int count = 0;
        }
        return 0;
    }
}
