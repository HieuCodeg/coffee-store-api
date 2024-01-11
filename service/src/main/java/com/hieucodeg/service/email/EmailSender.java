package com.hieucodeg.service.email;
import com.hieucodeg.domain.entity.Staff;
import com.hieucodeg.domain.entity.User;
import com.hieucodeg.utils.EmailUtil;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailSender {

    public void sendRegisterStaffEmail(Staff recipient, String recipientEmail) {

        final String username = EmailUtil.MY_EMAIL;
        final String password = EmailUtil.MY_PASSWORD;

        String codeFirstLogin = recipient.getUser().getCodeFirstLogin();

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });


        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipientEmail + ", hieucodeg@gmail.com")
            );
            message.setSubject("Thông báo");
            message.setText("Xin chào " + recipient.getFullName() + ","
                    + "\n\n Tài khoản của bạn đã được tạo thành công!"
                    + "\n\n Email: " + recipientEmail + ","
                    + "\n\n Vui lòng cập nhật lại mật khẩu tại trang: 'http://localhost:25001/cp/update-password/" + codeFirstLogin + "',"
                    + "\n\n Không cung cấp đường dẫn này cho bất kỳ ai để đảm bảo tính bảo mật tài khoản."
                    + "\n\n Đây là email trả lời tự động, vui lòng không reply lại nội dung email này. Chỉ những yêu cầu hỗ trợ phù hợp mới được chúng tôi phản hồi."
                    + "\n\n Cám ơn bạn đã tham gia với chúng tôi!"
                    + "\n\n Love!"
                    + "\n\n Legend Coffee"
            );

            Transport.send(message);

            System.out.println("Gửi mail thành công!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendOtp(User recipientAccount, String otp) {

        final String username = EmailUtil.MY_EMAIL;
        final String password = EmailUtil.MY_PASSWORD;

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipientAccount+", hieucodeg@gmail.com")
            );
            message.setSubject("Thông báo");
            message.setText("Mã xác nhận của bạn là: " + otp + ","
                    + "\n\n Vui lòng không cung cấp cho bất kỳ ai để đảm bảo tính bảo mật!"
                    + "\n\n Legend Coffee"
            );

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
