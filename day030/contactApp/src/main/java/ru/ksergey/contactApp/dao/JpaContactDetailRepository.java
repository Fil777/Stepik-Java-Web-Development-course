package ru.ksergey.contactApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ksergey.contactApp.model.entity.ContactDetail;

public interface JpaContactDetailRepository extends JpaRepository<ContactDetail, Integer> {
}
