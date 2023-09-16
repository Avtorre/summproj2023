package com.sumprjct.hotel.dao;

import com.sumprjct.hotel.entities.Account;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("update Account u set u.name = :name where u.id = :id")
    int setNameByUserId(Long id, String name);

    @Transactional
    @Modifying
    @Query("update Account u set u.surname = :surname where u.id = :id")
    int setSurnameByUserId(Long id, String surname);

    @Query(value = "update users set role = 'USER' where id = :id and role = 'NEW' returning 1", nativeQuery = true)
    int setConfirmById(Long id);

}
