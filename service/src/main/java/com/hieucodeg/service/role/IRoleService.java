package com.hieucodeg.service.role;

import com.hieucodeg.domain.dto.role.RoleDTO;
import com.hieucodeg.domain.entity.Role;
import com.hieucodeg.service.IGeneralService;

import java.util.List;


public interface IRoleService extends IGeneralService<Role> {
    Role findByCode(String code);

    List<RoleDTO> getAllRoleDTONoCustomer();

    List<RoleDTO> getAllRoleDTONoAdminAndCustomer();
}
