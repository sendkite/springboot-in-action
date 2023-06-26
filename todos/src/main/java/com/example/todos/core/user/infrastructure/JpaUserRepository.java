package com.example.todos.core.user.infrastructure;

import com.example.todos.Constant;
import com.example.todos.core.user.domain.User;
import com.example.todos.core.user.domain.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Profile(Constant.PROFILE_PRODUCTION)
@Repository
public interface JpaUserRepository extends UserRepository, JpaRepository<User, String> {
}
