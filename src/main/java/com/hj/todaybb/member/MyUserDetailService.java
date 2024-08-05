package com.hj.todaybb.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {
    private final MemberRepository mr;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var result =mr.findByUsername(username);

        if(result.isEmpty()){
            throw new UsernameNotFoundException("그런 아이디는 없습니다.");
        }

        var user = result.get();
        List<GrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority("normal"));

        CustomUser customUser = new CustomUser(user.getUsername(), user.getPassword(),authList);
        customUser.setId(user.getId());
        customUser.setNick(user.getNick());
        return customUser;
    }
}


