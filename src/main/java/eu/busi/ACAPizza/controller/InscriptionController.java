package eu.busi.ACAPizza.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/inscription")
public class InscriptionController {

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model){

        return "integrated:inscription";
    }
}
