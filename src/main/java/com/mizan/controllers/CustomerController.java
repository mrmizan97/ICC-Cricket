//package com.mizan.controllers;
//
//import com.mizan.model.Customer;
//import com.mizan.service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.HashMap;
//
//@Controller
//@RequestMapping("/customer/")
//public class CustomerController {
//    @Autowired
//    private CustomerService customerService;
//
//    @GetMapping("register")
//    public String add(Model model) {
//        model.addAttribute("title", "Customer Registration");
//        var genders = new HashMap<String, String>();
//        genders.put("M", "Male");
//        genders.put("F", "Female");
//        model.addAttribute("genders", genders);
//        model.addAttribute("customer", new Customer());
//        return "customer/register";
//    }
//
//    @PostMapping("store")
////    @ResponseBody
//    public String store(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
//       if (bindingResult.hasErrors()){
//           model.addAttribute("customer",customer);
//           return "customer/register";
//       }
//        this.customerService.save(customer);
//        return "login";
//    }
//
//
//}
