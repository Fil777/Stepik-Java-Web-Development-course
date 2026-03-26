package ru.ksergey.srp.ex01;

import java.util.UUID;

public class Image extends Attach {
    private int width;
    private int height;

    private Image(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static Image createImage(int width, int height) {
        return new Image(width, height);
    }

    public void sendToEmail(String email, String text, String subject) {
        // Реализация отправки на email
    }

    public void uploadToSftpServer(String sftp, int port, UUID token, String username, String login) {
        // Реализация загрузки на SFTP сервер
    }

    public void loadFileFromUrl(String url) {
        // Реализация загрузки файла из URL
    }

    public void saveToFile(String path) {
        // Реализация сохранения в файл
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
