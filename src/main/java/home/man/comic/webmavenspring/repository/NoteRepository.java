/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.man.comic.webmavenspring.repository;

import home.man.comic.webmavenspring.entity.Note;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author andrey-man
 */
public interface NoteRepository  extends JpaRepository<Note, Integer> {

   List<Note> findAll();
   //List<Object> findAllsql();
   //SqlRowSet queryForRowSet(String query);
   List<Note> findAllByOrderByDateAsc();
   List<Note> findAllByOrderByDateDesc();    
//    public Note findOne(Integer id);
//
//    public void delete(Integer id);
    
}
