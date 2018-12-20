/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.man.comic.webmavenspring.controllers;

import home.man.comic.webmavenspring.entity.Note;
import home.man.comic.webmavenspring.service.NoteService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author andrey-man
 */
@Controller
public class CrudController {

    private NoteService service;

    @Autowired
    public void setNoteService(NoteService service) {
        this.service = service;
    }

    @GetMapping("/new")
    public String newNote() {
        return "operations/new";
    }

    @PostMapping("/save")
    public String updateNote(@RequestParam String new_msg) {
        service.saveNote(new Note(new_msg));
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Note note = service.getNoteById(id);
//        String dt = note.getDate().toString().replace(' ', 'T')+'Z';
        //String dt = note.getDate().toString().substring(0, 19);
        model.addAttribute("id", id);
        //model.addAttribute("dt", dt);
        model.addAttribute("note", note);
        return "operations/edit";
    }

    @PostMapping("/update")
    public String saveChNote(@RequestParam Integer id, @RequestParam String edit_msg, @RequestParam String edit_dt,
            @RequestParam(value = "edit_done", required = false) boolean edit_done) {
            //@RequestParam String edit_done) {
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date dt = format1.parse(edit_dt);
//            boolean dn = false;
//            if (edit_done == "on") dn = true;
            service.updateNote(id, edit_msg, dt, edit_done);
            return "redirect:/";
        } catch (ParseException ex) {
            Logger.getLogger(CrudController.class.getName()).log(Level.SEVERE, null, ex);
            return "redirect:/";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteNote(id);
        return "redirect:/";
    }

}
