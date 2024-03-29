package com.hieucodeg.domain.dto.staff;

import com.hieucodeg.domain.dto.locationRegion.LocationRegionDTO;
import com.hieucodeg.domain.dto.staffAvatar.StaffAvatarDTO;
import com.hieucodeg.domain.dto.user.UserDTO;
import com.hieucodeg.domain.entity.LocationRegion;
import com.hieucodeg.domain.entity.Staff;
import com.hieucodeg.domain.entity.StaffAvatar;
import com.hieucodeg.domain.entity.User;
import com.hieucodeg.domain.enums.EnumGender;
import com.hieucodeg.utils.AppUtils;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StaffDTO {
    private Long id;

    @NotEmpty(message = "Vui lòng nhập tên nhân viên!")
    @Size(min = 5, max = 100, message = "Họ tên có độ dài nằm trong khoảng 5 - 100 ký tự.")
    private String fullName;

    @NotEmpty(message = "Vui lòng nhập ngày tháng năm sinh!")
    private String dob;

    @NotEmpty(message = "Vui lòng chọn giới tính!")
    private String gender;
    @NotEmpty(message = "Vui lòng nhập số điện thoại.")
    @Pattern(regexp = "^0[1-9][0-9]{8}$", message = "Số điện thoại không đúng định dạng.")
    private String phone;

    @Valid
    private LocationRegionDTO locationRegion;

    @Valid
    private UserDTO user;

    @Valid
    private StaffAvatarDTO staffAvatar;

    public StaffDTO(Long id, String fullName, String phone, LocalDate dob, EnumGender gender , LocationRegion locationRegion, User user, StaffAvatar staffAvatar) {
        this.id = id;
        this.fullName = fullName;
        this.dob = AppUtils.localDateToString(dob);
        this.gender = String.valueOf(gender);
        this.phone = phone;
        this.locationRegion = locationRegion.toLocationRegionDTO();
        this.user = user.toUserDTO();
        this.staffAvatar = staffAvatar.toStaffAvatarDTO();
    }

    public Staff toStaff() {
        return new Staff()
                .setId(id)
                .setFullName(fullName)
                .setPhone(phone)
                .setDob(AppUtils.stringToLocalDate(dob))
                .setGender(EnumGender.valueOf(gender))
                .setLocationRegion(locationRegion.toLocationRegion())
                .setUser(user.toUser())
                .setAvatar(staffAvatar.toStaffAvatar());
    }
}
