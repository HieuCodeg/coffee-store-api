package com.hieucodeg.controller;

import com.hieucodeg.domain.dto.staff.StaffDTO;
import com.hieucodeg.service.staff.IStaffService;
import com.hieucodeg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
@RequestMapping("/cp/products")
public class ProductCPController {

    @Autowired
    private AppUtils appUtils;

    @Autowired
    private IStaffService staffService;

    @GetMapping
    public ModelAndView showListPage() {

        Optional<StaffDTO> staffDTOOptional = staffService.getByUsernameDTO(appUtils.getUserName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("staff",staffDTOOptional.get());
        modelAndView.setViewName("cp/product/list");

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {

        Optional<StaffDTO> staffDTOOptional = staffService.getByUsernameDTO(appUtils.getUserName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("staff",staffDTOOptional.get());
        modelAndView.setViewName("cp/product/create");

        return modelAndView;

    }

    @GetMapping("/{productId}")
    public ModelAndView showViewProduct(@PathVariable Long productId) {

        ModelAndView modelAndView = new ModelAndView();

        Optional<StaffDTO> staffDTOOptional = staffService.getByUsernameDTO(appUtils.getUserName());
        modelAndView.addObject("staff",staffDTOOptional.get());

        modelAndView.setViewName("cp/product/view");

        return modelAndView;
    }
}
