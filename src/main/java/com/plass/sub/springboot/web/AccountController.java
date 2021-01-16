package com.plass.sub.springboot.web;

import com.plass.sub.springboot.service.account.AccountService;
import com.plass.sub.springboot.web.dto.SignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/sign-up")
    public String displayMail() {
        return "account/sign-up";
    }

    @PostMapping("/sign-up")
    public String execMail(SignUpDto signUpDto) {
        // 메일 발송
        //accountService.mailSend(signUpDto);

        return "index";
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
