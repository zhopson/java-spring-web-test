/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.man.comic.webmavenspring.service;

import home.man.comic.webmavenspring.entity.Note;
import home.man.comic.webmavenspring.repository.NoteRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author andrey-man
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    protected JdbcOperations jdbcOperations;

    private NoteRepository repository;

    @Autowired
    public void setProductRepository(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Note getNoteById(Integer id) {
        return repository.getOne(id);// .findById(id);// .findOne(id);
    }

    @Override
    public void saveNote(Note note) {
        repository.save(note);
    }

    @Override
    public void updateNote(Integer id, String message, java.util.Date dt, boolean done) {
        Note updated = repository.getOne(id);//  .findOne(id);
        updated.setDone(done);
        updated.setMessage(message);
        updated.setDate(dt);
        repository.save(updated);
    }

    @Override
    public void deleteNote(Integer id) {
        repository.deleteById(id);// .delete(id);
    }

    @Override
    public List<Note> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Map<String, Object>> findAllsql() {

//        List<Note> list = this.jdbcOperations.query(
//                "SELECT id,msg,date,done FROM test_spr_web",
//                new RowMapper<Note>() {
//            public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Note nt = new Note();
//                nt.setId(rs.getInt(1));
//                nt.setMessage(rs.getString(2));
//                nt.setDate(rs.getDate(3));
//                nt.setDone(rs.getBoolean(4));
//
//                return nt;
//            }
//        });

        //return repository.findAllsql();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        List<Note> list = new ArrayList<>();
        
//        SqlRowSet rowSet  = jdbcOperations.queryForRowSet("SELECT id,msg,date,done FROM public.test_spr_web");
//        while (rowSet.next()) {
//            Note nt = new Note();
//            nt.setId(rowSet.getInt(1));
//            nt.setMessage(rowSet.getString(2));
//            nt.setDate(rowSet.getDate(3));
//            nt.setDone(rowSet.getBoolean(4));
//            list.add(nt);
//        }  
        
        
        
        
        List<Map<String, Object>> list = this.jdbcOperations.queryForList(
                "SELECT id,msg as message,to_char(date,'YYYY-MM-DD HH24:MI') as date,done FROM test_spr_web");
        return list;
    }

    @Override
    public List<Note> findAllByOrderByDateAsc() {
        return repository.findAllByOrderByDateAsc();
    }

    @Override
    public List<Note> findAllByOrderByDateDesc() {
        return repository.findAllByOrderByDateDesc();
    }
}
