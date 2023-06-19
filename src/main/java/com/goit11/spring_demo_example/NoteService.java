package com.goit11.spring_demo_example;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    private final List<Note>notes = new ArrayList<>();
        public List<Note> addNotes(){
        Note note1 = new Note();
        note1.setId(1L);
        note1.setTitle("Movie");
        note1.setContent("This is Sparta");
        notes.add(note1);
        return notes;
        }
        public void allNotes(){
        List<Note> noteList = new ArrayList<>();
        if(!notes.isEmpty()){
            for(Note s: notes) {
                noteList.add(s);
            }
            System.out.println(noteList);
            }else {
            System.out.println("List is empty");
        }
        }
        public void deleteById(long id) throws NoteIdException {
            for (Note note : notes) {
                if (note.getId() == id) {
                    notes.remove(note);
                    System.out.println("Employee deleted");
                    return;
                }
            }
            throw new NoteIdException("Employee id not found");
        }

        public void update(Note note) throws NoteIdException{
        for(Note s: notes){
            if(s.getId()==note.getId()){
                s.setTitle(note.getTitle());
                s.setContent(note.getContent());
                return;
            }
        }
        throw new NoteIdException("Employee id not found");
    }

        public Note getById(long id) throws NoteIdException {
                for(Note s: notes){
                    if(s.getId()==id){
                        return s;
                    }
                }
                throw new NoteIdException("Employee id not found");
            }
        }
