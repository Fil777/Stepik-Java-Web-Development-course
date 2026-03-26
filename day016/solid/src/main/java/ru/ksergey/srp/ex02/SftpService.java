package ru.ksergey.srp.ex02;

import java.util.UUID;

public class SftpService {
    private final String ftp;
    private final int port;
    private final User user;
    private final Attach[] attach;
    private final UUID key;

    public SftpService(String ftp, int port, User user, UUID token, Attach... attach) {
        this.ftp = ftp;
        this.port = port;
        this.user = user;
        this.attach = attach;
        this.key = token;
    }

    public void upload() {
        // Реализация загрузки на SFTP сервер
    }
}
