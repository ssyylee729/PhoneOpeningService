package com.example.mobilephoneopeningservice.service;

import com.example.mobilephoneopeningservice.domain.Staff;
import com.example.mobilephoneopeningservice.repository.StaffRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
public class LoginService implements UserDetailsService {
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return staffRepository.findByStaffId(username).orElseThrow(()-> new UsernameNotFoundException(username));
    }
}