package com.hieucodeg.service.staff;

import com.hieucodeg.domain.dto.staff.StaffCreateDTO;
import com.hieucodeg.domain.dto.staff.StaffDTO;
import com.hieucodeg.domain.entity.LocationRegion;
import com.hieucodeg.domain.entity.Staff;
import com.hieucodeg.domain.entity.StaffAvatar;
import com.hieucodeg.domain.entity.User;
import com.hieucodeg.service.IGeneralService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


public interface IStaffService extends IGeneralService<Staff> {

    List<StaffDTO> getAllStaffDTOWhereDeletedIsFalse();

    List<StaffDTO> getAllStaffDTOWhereDeletedIsTrue();

    List<StaffDTO> getAllStaffDTOWhereDeletedIsFalseAndIdNot(Long staffId);

    Optional<StaffDTO> getByUsernameDTO(String username);

    Staff createWithAvatar(StaffCreateDTO staffCreateDTO, LocationRegion locationRegion, User user, MultipartFile file);

    Staff createNoAvatar(StaffCreateDTO staffCreateDTO, LocationRegion locationRegion, User user);

    Staff saveWithLocationRegion(Staff staff);

    Staff saveNoAvatar(Staff staff);

    Staff saveWithAvatar(Staff staff, MultipartFile file);

    StaffAvatar uploadAndSaveStaffAvatar(MultipartFile file, StaffAvatar staffAvatar);

    void softDelete(Long staffId);

    void recoveryAccount(Long staffId);

    Optional<Staff> findByPhone(String phone);

    Boolean existsByPhoneAndIdNot(String phone, Long id);
}

