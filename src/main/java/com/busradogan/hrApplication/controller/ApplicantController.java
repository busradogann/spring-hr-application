package com.busradogan.hrApplication.controller;

import com.busradogan.hrApplication.service.ApplicantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicantController{
    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService){
        this.applicantService = applicantService;
    }

    @RequestMapping("/applicants")
    public ModelAndView getApplicantsPage() {
        return new ModelAndView("applicants", "applicants", getApplicantsPage());
    }

    //@RequestMapping("/applicants/{id}")
    //public ModelAndView getApplicants(){
    //    return 
    //}

    //@RequestMapping("/apply")
    //public ModelAndView 
    //    return

    }