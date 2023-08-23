package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.utils.ValidationHelpers;

public class CommentImpl implements Comment {

    private String author;
    private String content;

    public CommentImpl(String content, String author) {
        setContent(content);
        setAuthor(author);
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    private void setContent(String content) {
        validateContent(content);
        this.content = content;
    }

    void validateContent(String content) {
        ValidationHelpers.validateIntRange(
                content.length(),
                CONTENT_LEN_MIN,
                CONTENT_LEN_MAX,
                CONTENT_LEN_ERR);
    }

    private void setAuthor(String author) {
        validateAuthor(author);
        this.author = author;
    }

    void validateAuthor(String author) {
        if (author == null) {
            throw new IllegalArgumentException("Author can not be null.");
        }
    }

    @Override
    public String toString() {
        return String.format("----------\n" +
                "%s\n" +
                "User: %s\n" +
                "----------", getContent(), getAuthor());
    }
}