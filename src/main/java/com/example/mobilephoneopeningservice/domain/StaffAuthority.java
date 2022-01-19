package com.example.mobilephoneopeningservice.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false, exclude = {"staff"})
public class StaffAuthority implements GrantedAuthority {
    @ManyToOne
    @ToString.Exclude
    private Staff staff;

    @Id
    private String authority;

    @Override
    public String getAuthority() {

        return authority;
    }
}