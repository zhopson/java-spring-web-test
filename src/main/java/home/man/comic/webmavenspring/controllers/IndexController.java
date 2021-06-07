/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.man.comic.webmavenspring.controllers;

import home.man.comic.webmavenspring.entity.Note;
import home.man.comic.webmavenspring.service.NoteService;
import java.security.Principal;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.WebUtils;

/**
 *
 * @author andrey-man
 */
@Controller
public class IndexController {
//    @GetMapping("/")
//    public ModelAndView index() {
//        Map<String, String> model = new HashMap<>();
//        model.put("name", "Alexey");
//        return new ModelAndView("index").addObject("var", model);
//    }
//    

//    @Autowired
//    private EmployeeDAO employeeDAO;    
    private NoteService service;
    private String sortDateMethod = "ASC";

    @Autowired
    public void setNoteService(NoteService service) {
        this.service = service;
    }

//    @RequestMapping("/")
//    public String handleRequest(Model model) {
////        String nnn = "Ghopson";
////        model.addAttribute("paren", nnn);
////        List<Employee> employees = employeeDAO.getEmployees();
////        model.addAttribute("employees", employees);
//
//        return "index";
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(Model model, Principal principal) {
       if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
//            String userInfo = WebUtils.toString(loginedUser);
 
//            model.addAttribute("userInfo", userInfo);
 
            model.addAttribute("username", principal.getName());
 
        }
        else model.addAttribute("username", "none");
        return "welcome";
    }
    
    
    @GetMapping("/index")
    public String list(Model model, Principal principal) {
        List<Note> notebook = filterAndSort();
        model.addAttribute("notes", notebook);
        model.addAttribute("sort", sortDateMethod);
        
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);        
        model.addAttribute("username", principal.getName());
        
        return "index";
    }

    @GetMapping("/extindex")
    public String extlist(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        model.addAttribute("username", principal.getName());
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);        
        
        return "extindex";
    }

    @RequestMapping(value = "/json_list", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getAllNotes() {

        //return service.findAll();
        return service.findAllsql();
    }

//    public List<Note> getAllNotes() {
//
//        return service.findAll();
//    }
    
    
    @GetMapping("/sort/{sortDate}")
    public String sortChoose(@PathVariable String sortDate) {
        sortDateMethod = sortDate;
        return "redirect:/index";
    }

    private List<Note> filterAndSort() {
        List<Note> notebook = null;
        switch (sortDateMethod) {
            case "ASC":
                notebook = service.findAllByOrderByDateAsc();
                break;
            case "DESC":
                notebook = service.findAllByOrderByDateDesc();
                break;
        }
        return notebook;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
 
        return "loginPage";
    }
 
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage() {
        return "welcome";
    }
    
//    @RequestMapping(value = "/header", method = RequestMethod.GET)
//    public String header(Model model, Principal principal) {
// 
//        // After user login successfully.
//        String userName = principal.getName();  
// 
//        System.out.println("User Name from header: " + userName);
// 
//        model.addAttribute("username", userName);
// 
//        return "header";
//    }
    

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
 
        // After user login successfully.
        String userName = principal.getName();  
 
        System.out.println("User Name: " + userName);
 
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
//        model.addAttribute("username", userName);

        ArrayList<String> userRoles = WebUtils.GetRoles(loginedUser);
        model.addAttribute("userRoles", userRoles);
        model.addAttribute("username", userName);
 
        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
            String userInfo = WebUtils.toString(loginedUser);
 
            model.addAttribute("userInfo", userInfo);
            model.addAttribute("username", principal.getName());
 
            String message = "Привет " + principal.getName() //
                    + ",\n У вас нет разрешений на доступ к странице!";
            model.addAttribute("message", message);
 
        }
 
        return "403Page";
    }    

    @RequestMapping(value = "/fill_fake_data", method = RequestMethod.GET)
    @ResponseBody
    public String fillFakeData() {

        //return service.findAll();
        return service.fillFakeData();
    }

}
