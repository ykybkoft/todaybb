package com.hj.todaybb.member;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.ConstructorParameters;
import java.beans.ConstructorProperties;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);
}
