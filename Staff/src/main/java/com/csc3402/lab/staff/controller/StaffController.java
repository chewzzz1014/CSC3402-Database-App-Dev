package com.csc3402.lab.staff.controller;
import com.csc3402.lab.staff.repository.ProjectRepository;
import com.csc3402.lab.staff.repository.StaffProjectRepository;
import com.csc3402.lab.staff.repository.StaffRepository;
import com.csc3402.lab.staff.repository.DepartmentRepository;
import com.csc3402.lab.staff.model.Staff;
import com.csc3402.lab.staff.model.StaffProject;
import com.csc3402.lab.staff.model.Project;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

@Controller
@RequestMapping("/staffs")
public class StaffController {
    private final StaffRepository staffRepository;
    private final DepartmentRepository departmentRepository;
    @Autowired
    private final ProjectRepository projectRepository;
    private final StaffProjectRepository staffProjectRepository;

    public StaffController(StaffRepository staffRepository, DepartmentRepository departmentRepository, ProjectRepository projectRepository, StaffProjectRepository staffProjectRepository) {
        this.staffRepository = staffRepository;
        this.departmentRepository = departmentRepository;
        this.projectRepository = projectRepository;
        this.staffProjectRepository = staffProjectRepository;
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("staffs", staffRepository.findAll());
        return "list-staff";
    }

    @GetMapping("signup")
    public String showSignUpForm(Staff staff, Model model){
        model.addAttribute("departments", departmentRepository.findAll());
        return "add-staff";
    }

    @PostMapping("add")
    public String addStaff(@Valid Staff staff, BindingResult result, Model model) {
        if (result.hasErrors()) {
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

    @GetMapping("delete")
    public String showDeleteMainForm(Model model) {
        model.addAttribute("staffs", staffRepository.findAll());
        return "choose-staff-to-delete";
    }

    @GetMapping("delete/{id}")
    public String deleteStaff(@PathVariable("id") long id, Model model) {
        Staff staff = staffRepository.findById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid staff Id:" + id));
        staffRepository.delete(staff);
        model.addAttribute("staffs", staffRepository.findAll());
        return "list-staff";
    }


    // Project and Staff

    // Assign Project to Staff
    @GetMapping("assign")
    public String assignStaffProject(Model model) {
        model.addAttribute("staffs", staffRepository.findAll());
        return "choose-project-to-assign";
    }

    @GetMapping("assign/{id}")
    public String showAssignProjectForm(@PathVariable("id") long id, @Valid StaffProject
            staffProject, Model model) {
        Staff staff = staffRepository.findById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid staff Id:" + id));
        model.addAttribute("staff", staff);
        model.addAttribute("projects", projectRepository.findAll());

        return "assign-project";
    }

    @PostMapping("staffproject/{staffid}")
    public String updateStaffProject(@PathVariable("staffid") long id1, @Valid Project proj, @RequestParam String startDate,
                                     @RequestParam String endDate, @RequestParam String role, @Valid StaffProject staffProject,
                                     BindingResult result, Model model) {
        if (result.hasErrors()) {
            staffProject.setId();
            return "index";
        }

        Staff staff = staffRepository.findStaffById((int) id1);
        Project project = projectRepository.findProjectById(proj.getProjectId());

        StaffProject staffProject1 = new StaffProject(staff,project,startDate,endDate,role);
        staffProjectRepository.save(staffProject1);

        return "index";
    }

    @GetMapping("display")
    public String displayStaffProject(Model model) {
        model.addAttribute("staffs", staffRepository.findAll());

        return "choose-project-to-display";
    }

    @GetMapping("display/{staffid}")
    public String showDisplayProjectForm(@PathVariable("staffid") long id, Model model) {
        List<StaffProject> staffProject = (List<StaffProject>) staffProjectRepository.findStaffProjectByStaffId((int) id);
        //     .orElseThrow(() -> new IllegalArgumentException("Invalid staff Id:" + id));
        model.addAttribute("staff", staffRepository.findStaffById((int)id));
        model.addAttribute("staffProjects", staffProject);

        return "display-project";
    }



}