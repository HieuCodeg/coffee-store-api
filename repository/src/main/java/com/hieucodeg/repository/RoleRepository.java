package com.hieucodeg.repository;

import com.hieucodeg.domain.dto.role.RoleDTO;
import com.hieucodeg.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT NEW com.hieucodeg.domain.dto.role.RoleDTO(" +
                "ro.id, " +
                "ro.code" +
            ") " +
            "FROM Role AS ro " +
            "WHERE ro.code <> 'CUSTOMER'"
    )
    List<RoleDTO> getAllRoleDTONoCustomer();

    @Query("SELECT NEW com.hieucodeg.domain.dto.role.RoleDTO(" +
                "ro.id, " +
                "ro.code" +
            ") " +
            "FROM Role AS ro " +
            "WHERE ro.code <> 'ADMIN' " +
            "AND ro.code <> 'CUSTOMER'"
    )
    List<RoleDTO> getAllRoleDTONoAdminAndCustomer();


    Role findByCode(String code);
}
