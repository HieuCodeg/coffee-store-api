package com.hieucodeg.api;

import com.hieucodeg.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")

public class CustomerAPI {

    @Autowired
    private ICustomerService customerService;
}
