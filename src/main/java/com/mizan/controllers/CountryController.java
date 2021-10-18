package com.mizan.controllers;

import com.mizan.model.User;
import com.mizan.responseDto.CountryRequestDto;
import com.mizan.service.CountryService;
import com.mizan.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/country/")
public class CountryController {
    Logger logger = LogManager.getLogger(CountryController.class);
    @Autowired
    private CountryService countryService;
    @Autowired
    private UserService userService;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("countries", countryService.CountryResponseDtoList());
        return "/country/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("country", new CountryRequestDto());
        List<User> directors = userService.getAllUser();
        List<User> players = userService.getAllUser();
        model.addAttribute("directors", directors);
        model.addAttribute("players", players);
        return "/country/create";
    }

    @PostMapping("store")
    public String store(Model model,
                        @Valid @ModelAttribute(name = "country") CountryRequestDto countryRequestDto,
                        BindingResult errors) {
        if (errors.hasErrors()) {
            return "/country/create";
        }
        logger.info(countryRequestDto);
        countryService.createCountry(countryRequestDto);
        return "redirect:/country/index";
    }
}