package com.sumprjct.hotel.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "confirm_code")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ConfirmCode {

    @Id
    @Column(nullable = false)
    private String key;

    @OneToOne(targetEntity = Account.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Account user;

    @CreationTimestamp
    @Column(nullable = false)
    @Value("NOW()")
    private Date creationDate;
    
}
