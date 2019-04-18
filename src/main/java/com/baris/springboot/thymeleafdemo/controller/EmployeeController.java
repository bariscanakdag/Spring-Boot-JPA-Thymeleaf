package com.baris.springboot.thymeleafdemo.controller;

import com.baris.springboot.thymeleafdemo.entity.Employee;
import com.baris.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String getEmployees(Model theModel) {

        theModel.addAttribute("employeeList", employeeService.findAllByOrderByLastNameAsc());
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model theModel) {

        theModel.addAttribute("employee", new Employee());

        return "employees/employee-form";
    }

    @GetMapping("/showFormUpdate")
    public String showUpdateForm(@RequestParam("employeeId") int theId, Model theModel) {

        theModel.addAttribute("employee", employeeService.findById(theId));
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

        employeeService.Save(theEmployee);
        return "redirect:list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId) {

        employeeService.deleteById(theId);
        return "redirect:list";
    }


}
