package com.example.mobilephoneopeningservice.domain;

import com.example.mobilephoneopeningservice.domain.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Device extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceId;

    private String name;

    private String registeredDt;

    private int registerStatus; //0 - 미등록, 1 - 등록 (고객, 청약 매핑을 의미)

    @OneToOne(mappedBy = "device") //Opening과의 1:1 관계만 표기하고, openingId는 표기하지 않음.
    @ToString.Exclude
    private Opening opening;



}
