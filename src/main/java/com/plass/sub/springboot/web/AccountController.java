package com.plass.sub.springboot.web;

import com.plass.sub.springboot.service.account.AccountService;
import com.plass.sub.springboot.web.dto.SignUpDto;
import com.plass.sub.springboot.web.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class AccountController {

    private final AccountService accountService;

    // localhost:8080/sign-up
    @GetMapping("/sign-up") // 해당 url의 요청이 들어왔을 때
    public String displayMail() {
        return "account/sign-up";
    }

    @PostMapping("/sign-up") //해당 url에서 Post 방식으로 데이터가 넘어올 때
    public String execMail(SignUpDto signUpDto, Model model) {
        // 메일 발송
        // signUpDto에 form에 입력한 정보가 모두 포함되어 있음 -> getter로 조회 가능
        accountService.mailSend(signUpDto);

        // signUpDto 객체를 세션에 저장하는 과정이 필요합니다.(여기엔 구현 x) -> View가 넘어가면 객체는 남아있지 않기 때문
        return "account/check";
    }

    @PostMapping("/check")
    public String checkMail(TokenDto tokenDto, Model model) {
        if (accountService.mailCheck(tokenDto)) { // true -> 값이 일치
            // 세션에 저장된 signUpDto 객체를 통해
            // db에 회원정보를 추가하는 과정이 필요합니다. (여기엔 구현 x)
            return "account/success";
        }
        //틀렸다면 첫 페이지로
        return "account/sign-up";
    }


}
 /*

    private final AccountService accountService;

    @GetMapping("/mail")
    public String displayMail() {
        return "mail";
    }

    @PostMapping("/mail")
    public String execMail(SignUpDto signUpDto) {
        // 메일 발송
        //accountService.mailSend(signUpDto);

        return "check";
    }

     private final AccountRepository accountRepository;
    private final AccountService accountService;

    @GetMapping("/sign-up")
    public String signUpForm(Model model){
        model.addAttribute(new SignUpForm());
        return "account/sign-up";
    }

    @PostMapping("/sign-up")
    public String singUp(SignUpForm signUpForm, Errors errors){
        if(errors.hasErrors()) {
            return "account/sign-up";
        }
        accountService.processNewAccount(signUpForm);
        return "redirect:/";
    }

     */
