package com.hieucodeg.service.staffAvatar;

import com.hieucodeg.domain.entity.StaffAvatar;
import com.hieucodeg.service.IGeneralService;

import java.util.Optional;


public interface IStaffAvatarService extends IGeneralService<StaffAvatar> {

    Optional<StaffAvatar> findById(String id);

    void delete(String id);
}
