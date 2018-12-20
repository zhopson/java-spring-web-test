/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.man.comic.webmavenspring.service;

import home.man.comic.webmavenspring.entity.Note;
import java.util.List;
import java.util.Map;

/**
 *
 * @author andrey-man
 */
public interface NoteService {

    Note getNoteById(Integer id);

    void saveNote(Note note);

    void updateNote(Integer id, String message, java.util.Date dt, boolean done);

    void deleteNote(Integer id);
    
    List<Note> findAll();
    
    List<Map<String, Object>> findAllsql();

    List<Note> findAllByOrderByDateAsc();

    List<Note> findAllByOrderByDateDesc();
}
