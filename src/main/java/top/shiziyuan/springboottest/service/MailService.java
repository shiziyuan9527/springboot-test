package top.shiziyuan.springboottest.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import top.shiziyuan.springboottest.domain.Mail;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailService {

//    @Resource
//    private JavaMailSender mailSender;
//
//    public String sendSimpleMail(Mail mail) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(mail.getFrom());
//        message.setTo(mail.getTo());
//        message.setText(mail.getText());
//        message.setSubject(mail.getSubject());
//        mailSender.send(message);
//        return "ok";
//    }
//
//    public String sendMimeMail(Mail mail) throws MessagingException {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//        helper.addAttachment("test.png", new File(mail.getFilePath()));
//        helper.setSubject(mail.getSubject());
//        helper.setText(mail.getText());
//        helper.setFrom(mail.getFrom());
//        helper.setTo(mail.getTo());
//        mailSender.send(mimeMessage);
//        return "ok";
//    }
}
