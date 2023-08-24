package com.sumprjct.hotel.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Getter
@Setter
@Table(name = "rooms")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer number;

    @OneToOne(targetEntity = RoomType.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "type", referencedColumnName = "id")
    private RoomType type;

    @CreationTimestamp
    @Column(nullable = false)
    @Value("NOW()")
    private Date creationDate;

}
