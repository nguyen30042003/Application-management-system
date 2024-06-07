package com.example.projectcv.controller;

import com.example.projectcv.dto.request.MemberDTO;
import com.example.projectcv.dto.response.ApiResponse;

import com.example.projectcv.entity.Member;
import com.example.projectcv.services.MemberService;
import lombok.AllArgsConstructor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private MemberService memberService;

    @GetMapping("/{id}")
    public ApiResponse<Member> getMemberById(@PathVariable  Long id) {
        return memberService.getMemberById(id);
    }

    @GetMapping()
    public Page<Member> getAllMembers(Pageable pageable) {
        return memberService.getMembers(pageable);
    }

    @PutMapping("/{id}")
    public ApiResponse<Member> updateMember(@PathVariable Long id, @RequestBody MemberDTO memberDTO) {
        return memberService.updateMember(id,memberDTO);
    }


}
