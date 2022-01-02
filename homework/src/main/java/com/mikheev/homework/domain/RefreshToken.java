package com.mikheev.homework.domain;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "refreshtokens")
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "id")
    private User user;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "EXPIRATION_DATE")
    private ZonedDateTime expirationDate;
}
