package com.hieucodeg.repository;

import com.hieucodeg.domain.entity.CustomerAvatar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAvatarRepository extends JpaRepository<CustomerAvatar, Long> {
}
