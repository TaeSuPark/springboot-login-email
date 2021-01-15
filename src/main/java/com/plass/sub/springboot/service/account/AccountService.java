package com.plass.sub.springboot.service.account;


import com.plass.sub.springboot.domain.account.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final JavaMailSender javaMailSender;


    public void signUpEmailSender(Account account){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(account.getEmail());
        mailMessage.setSubject("회원 가입 인증 이메일");
        mailMessage.setText("/check-email-token?token=" + account.getEmailCheckToken()
                +"&email=" + account.getEmail());
        javaMailSender.send(mailMessage);
    }
}
