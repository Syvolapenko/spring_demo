package com.goit11.spring_demo_example.core;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    private final List<Note> notes = new ArrayList<>();
    public Note addNotes(Note note) {
        final int max = 100;
        long number = (long) (Math.random()*max+1);
        note.setId(number);
        notes.add(note);
        return note;
    }
    public List<Note> listAll() {
        if(!notes.isEmpty()) {
            return notes;
        }
        return null;
    }
    public void deleteById(long id) throws NoteIdException {
        for (Note note : notes) {
            if (note.getId() == id) {
                notes.remove(note);
                System.out.println("Employee id " + id +" deleted");
                return;
                }
        }
        throw new NoteIdException("Employee id " + id + " not found");
    }
    public void update(Note note) throws NoteIdException{
        for(Note s: notes){
            if(s.getId()==note.getId()){
                s.setTitle(note.getTitle());
                s.setContent(note.getContent());
                return;
            }
        }
        throw new NoteIdException("Old employee with id " + note.getId() + " not found");
    }
    public Note getById(long id) throws NoteIdException {
        for(Note s: notes){
            if(s.getId()==id){
                return s;
            }
        }
        throw new NoteIdException("Employee id " + id + " not found");
    }
}
