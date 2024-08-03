package com.hj.todaybb.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class MemberService {
    private final PasswordEncoder pe;
    private final MemberRepository mr;

    public int join(Member row) {
        if(row.getPassword().length() < 6){
            return 0;
        }else {
            var hash = pe.encode(row.getPassword());
            row.setPassword(hash);
            mr.save(row);
        }
        return 1;

    }


}
