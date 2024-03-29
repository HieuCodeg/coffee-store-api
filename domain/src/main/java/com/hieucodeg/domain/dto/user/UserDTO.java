package com.hieucodeg.domain.dto.user;

import com.hieucodeg.domain.dto.role.RoleDTO;
import com.hieucodeg.domain.entity.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;

    @NotBlank(message = "Vui lòng nhập email!")
    @Email(message = "Email không hợp lệ!")
    @Size(min = 10, max = 50, message = "Độ dài email nằm trong khoảng 10-50 ký tự!")
    private String username;

    @NotBlank(message = "Vui lòng nhập mật khẩu!")
    @Size(min = 10, max = 20, message = "Độ dài mật khẩu nằm trong khoảng 10-20 ký tự!")
    private String password;

    private Boolean isFirstLogin;

    private String codeFirstLogin;
    @Valid
    private RoleDTO role;

    public UserDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public User toUser() {
        return new User()
                .setId(id)
                .setUsername(username)
                .setPassword(password)
                .setRole(role.toRole());
    }
}
