package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Category;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.CategoryRepository;
import com.codeup.springblog.repositories.CommentRepository;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    //dependency injection
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final CommentRepository commentDao;
    private final CategoryRepository categoryDao;


    public PostController(PostRepository postDao, UserRepository userDao, CommentRepository commentDao, CategoryRepository categoryDao) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.commentDao = commentDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("/posts")
    public String posts(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{postId}")
    public String individualPost(@PathVariable long postId, Model model){
        model.addAttribute("singlePost", postDao.getOne(postId));
        return "posts/show";
    }

    @GetMapping("/posts/edit/{id}")
    public String showPostToEdit(@PathVariable long id, Model model){
        model.addAttribute("singlePost", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        postDao.save(new Post(id, title, body));
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id){
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String viewCreateForm(Model model){
        model.addAttribute("categories", categoryDao.findAll());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
            @RequestParam(name="title")String title,
            @RequestParam(name="body")String body,
            @RequestParam(name="cat")List<Long> categories)
    {
        List<Category> listCat = new ArrayList<>();

        for(int i = 0; i < categories.size(); i++){
            listCat.add(categoryDao.getOne(categories.get(i)));
        }
        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setBody(body);
        newPost.setCategories(listCat);
        User user = userDao.getOne(3L);
        newPost.setUser(user);
        postDao.save(newPost);
        return "redirect:/posts";
    }
}
