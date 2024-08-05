package com.hj.todaybb;

import com.hj.todaybb.board.Board;
import com.hj.todaybb.board.BoardRepository;
import com.hj.todaybb.member.Member;
import com.hj.todaybb.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BasicController {
    private final BoardRepository br;
    @GetMapping("/")
    String home(Model model){
        List<Board> boards =br.findAll();
        model.addAttribute("boards",boards);
        return "home.html";
    };
}
