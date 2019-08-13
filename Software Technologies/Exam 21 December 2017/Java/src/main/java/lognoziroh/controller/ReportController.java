package lognoziroh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import lognoziroh.bindingModel.ReportBindingModel;
import lognoziroh.repository.ReportRepository;
import lognoziroh.entity.Report;

import java.util.List;

@Controller
public class ReportController {
	private final ReportRepository reportRepository;

	@Autowired
	public ReportController(ReportRepository reportRepository) {
		this.reportRepository = reportRepository;
	}

	@GetMapping("/")
	public String index(Model model) {

		// Get all reports from database
		List<Report> reports = this.reportRepository.findAll();

		// Pass the reports to the index view
		model.addAttribute("reports", reports);
		model.addAttribute("view", "report/index");

		return "base-layout";
	}

	@GetMapping("/details/{id}")
	public String details(Model model, @PathVariable int id) {

		// Get the report
		Report report = this.reportRepository.findOne(id);

		// Pass the report to the details view
		model.addAttribute("report", report);
		model.addAttribute("view", "report/details");

		return "base-layout";
	}

	@GetMapping("/create")
	public String create(Model model) {

		// Show the create view
		model.addAttribute("view", "report/create");

		return "base-layout";
	}

	@PostMapping("/create")
	public String createProcess(Model model, ReportBindingModel reportBindingModel) {

		// Create a new report with the entered data from the form
		Report report = new Report(
				reportBindingModel.getStatus(),
				reportBindingModel.getMessage(),
				reportBindingModel.getOrigin()
		);

		// Upload the report to the database
		this.reportRepository.saveAndFlush(report);

		// Redirect user to home page
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {

		// Get the report to be deleted
		Report report = this.reportRepository.findOne(id);

		// Pass the report to the delete view
		model.addAttribute("report", report);
		model.addAttribute("view", "report/delete");

		return "base-layout";
	}

	@PostMapping("/delete/{id}")
	public String deleteProcess(@PathVariable int id, ReportBindingModel reportBindingModel) {

		// Get the report to be deleted
		Report report = this.reportRepository.findOne(id);

		// Remove report from database
		this.reportRepository.delete(report);

		// Redirect user to home page
		return "redirect:/";
	}
}
