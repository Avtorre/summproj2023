package com.sumprjct.hotel.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Getter
@Setter
@Table(name = "room_type")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = Image.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "outer_preview", referencedColumnName = "id")
    private Image outerPreview;

    @Column
    private String caption;

    @OneToOne(targetEntity = Image.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "inner_preview", referencedColumnName = "id")
    private Image innerPreview;

    @Column(nullable = false,length = 1024)
    private String description;

    @Column(nullable = false)
    private Short guestCount;

    @CreationTimestamp
    @Column(nullable = false)
    @Value("NOW()")
    private Date creationDate;

}
