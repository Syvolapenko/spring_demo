package com.goit11.spring_demo_example.mvc;

import com.goit11.spring_demo_example.core.Note;
import com.goit11.spring_demo_example.core.NoteIdException;
import com.goit11.spring_demo_example.core.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    private NoteService noteService;
    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }
    @GetMapping("/list")
    public String getList(Model model){
        List<Note> notes = noteService.listAll();
        model.addAttribute("notes",notes);
        return "note-list";
    }
    @GetMapping("/create")
    public String addNewNoteForm(Note note){
        return "note-create";
    }
    @PostMapping("/create")
    public String addNewNote(Note note){
        noteService.addNotes(note);
        return "redirect:/note/list";
    }
    @GetMapping("/delete")
    public String getListDelete(Model model){
        List<Note> notes = noteService.listAll();
        model.addAttribute("notes",notes);
        return "note-list-delete";
    }
    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") Long id) throws NoteIdException {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
    @GetMapping("/edit")
    public String editNote(Model model){
        List<Note> notes = noteService.listAll();
        model.addAttribute("notes",notes);
        return "note-list-edit";
    }
    @GetMapping("/edit/{id}")
    public String updateform(@PathVariable("id") Long id,Model model) throws NoteIdException {
        Note note = noteService.getById(id);
        model.addAttribute("notes",note);
        return"note-list-update";
    }
    @PostMapping("/editlist")
    public String updateNote(Note note) throws NoteIdException {
        noteService.update(note);
        return "redirect:/note/list";
    }

}
