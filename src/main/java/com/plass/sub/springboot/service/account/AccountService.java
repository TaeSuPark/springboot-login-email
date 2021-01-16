package com.plass.sub.springboot.service.account;


import com.plass.sub.springboot.domain.account.AccountRepository;
import com.plass.sub.springboot.web.dto.SignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final JavaMailSender javaMailSender;


    public void mailSend(SignUpDto signUpDto) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(signUpDto.getEmail());
            //message.setFrom(AccountService.FROM_ADDRESS);
            message.setSubject("인증 안내 메일입니다.");
            message.setText("??");

            javaMailSender.send(message);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

 /*

    @Transactional
    public void processNewAccount(SignUpForm signUpForm) {
        Account newAccount = saveNewAccount(signUpForm);
        newAccount.generateEmailCheckToken();
        sendSignUpConfirmEmail(newAccount);
    }

    private Account saveNewAccount(SignUpForm signUpForm) {
        Account account = Account.builder()
                .email(signUpForm.getEmail())
                .nickname(signUpForm.getNickname())
                .password(signUpForm.getPassword())     // TODO encoding 해야함
                //.emailVerified(false)
                //.studyEnrollmentResultByWeb(true)
                //.studyUpdatedByWeb(true)
                .build();

        return accountRepository.save(account);
    }

    private void sendSignUpConfirmEmail(Account newAccount) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(newAccount.getEmail());
        mailMessage.setSubject("테스트, 회원 가입 인증");
        mailMessage.setText("/check-email-token?token=" + newAccount.getEmailCheckToken() + "&email=" + newAccount.getEmail());
        javaMailSender.send(mailMessage);
    }
     */
