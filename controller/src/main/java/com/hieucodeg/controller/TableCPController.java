package com.hieucodeg.controller;


import com.hieucodeg.domain.dto.staff.StaffDTO;
import com.hieucodeg.service.staff.IStaffService;
import com.hieucodeg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/cp/tables")
public class TableCPController {

    @Autowired
    private AppUtils appUtils;

    @Autowired
    private IStaffService staffService;

    @GetMapping
    public ModelAndView showListPage() {


        Optional<StaffDTO> staffDTOOptional = staffService.getByUsernameDTO(appUtils.getUserName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("staff",staffDTOOptional.get());
        modelAndView.setViewName("cp/table/list");

        return modelAndView;

    }

}
