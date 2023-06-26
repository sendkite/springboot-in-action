package com.example.todos.core.user.domain;

import jakarta.persistence.Embeddable;

import java.net.URI;

@Embeddable
public class ProfilePicture {

    private URI uri;

    @SuppressWarnings("unused")
    public ProfilePicture() {
    }

    public ProfilePicture(URI uri) {
        this.uri = uri;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }
}
