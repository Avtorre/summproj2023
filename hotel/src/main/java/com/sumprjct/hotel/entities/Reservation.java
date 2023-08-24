package com.sumprjct.hotel.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Getter
@Setter
@Table(name = "reservation")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = Account.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Account userId;

    @Column(nullable = false, length = 256, unique = true)
    private String rooms;

    @CreationTimestamp
    @Column(nullable = false)
    @Value("NOW()")
    private Date startDate;

    @CreationTimestamp
    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    @Value("false")
    private Boolean status;

    @CreationTimestamp
    @Column(nullable = false)
    @Value("NOW()")
    private Date creationDate;


}
