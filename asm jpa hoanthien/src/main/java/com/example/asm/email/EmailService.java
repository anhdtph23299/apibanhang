package com.example.asm.email;

import com.example.asm.entity.KhachHang;

public interface EmailService {
    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);

    Integer sendEmail(String email);

    KhachHang getKhachHang(String email);

    KhachHang doiMatKhau(KhachHang khachHang);
}
