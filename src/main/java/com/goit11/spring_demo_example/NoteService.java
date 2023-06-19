package com.goit11.spring_demo_example;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    private final List<Note> notes = new ArrayList<>();

    public Note addNotes(Note note) {
        notes.add(note);
        return note;
    }
    public void allNotes() {
        List<Note> noteList = new ArrayList<>();
        if (!notes.isEmpty()) {
            for (Note s : notes) {
                noteList.add(s);
            }
            System.out.println(noteList);
        } else {
            System.out.println("List is empty");
        }
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
