package com.example.bookshop.domain.entities;

import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Transactional
@Entity
@Table
public class Author extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany(targetEntity = Book.class, mappedBy = "author")
    private Set<Book> books;

    public String toStringWithCount() {
        return String.format("%s %s %d", firstName, lastName, books.size());
    }
}
