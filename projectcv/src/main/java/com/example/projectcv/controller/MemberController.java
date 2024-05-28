package com.example.projectcv.controller;

import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.Member;
import com.example.projectcv.services.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private MemberService memberService;

    @GetMapping("/{id}")
    public ApiResponse<Member> getMemberById(@PathVariable  Long id) {
        return memberService.getMemberById(id);
    }
}
