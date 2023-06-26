package com.example.todos.core.user.domain.support;

import com.example.todos.core.user.domain.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.nio.charset.Charset;

@Component
public class SimplePasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes(Charset.defaultCharset()));
    }
}
