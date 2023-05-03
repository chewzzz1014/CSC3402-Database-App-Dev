package com.csc3402.lab.staff.controller;

import com.csc3402.lab.staff.model.Staff;
import com.csc3402.lab.staff.repository.StaffRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staffs")
public class StaffController {
    private final StaffRepository staffRepository;

    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("staffs", staffRepository.findAll());
        return "list-staff";
    }

    @GetMapping("signup")
    public String showSignUpForm(Staff staff) {
        return "add-staff";
    }

    public String addStaff(@Valid Staff staff, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "add-staff";
        }

        staffRepository.save(staff);
        return "redirect:list";
    }


}
