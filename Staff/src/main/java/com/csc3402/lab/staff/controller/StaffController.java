package com.csc3402.lab.staff.controller;

import com.csc3402.lab.staff.model.Staff;
import com.csc3402.lab.staff.repository.StaffRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("update")
    public String showUpdateMainForm(Model model) {
        model.addAttribute("staffs", staffRepository.findAll());
        return "choose-staff-to-update";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Staff staff = staffRepository.findById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid staff Id:" + id));
        model.addAttribute("staff", staff);
        model.addAttribute("departments", departmentRepository.findAll());
        return "update-staff";
    }

    @PostMapping("update/{id}")
    public String updateStaff(@PathVariable("id") long id, @Valid Staff staff, BindingResult result, Model model) {
        if (result.hasErrors()) {
            staff.setStaffId((int) id);
            return "index";
        }

        model.addAttribute("staffs", staffRepository.findAll());
        staffRepository.save(staff);
        return "list-staff";
    }

}
