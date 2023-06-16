package com.example.asm.email;
import com.example.asm.core.admin.repository.AdminKhachHangRepository;
import com.example.asm.entity.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Annotation
@RestController
@RequestMapping("/email")
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
public class EmailController {

    @Autowired
    private EmailService emailService;


    // Sending a simple Email
    @PostMapping("/sendMail")
    public String
    sendMail(@RequestBody EmailDetails details)
    {
        String status
                = emailService.sendSimpleMail(details);

        return status;
    }

    @GetMapping("/quenmatkhau/{email}")
    public Integer guiMa(@PathVariable("email") String email){

        return emailService.sendEmail(email);
//        return Random.randomInteger();
    }

    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
            @RequestBody EmailDetails details)
    {
        String status
                = emailService.sendMailWithAttachment(details);

        return status;
    }
    @GetMapping("/khachhang/{email}")
    public KhachHang getKhachHang(@PathVariable("email") String email){
        return emailService.getKhachHang(email);
    }

    @PostMapping("/doimatkhau")
    public KhachHang doiMatKhau(@RequestBody KhachHang khachHang){
        return emailService.doiMatKhau(khachHang);
    }
}
