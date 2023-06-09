package com.kusitms.oauthproejct.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kusitms.oauthproejct.service.OauthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/auth")
public class OauthController {

    private final OauthService oauthService;

    @GetMapping(value="/{socialLoginType}")
    public void socialLoginType(@PathVariable(name="socialLoginType") String socialLoginType) throws IOException {
        oauthService.request(socialLoginType);
    }

    @GetMapping(value="/{socialLoginType}/callback")
    public void callback(
            @PathVariable(name="socialLoginType") String socialLoginType,
            @RequestParam(name="code") String code) throws JsonProcessingException {
        oauthService.oauthLogin(socialLoginType, code);
    }
}