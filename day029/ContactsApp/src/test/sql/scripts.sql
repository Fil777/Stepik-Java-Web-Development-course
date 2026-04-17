INSERT INTO contacts (id, birth_date, email, first_name, last_name, sex, telephone)
VALUES (1, '1959-11-18', 'andrew.yosh@mail.ru', 'Андрей', 'Ёшкин', 'М', '+7-999-999-18-78');

select * from contacts;

select * from contact_owners;

SELECT contacts_next_id();

