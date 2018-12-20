/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.man.comic.webmavenspring.controllers;

import home.man.comic.webmavenspring.entity.Note;
import home.man.comic.webmavenspring.service.NoteService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @GetMapping("/")
    public String list(Model model) {
        List<Note> notebook = filterAndSort();
        model.addAttribute("notes", notebook);
        model.addAttribute("sort", sortDateMethod);
        return "index";
    }

    @GetMapping("/extindex")
    public String extlist() {
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
        return "redirect:/";
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

}
