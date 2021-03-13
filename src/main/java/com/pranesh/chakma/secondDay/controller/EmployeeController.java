package com.pranesh.chakma.secondDay.controller;

import com.pranesh.chakma.secondDay.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    @GetMapping("/employee/form")
    public String getForm(Model model) {
        model.addAttribute("employeeDb", employeeDb);
        return "secondDay/employee";
    }

    List<Employee> employeeDb = new ArrayList<>(); //[{},{},{}]

    @PostMapping (value = {"/employee", "employeeOne"})
    public String employeeCheck(@ModelAttribute Employee employee) {
        //employee.setId(1);
        //employee.setName("Pranesh Chakma");
        //employee.setMobile("0713343950");
        if (employee.getId()%2==0){
            employee.setName(null);
        }
        employeeDb.add(employee);

        System.out.println(" dasda" + employee.toString());
        return "redirect:/employee/form";

    }
}
