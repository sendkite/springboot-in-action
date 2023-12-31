package com.example.todos.web.model;

import com.example.todos.core.user.domain.User;

import java.util.Objects;

public class UserProfile {

    private static final String DEFAULT_PROFILE_PICTURE_URL = "/assets/img/profile-picture.png";
    private static final String USER_PROFILE_PICTURE_URL = "/user/profile-picture";

    private User user;

    public UserProfile(User user) {
        this.user = Objects.requireNonNull(user, "user object must be not null");
    }

    public String getName() {
        return user.getUsername();
    }

    public String getProfilePictureUrl() {
        if (user.hasProfilePicture()) {
            return USER_PROFILE_PICTURE_URL;
        }

        // 프로필 이미지가 없으면 기본 프로필 이미지를 사용한다.
        return DEFAULT_PROFILE_PICTURE_URL;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserProfile{");
        sb.append("name=").append(getName());
        sb.append('}');
        return sb.toString();
    }
}
