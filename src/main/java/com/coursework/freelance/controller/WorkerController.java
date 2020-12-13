package com.coursework.freelance.controller;

import com.coursework.freelance.entity.Worker;
import com.coursework.freelance.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/workers")
    public String getWorkersPage(Model model) {
        List<Worker> workers = workerService.findAll();
        int half = (workers.size() % 2 == 0) ? (workers.size() / 2) : ((workers.size() / 2) + 1);
        List<Worker> workers1 = workers.stream().limit(half).collect(Collectors.toList());
        List<Worker> workers2 = workers.stream().skip(half).collect(Collectors.toList());
        model.addAttribute("workers1", workers1);
        model.addAttribute("workers2", workers2);
        return "workers";
    }

    @GetMapping("/worker")
    public String getWorkerProfilePage(@RequestParam(value = "id") Long id,
                                       Model model,
                                       RedirectAttributes redirectAttributes) {
        Worker worker = workerService.findById(id);
        model.addAttribute("worker", worker);
        redirectAttributes.addAttribute("id", id);
        return "worker";
    }
}
