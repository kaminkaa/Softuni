package teistermask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import teistermask.bindingModel.TaskBindingModel;
import teistermask.entity.Task;
import teistermask.repository.TaskRepository;

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
		List<Task> openTasks = this.taskRepository.findAllByStatus("Open");
		List<Task> inProgressTasks = this.taskRepository.findAllByStatus("In Progress");
		List<Task> finishedTasks = this.taskRepository.findAllByStatus("Finished");

		// Pass the tasks to the view that will show them all
		model.addAttribute("openTasks", openTasks);
		model.addAttribute("inProgressTasks", inProgressTasks);
		model.addAttribute("finishedTasks", finishedTasks);
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
		Task task = new Task(
				taskBindingModel.getTitle(),
				taskBindingModel.getStatus()
		);

		// Upload the task to the database
		this.taskRepository.saveAndFlush(task);

		// Redirect user to home page
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable int id) {
		// Check if task exists
		if (!this.taskRepository.exists(id)){
			return "redirect:/";
		}

		// Get the task that is to be edited
		Task task = this.taskRepository.findOne(id);

		// Pass the task to the edit view
		model.addAttribute("task", task);
		model.addAttribute("view", "task/edit");

		return "base-layout";
	}

	@PostMapping("/edit/{id}")
	public String editProcess(@PathVariable int id, TaskBindingModel taskBindingModel) {
		// Check if task exists
		if (!this.taskRepository.exists(id)){
			return "redirect:/";
		}

		// Get the task to be edited
		Task task = this.taskRepository.findOne(id);

		// Edit the film
		task.setTitle(taskBindingModel.getTitle());
		task.setStatus(taskBindingModel.getStatus());

		// Update database
		taskRepository.saveAndFlush(task);

		// Redirect user to home page
		return "redirect:/";
	}
}
