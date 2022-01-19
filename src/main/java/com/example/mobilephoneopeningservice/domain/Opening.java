package com.example.mobilephoneopeningservice.domain;

import com.example.mobilephoneopeningservice.domain.common.BaseEntity;
import com.example.mobilephoneopeningservice.domain.common.OpeningEntityListener;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = {OpeningEntityListener.class})
@Audited
public class Opening extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String openingId;

    private LocalDateTime requestDt;

    //null 허용 X, 기본값을 0으로 세팅하기 위해 primitive type 사용.
    private int status;

    @NotAudited
    @OneToOne(optional = false) //Opening에는 deviceId를 포함
//    @JoinColumn(name = "opening_id")
//    @ToString.Exclude
    private Device device;

    @NotAudited
    @ManyToOne
    private Customer customer;

    @NotAudited
    @ManyToOne
    private Staff staff;

    @NotAudited
    @OneToMany
    @JoinColumn(name="opening_id", insertable = false, updatable = false)
    @ToString.Exclude
    List<OpeningHistory> openingHistories = new ArrayList<>();


    public Opening(String opening_id) {
        this.openingId = opening_id;
    }
}
