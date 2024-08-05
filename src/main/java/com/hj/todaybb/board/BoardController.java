package com.hj.todaybb.board;

import com.hj.todaybb.member.CustomUser;
import com.hj.todaybb.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LongSummaryStatistics;


@RequestMapping("/board")
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository br;
    private final BoardService bs;

    @GetMapping("/write")
    String write(){

        return "board/write.html";
    }

    @PostMapping("/write")
    String writePro(Authentication auth, @ModelAttribute Board board){

        int result = bs.writePro(auth, board);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model){
        model.addAttribute("board",bs.view(id));
        return "board/detail.html";
    }
    @GetMapping("/modify/{id}")
    String modify(@PathVariable Long id, Model model){
        model.addAttribute("board", br.findById(id).get());
        return "board/modify.html";
    }

    @PostMapping("/modify/{id}")
    String modifyPro(@PathVariable Long id , @ModelAttribute Board board){
        bs.modifyPro(id,board);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    String delete(@PathVariable Long id){
        br.deleteById(id);
        return "redirect:/";
    }




}
