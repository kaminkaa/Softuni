package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import todolist.bindingModel.TaskBindingModel;
import todolist.entity.Task;
import todolist.repository.TaskRepository;

import java.util.List;

@Controller
public class TaskController {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String index(Model model) {

        // Get all tasks from the database
        List<Task> tasks = this.taskRepository.findAll();

        // Pass the tasks to the view that will show them all
        model.addAttribute("tasks", tasks);
        model.addAttribute("view", "task/index");

        return "base-layout";
    }

    @GetMapping("/create")
    public String create(Model model) {

        // Show the form for creating a task
        model.addAttribute("view", "task/create");

        return "base-layout";
    }

    @PostMapping("/create")
    public String createProcess(Model model, TaskBindingModel taskBindingModel) {

        // Create a new task
        Task taskEntity = new Task(
                taskBindingModel.getTitle(),
                taskBindingModel.getComments()
        );

        // Upload the task to the database
        this.taskRepository.saveAndFlush(taskEntity);

        // Redirect user to home page
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {

        // Check if task exists
        if (!this.taskRepository.exists(id)){
            return "redirect:/";
        }

        // Get the task to be deleted
        Task task = this.taskRepository.findOne(id);

        // Pass the task to the delete view
        model.addAttribute("task", task);
        model.addAttribute("view", "task/delete");

        return "base-layout";
    }

    @PostMapping("/delete/{id}")
    public String deleteProcess(Model model, @PathVariable int id) {

        // Check if task exists
        if (!this.taskRepository.exists(id)){
            return "redirect:/";
        }

        // Get the task to be deleted
        Task task = this.taskRepository.findOne(id);

        // Remove task from database
        this.taskRepository.delete(task);

        // Redirect user to home page
        return "redirect:/";
    }
}
