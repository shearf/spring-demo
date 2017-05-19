package com.shearf.demo.spring.component;

import com.shearf.demo.spring.domain.Author;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by xiahaihu on 17/5/19.
 */
@Component
public class AuthorComponent {

    @Value("${author.username}")
    private String name;

    @Value("${author.email}")
    private String email;

    public Author author() {

        Author author = new Author();
        author.setEmail(email);
        author.setUsername(name);
        return author;
    }
}
