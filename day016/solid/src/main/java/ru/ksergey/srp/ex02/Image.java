package ru.ksergey.srp.ex02;

import java.util.UUID;

public class Image extends Attach {
    private ImageSize size;

    private Image(int width, int height) {
        this.size = new ImageSize(width, height);
    }

    public static Image createImage(int width, int height) {
        return new Image(width, height);
    }

    public ImageSize getSize() {
        return new ImageSize(size.getWidth(), size.getHeight());
    }

    public void saveToFile(String path) {
        // Реализация сохранения в файл
    }

    public int getWidth() {
        return size.getWidth();
    }

    public int getHeight() {
        return size.getHeight();
    }

    public void sendToEmail(String email, String text, String subject) {
        // Реализация отправки на email
    }

    public void uploadToSftpServer(String sftp, int port, UUID token, User user) {
        // Реализация загрузки на SFTP сервер
    }

    public void loadFileFromUrl(String url) {
        // Реализация загрузки файла из URL
    }
}
