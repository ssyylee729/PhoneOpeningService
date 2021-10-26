package com.example.mobilephoneopeningservice.domain;

import com.example.mobilephoneopeningservice.domain.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Opening extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime requestDt;

    private int status;

    @OneToMany
    @JoinColumn(name = "opening_id")
    @ToString.Exclude
    private List<Device> devices = new ArrayList<>();

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Staff staff;

    @OneToMany
    @JoinColumn(name="opening_id", insertable = false, updatable = false)
    @ToString.Exclude
    List<OpeningHistory> openingHistories = new ArrayList<>();



}
