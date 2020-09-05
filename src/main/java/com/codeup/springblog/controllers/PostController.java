package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Category;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.CategoryRepository;
import com.codeup.springblog.repositories.CommentRepository;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    //dependency injection
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final CommentRepository commentDao;
    private final CategoryRepository categoryDao;
    private final EmailService emailService;


    public PostController(PostRepository postDao, UserRepository userDao, CommentRepository commentDao, CategoryRepository categoryDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.commentDao = commentDao;
        this.categoryDao = categoryDao;
        this.emailService = emailService;
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

    @GetMapping("/posts/{id}/edit")
    public String showPostToEdit(@PathVariable long id, Model model){
        model.addAttribute("singlePost", postDao.getOne(id));
        model.addAttribute("categories", categoryDao.findAll());
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(
            @PathVariable long id,
            @ModelAttribute Post singlePost,
            @RequestParam(name="cat")List<Long> categories){

        List<Category> listCat = new ArrayList<>();

        for(int i = 0; i < categories.size(); i++){
            listCat.add(categoryDao.getOne(categories.get(i)));
        }

        User user = userDao.getOne(3L);
        singlePost.setUser(user);
        singlePost.setCategories(listCat);
        postDao.save(singlePost);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id){
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String viewCreateForm(Model model){
        model.addAttribute("post", new Post());
        model.addAttribute("categories", categoryDao.findAll());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
            @ModelAttribute Post post,
            @RequestParam(name="cat")List<Long> categories)
    {
        List<Category> listCat = new ArrayList<>();

        for(int i = 0; i < categories.size(); i++){
            listCat.add(categoryDao.getOne(categories.get(i)));
        }
        post.setCategories(listCat);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postDao.save(post);
        emailService.prepareAndSend(post,"Confirmation",user.getUsername() + ", your post has been successfully created!");
        return "redirect:/posts";
    }

    @PostMapping("/posts/{postId}/add-comment")
    public String addComment(@PathVariable long postId){
        return "";
    }
}
