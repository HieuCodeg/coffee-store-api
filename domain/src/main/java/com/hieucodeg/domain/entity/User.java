package com.hieucodeg.domain.entity;

import com.hieucodeg.domain.dto.user.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name="is_first_login",nullable = false)
    private Boolean isFirstLogin;

    @Column(name="code_first_login")
    private String codeFirstLogin;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role role;

    public UserDTO toUserDTO() {
        return new UserDTO()
                .setId(id)
                .setUsername(username)
                .setCodeFirstLogin(codeFirstLogin)
                .setIsFirstLogin(isFirstLogin)
                .setRole(role.toRoleDTO());
    }
}
