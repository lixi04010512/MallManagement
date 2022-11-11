package com.jide.security.rest;

import com.jide.security.service.AuthService;
import com.jide.security.service.dto.AuthUserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * api登录授权
 *
 */
@Slf4j
@RestController
@RequestMapping("/api/auth")
@Api(tags = "系统授权接口")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ApiOperation("发送邮箱验证码")
    @PostMapping(value = "/getEmailCode")
    public ResponseEntity<Object> getEmailCode(@RequestParam String email) {
        authService.sendMailCode(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("注册")
    @PostMapping(value = "/register")
    public ResponseEntity<Object> register(@RequestBody AuthUserDto authUserDto) {
        return ResponseEntity.ok(authService.register(authUserDto));
    }

    @ApiOperation("登录授权")
    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody AuthUserDto authUserDto, HttpServletRequest request) {
        return ResponseEntity.ok(authService.login(authUserDto, request));
    }

    @ApiOperation("退出登录")
    @DeleteMapping(value = "/logout")
    public ResponseEntity<Object> logout(HttpServletRequest request) {
        authService.logout(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
