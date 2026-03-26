package ru.ksergey.srp.ex02;

public class EmailService {
    private String email;
    private String text;
    private String subject;
    private Attach[] attach;

    public EmailService(String email, String text, String subject, Attach... attach) {
        this.email = email;
        this.text = text;
        this.subject = subject;
        this.attach = attach;
    }

    public void sendTo(String email, String text, String subject) {
        // Реализация отправки на email
    }
}
