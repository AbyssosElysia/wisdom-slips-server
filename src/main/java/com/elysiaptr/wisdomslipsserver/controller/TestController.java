package com.elysiaptr.wisdomslipsserver.controller;

import com.elysiaptr.wisdomslipsserver.dto.LoginUser;
import com.elysiaptr.wisdomslipsserver.entity.ApiResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/auth")
    public ApiResponse<Long> test(@RequestParam String input) {
        LoginUser principal = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ApiResponse.success(principal.getUser().getId());
    }
}
