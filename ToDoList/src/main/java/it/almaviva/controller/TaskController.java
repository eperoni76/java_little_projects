package it.almaviva.controller;

import it.almaviva.model.Task;
import it.almaviva.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/todolist")
public class TaskController {

    private final TaskService service;

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        @InitBinder
        public void initBinder(WebDataBinder binder) {
            binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
                @Override
                public void setAsText(String text) throws IllegalArgumentException {
                    LocalDate date = LocalDate.parse(text, dateFormatter);
                    setValue(date);
                }
            });
    }

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model){
        List<Task> lst = (List<Task>) service.getAll();
        model.addAttribute("allTasks", lst);
        return "list";
    }
    @GetMapping("/add")
    public String saveTask(Model model){
        model.addAttribute("task", new Task());
        return "add";
    }

    @PostMapping("/add")
    public String saveTask(@ModelAttribute Task task){
        service.saveTask(task);
        return "redirect:/templates/list";
    }


}
