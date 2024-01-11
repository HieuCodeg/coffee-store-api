package com.hieucodeg.controller;

import com.hieucodeg.domain.dto.staff.StaffDTO;
import com.hieucodeg.domain.entity.Staff;
import com.hieucodeg.service.staff.IStaffService;
import com.hieucodeg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/cp/staffs")
public class StaffCPController {

    @Autowired
    private AppUtils appUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IStaffService staffService;

    @GetMapping
    public ModelAndView showListPage() {

        Optional<StaffDTO> staffDTOOptional = staffService.getByUsernameDTO(appUtils.getUserName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("staff",staffDTOOptional.get());
        modelAndView.setViewName("cp/staff/list");

        return modelAndView;

    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {

        Optional<StaffDTO> staffDTOOptional = staffService.getByUsernameDTO(appUtils.getUserName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("staff",staffDTOOptional.get());
        modelAndView.setViewName("cp/staff/create");

        return modelAndView;

    }

    @GetMapping("/{staffId}")
    public ModelAndView showViewPage(@PathVariable Long staffId) {


        Optional<StaffDTO> staffDTOOptional = staffService.getByUsernameDTO(appUtils.getUserName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("staff",staffDTOOptional.get());

        Optional<Staff> staffOptional = staffService.findById(staffId);
        Staff staff = staffOptional.get();

        modelAndView.addObject("viewer", staff.toStaffDTO());

        modelAndView.setViewName("cp/staff/view");

        return modelAndView;
    }

    @GetMapping("/account-recovery")
    public ModelAndView showListAccountRecoveryPage() {

        Optional<StaffDTO> staffDTOOptional = staffService.getByUsernameDTO(appUtils.getUserName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("staff",staffDTOOptional.get());
        modelAndView.setViewName("cp/staff/recoveryStaff");

        return modelAndView;

    }

}
