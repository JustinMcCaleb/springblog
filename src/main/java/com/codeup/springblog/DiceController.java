package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String guess(){
        return "dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String result(@PathVariable int n, Model model){
        model.addAttribute("userGuess", n);
        return "dice";
    }
}
