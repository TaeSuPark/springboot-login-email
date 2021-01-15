package com.plass.sub.springboot.web;

import com.plass.sub.springboot.domain.account.Account;
import com.plass.sub.springboot.domain.account.AccountRepository;
import com.plass.sub.springboot.service.account.AccountService;
import com.plass.sub.springboot.web.dto.SignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import lombok.Builder;

@RequiredArgsConstructor
@RestController
public class SignUpController {

    private final AccountRepository accountRepository;
    private final AccountService accountService;

    @PostMapping("sign-up")
    public String singUp(@RequestBody SignUpDto signUpDto, Errors errors){
        if(errors.hasErrors()) {
            return "account/sign-up";
        }

        //회원정보 저장
        Account account = Account.builder()
                .email(signUpDto.getEmail())
                .nickname(signUpDto.getNickname())
                .password(signUpDto.getPassword())
                .build();

        accountRepository.save(account);

        //임의의 이메일 토큰 생성
        account.generateEmailCheckToken();
        //이메일 전송
        accountService.signUpEmailSender(account);
        return "redirect:/";
    }
}
