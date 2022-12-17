package com.masai.dao;

import com.masai.model.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionDAO extends JpaRepository<CurrentUserSession, Integer> {
    public CurrentUserSession findByUuid(String uuid);
    public CurrentUserSession findByUserId(String userId);
   // public CurrentUserSession findByMobileNumber(String uuid);
}
