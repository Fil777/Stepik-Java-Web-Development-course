INSERT INTO contacts (first_name, last_name, telephone, email)
VALUES
    ('Анна', 'Смирнова', '+7(926) 555-78-90', 'anna.smirnova@yandex.ru'),
    ('Дмитрий', 'Козлов', '+7(905) 123 45 67', 'dmitry_kozlov@gmail.com'),
    ('Елена', 'Новикова', '+7(916) 987 65 43', 'elena_n@mail.ru'),
    ('Сергей', 'Волков', '+7(903) 333 22 11', 'sergey.volkov@outlook.com'),
    ('Ольга', 'Морозова', '+7(495) 765 43 21', 'olga.morozova@rambler.ru'),
    ('Марина', 'Иванова', '+7(495) 765 43 00', 'ma.ivanova@ex.ru');

INSERT INTO contact_owners (id, username, description, email, password, role)
VALUES
    ('72512f41-a69b-437b-a052-78cfd112f380', 'admin', 'Администратор системы', 'admin@example.com', 'AdminPass123', 'USER'),
    ('72512f41-a69b-437b-a052-78cfd112f381', 'user1', 'Первый пользователь', 'user1@example.com', 'UserPass123', 'ADMIN'),
    ('72512f41-a69b-437b-a052-78cfd112f382', 'user2', 'Второй пользователь', 'user2@example.com', 'UserPass456', 'ADMIN');
