package com.example.mobilephoneopeningservice.domain;

import com.example.mobilephoneopeningservice.domain.common.BaseEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
public class Staff extends BaseEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String staffId;

    private String name;

    private String password;

    private String phoneNumber;

    //private String role;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id")
    @ToString.Exclude
    private Set<StaffAuthority> authorities;

    @OneToMany
    @JoinColumn(name ="staff_id")
    @ToString.Exclude
    private List<Opening> openings = new ArrayList<>();


    @Override
    public String getUsername() {
        return getStaffId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
        /*
        UserDetails : Authentication 객체의 principal에 담기는 객체로, 유저 정보들을 담고 있다.

        - getAuthorities() : 권한 목록을 리턴
        - getPassword() : 계정의 패스워드를 리턴
        - getUsername() : 계정의 이름을 리턴
        - isAccountNonExpired() : 계정의 만료 여부를 리턴 (true : 만료 안됨)
        - isAccountNonLocked() : 계정의 잠김여부를 리턴 ( true: 잠기지 않음)
        - isCredentialNonExpired() : 패스워드의 만료여부를 리턴 (true: 만료 안됨)
        - isEnabled() : 계정의 사용 가능 여부 (true : 활성화됨)
        */

}
