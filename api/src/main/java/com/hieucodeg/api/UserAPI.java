package com.hieucodeg.api;

import com.hieucodeg.domain.dto.user.UserUpdatePasswordDTO;
import com.hieucodeg.domain.entity.User;
import com.hieucodeg.exception.DataInputException;
import com.hieucodeg.service.user.IUserService;
import com.hieucodeg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserAPI {

    @Autowired
    private AppUtils appUtils;


    @Autowired
    private IUserService userService;


    @PostMapping("/update-password")
    public ResponseEntity<?> updatePassword(@Validated @RequestBody UserUpdatePasswordDTO userUpdatePasswordDTO, BindingResult bindingResult) {

        Optional<User> userOptional = userService.findByCodeFirstLogin(userUpdatePasswordDTO.getCodeFirstLogin());
        if (!userOptional.isPresent()) {
            throw new DataInputException("Người dùng không hợp lệ.");
        }

        User user = userOptional.get();

        if (!user.getIsFirstLogin()) {
            throw new DataInputException("Người dùng không hợp lệ.");
        }

        if (user.getDeleted()) {
            throw new DataInputException("Tài khoản của bạn đã bị khóa!");
        }

        if (bindingResult.hasFieldErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }

        String password = userUpdatePasswordDTO.getPassword();
        String passwordConfirm = userUpdatePasswordDTO.getPasswordConfirm();

        if (!password.equals(passwordConfirm)) {
            throw new DataInputException("Mật khẩu không trùng nhau. Vui lòng nhập lại!");
        }

        user.setPassword(password)
                .setIsFirstLogin(false)
                .setCodeFirstLogin("0");
        userService.save(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
