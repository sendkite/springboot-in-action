package com.example.todos.core.user.application;

import com.example.todos.core.user.domain.ProfilePicture;
import com.example.todos.core.user.domain.User;

public interface ProfilePictureChanger {

    User change(String username, ProfilePicture profilePicture);
}
