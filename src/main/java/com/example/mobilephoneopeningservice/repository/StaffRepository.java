package com.example.mobilephoneopeningservice.repository;

import com.example.mobilephoneopeningservice.domain.Staff;
import com.example.mobilephoneopeningservice.domain.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    Staff findNameByStaffId(String staffId);

    List<Staff> findByName(String name);

    Page<Staff> findAll(Pageable pageable);

    List<Staff> findAll();

    Optional<Staff> findByStaffId(String staffId);

    @Query(value ="select s from Staff s where staffId = :staffId", nativeQuery = true)
    Staff findByStaffIdNotOptional(@Param("staffId") String staffId);

    void deleteByStaffId(String staffId);
}
