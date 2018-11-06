package eu.busi.firstSpringProject.controller;

import eu.busi.firstSpringProject.dataAccess.dao.MagicKeyDAO;
import eu.busi.firstSpringProject.model.MagicKeyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/")
public class WelcomeController {

    @Autowired
    MagicKeyDAO magicKeyDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model){
        model.addAttribute("title", "Premiere page");
        model.addAttribute("magicKeyForm", new MagicKeyForm());
        return "integrated:welcome";
    }

    @RequestMapping(value="/send", method = RequestMethod.POST)
    public String getFormData (@ModelAttribute(value="magicKeyForm") MagicKeyForm form){

        List<String> magicKeys = new ArrayList<>(magicKeyDAO.getMagicKey());
        for ( String key: magicKeys) {
            if (form.getMagicKey().equals(key))
                return "redirect:/inscription";
        }
        return "/WEB-INF/jsp/keyError.jsp";

    }

}
