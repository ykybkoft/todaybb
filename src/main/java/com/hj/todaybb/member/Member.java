package com.hj.todaybb.member;

import com.hj.todaybb.board.Board;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

@ToString
@Setter
@Getter
@Entity

public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 30)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String nick;

    public Member(Long id) {
        this.id = id;
    }

    public Member(){}

}
