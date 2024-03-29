package com.hieucodeg.api;

import com.hieucodeg.domain.entity.Otp;
import com.hieucodeg.domain.entity.User;
import com.hieucodeg.exception.DataInputException;
import com.hieucodeg.exception.ResourceNotFoundException;
import com.hieucodeg.service.email.EmailSender;
import com.hieucodeg.service.otp.IOtpService;
import com.hieucodeg.service.user.IUserService;
import com.hieucodeg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/otp")
public class OtpAPI {

    @Autowired
    private IOtpService otpService;

    @Autowired
    private IUserService userService;

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private AppUtils appUtils;


    @GetMapping("{code}")
    public ResponseEntity<?> getOtpByCode(@PathVariable String code) {

        Otp otp = otpService.getByCode(code);

        if (otp == null) {
            throw new ResourceNotFoundException("Mã xác nhận không đúng! Vui lòng kiểm tra lại!");
        }

        return new ResponseEntity<>(otp.toOtpDTO(), HttpStatus.OK);
    }

    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOtp(@RequestBody String email) {

        email = email.trim();
        if (email.equals("")) {
            throw new DataInputException("Email không hợp lệ");
        }

        User user = userService.getByUsername(email);

        if (user == null) {
            throw new DataInputException("Email không hợp lệ");
        }

        Optional<Otp> otpOptional = otpService.getOtpByUserId(user.getId());

        if (otpOptional.isPresent()) {
            otpService.softDelete(otpOptional.get().getId());
        }

        String code = appUtils.randomOtp(6);

        Otp newOtp = new Otp()
                .setId(null)
                .setCode(code)
                .setUser(user);

        newOtp = otpService.save(newOtp);

        emailSender.sendOtp(user, newOtp.getCode());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
