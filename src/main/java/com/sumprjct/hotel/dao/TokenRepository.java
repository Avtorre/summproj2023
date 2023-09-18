package com.sumprjct.hotel.dao;

import com.sumprjct.hotel.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    @Query("""
            Select t from Token t Inner Join Account u 
            On t.user.id = u.id
            Where u.id = :id and t.revoked = false
            """)
    List<Token> findAllValidTokenByUser(Long id);
    
    Optional<Token> findByToken(String token);

}
