package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
@RequestMapping("/learn")
public class LearnController  {
    private Logger logger = LoggerFactory.getLogger(this.getClass());



    @GetMapping("/test")
    public String getModel(){
        return "learn-resource";
    }


}