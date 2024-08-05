package com.hj.todaybb.board;

import com.hj.todaybb.member.CustomUser;
import com.hj.todaybb.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository br;


    public int writePro(Authentication auth, Board board) {
        CustomUser user = (CustomUser) auth.getPrincipal();
        board.setMember(new Member(user.getId()));
        br.save(board);
        return 0;
    }

    public Board view(Long id) {
        Board board = br.findById(id).get();
        board.setView(board.getView()+1);
        br.save(board);
        Optional<Board> result = br.findById(id);
        if(result.isEmpty()){
            return null;
        }
        return result.get();
    }

    public int modifyPro(Long id, Board board) {
        board.setId(id);
        br.save(board);
        return 0;
    }


}
