package com.company.oop.dealership.models.contracts;

import static java.lang.String.format;

public interface Comment {
    int CONTENT_LEN_MIN = 3;
    int CONTENT_LEN_MAX = 200;
    String CONTENT_LEN_ERR = format(
            "Content must be between %d and %d characters long!",
            CONTENT_LEN_MIN,
            CONTENT_LEN_MAX);

    String getContent();

    String getAuthor();

}
