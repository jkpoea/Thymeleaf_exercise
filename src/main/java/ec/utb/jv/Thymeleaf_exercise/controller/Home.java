package ec.utb.jv.Thymeleaf_exercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {

    private List<String> someList = new ArrayList<>();

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("index", "Test message successfully posted");
        return "";
    }
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam String string){
        if (!string.isEmpty()){
            someList.add(string);
        }
        return "redirect:/contact";
    }
    @ModelAttribute
    public void contactList(Model model){
        model.addAttribute("some", someList);
    }

}
