package com.hieucodeg.repository;

import com.hieucodeg.domain.entity.DatabaseCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseCheckRepository extends JpaRepository<DatabaseCheck, Long> {
}
