package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }

        // Find the user by userId
        Optional<User> userOptional = userRepository1.findById(userId);

        // Check if userOptional contains a value
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Check if title or content is null
            if (title == null || content == null) {
                throw new IllegalArgumentException("Title and content cannot be null");
            }

            // Create a new blog and set the user
            Blog blog = new Blog(title, content);
            blog.setUser(user);

            // Save and return the created blog
            return blogRepository1.save(blog);
        } else {
            throw new IllegalArgumentException("User not found for ID: " + userId);
        }
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository1.deleteById(blogId);
    }
}
