package com.example.todos.commons.util;

import com.example.todos.commons.SystemException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Hashing 알고리즘을 사용하기 위한 유틸리티
public interface DigestUtils {

    /**
     * SHA-256 알고리즘으로 입력된 문자열을 해시 값을 생성합니다.
     *
     * @param value 대상 문자열
     * @return
     */
    static String sha256(String value) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return new String(digest.digest(value.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException error) {
            throw new SystemException("SHA-256 알고리즘이 없습니다.", error);
        }
    }
}
