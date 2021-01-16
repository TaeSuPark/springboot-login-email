package com.plass.sub.springboot.service.account;


import com.plass.sub.springboot.domain.account.AccountRepository;
import com.plass.sub.springboot.web.dto.SignUpDto;
import com.plass.sub.springboot.web.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final JavaMailSender javaMailSender;
    private String randNum;
    private boolean checkFlag = false;

    public String mailSend(SignUpDto signUpDto) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            // ---- randNum 생성부
            randNum = randNumCreate();
            //------------//
            message.setTo(signUpDto.getEmail());
            //message.setFrom(); // 누가 메일을 보내는지 설정할 수 있음
            message.setSubject("인증 안내 메일입니다."); // 메일 제목
            message.setText("해당 코드를 입력해주세요." + " CODE : " + randNum); // 메일 내용
            javaMailSender.send(message);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return randNum;
    }

    public boolean mailCheck(TokenDto tokenDto) {
        try {
            if (randNum.equals(tokenDto.getToken())) {
                checkFlag = true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return checkFlag;
    }

    //랜덤한 String 생성
    public String randNumCreate() {
        String tempNum="";
        for(int i=0; i<8; i++) {
            int rndVal = (int)(Math.random() * 62);
            if(rndVal < 10) {
                tempNum += rndVal;
            }
            else if(rndVal > 35) {
                tempNum += (char)(rndVal + 61);
            }
            else {
                tempNum += (char)(rndVal + 55);
            }
        }
        return tempNum;

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
