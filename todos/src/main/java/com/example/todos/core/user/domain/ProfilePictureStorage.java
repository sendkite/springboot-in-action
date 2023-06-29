package com.example.todos.core.user.domain;

import org.springframework.core.io.Resource;

import java.net.URI;

public interface ProfilePictureStorage {

    URI save(Resource resource);

    Resource load(URI uri);
}
