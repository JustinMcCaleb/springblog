package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String guess(){
        return "dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String result(@PathVariable int n, Model model){
        //random number
        Random rand = new Random();
        int num = rand.nextInt(6) + 1;
        boolean guessedRight = false;
        if (n == num){
            guessedRight = true;
        }
        model.addAttribute("guessedRight", guessedRight);
        model.addAttribute("diceRoll", num);
        model.addAttribute("userGuess", n);
        return "dice-result";
    }
}
