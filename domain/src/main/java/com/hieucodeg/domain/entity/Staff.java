package com.hieucodeg.domain.entity;

import com.hieucodeg.domain.dto.staff.StaffDTO;
import com.hieucodeg.domain.enums.EnumGender;
import com.hieucodeg.utils.AppUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "staffs")
public class Staff extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false)
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private EnumGender gender;


    @Column(unique = true, nullable = false)
    private String phone;

    @OneToOne
    @JoinColumn(name = "location_region_id")
    private LocationRegion locationRegion;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "staff_avatar_id")
    private StaffAvatar avatar;

    public StaffDTO toStaffDTO() {
        return new StaffDTO()
                .setId(id)
                .setFullName(fullName)
                .setDob(AppUtils.localDateToString(dob))
                .setGender(String.valueOf(gender))
                .setPhone(phone)
                .setLocationRegion(locationRegion.toLocationRegionDTO())
                .setUser(user.toUserDTO())
                .setStaffAvatar(avatar.toStaffAvatarDTO());
    }
}