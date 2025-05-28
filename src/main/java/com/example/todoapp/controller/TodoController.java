package com.example.todoapp.controller;


import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoRepository todoRepository;

    @GetMapping({"","/","/home"})
    public String showHomePage(Model model) {
        model.addAttribute("todos",todoRepository.findAll());
        return "index";
    }
    @PostMapping("/add")
    public String add(@RequestParam String title){
        Todo newTodo=Todo.builder()
                .title(title)
                .completed(false)
                .build();
        todoRepository.save(newTodo);
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable long id){
        Todo existingtodo = todoRepository.findById(id).orElseThrow(()->new RuntimeException("Todo Not Found: "+id));
        existingtodo.setCompleted(!existingtodo.getCompleted());
        todoRepository.save(existingtodo);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        Todo existingtodo = todoRepository.findById(id).orElseThrow(()->new RuntimeException("Todo Not Found: "+id));
        todoRepository.delete(existingtodo);
        return "redirect:/";
    }
}
