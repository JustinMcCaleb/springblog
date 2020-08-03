package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String posts(Model model){
        ArrayList<Post> allPosts = new ArrayList<>();
        Post ufo = new Post("UFO","It abducted my lizard!");
        Post ghost = new Post("Ghost", "It walked through walls man.");
        allPosts.add(ufo);
        allPosts.add(ghost);
        model.addAttribute("posts", allPosts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable int id, Model model){
        Post vampire = new Post("Vampire", "Tbh, this dude sucked");
        model.addAttribute("post", vampire);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreateForm(){
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    public String createPost(){
        return "create a new post";
    }
}
