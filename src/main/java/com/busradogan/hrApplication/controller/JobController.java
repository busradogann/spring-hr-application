package com.busradogan.hrApplication.controller;

import javax.validation.Valid;

import com.busradogan.hrApplication.domain.*;
import com.busradogan.hrApplication.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JobController {
    private final JobService jobService;
    private final UserService userService;

    @Autowired
    public JobController(JobService jobService, UserService userService){
        this.jobService = jobService;
        this.userService = userService;
    }

    @RequestMapping("/create")
    public ModelAndView jobAddPage() {
        return new ModelAndView("addJob", "jobAddForm", new JobAddForm());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String handleJobAdd(@Valid @ModelAttribute("jobForm") JobAddForm form, 
        BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "addJob";

        jobService.addJob(form);
            return "redirect:/";
    }

    @RequestMapping("/")
    public ModelAndView getHomePage(@AuthenticationPrincipal User user) {
        return new ModelAndView("home", "user", user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String handleJobDelete(@PathVariable Long id) {
        jobService.deleteJobById(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String handleJobAssign(@ModelAttribute("user") JobAssignForm form, @PathVariable("id") long id) {
        jobService.assignJob(form.getName(), id);
        return "redirect:/";
    }

}