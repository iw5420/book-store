package com.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Table(name = "Book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @Column
    @NotEmpty(message = "title為空")
    @Length(max = 80, message = "長度超過80")
    String title;

    @Column
    @NotEmpty(message = "description為空")
    @Length(max = 200, message = "長度超過80")
    String description;

    @Column
    @NotEmpty(message = "author為空")
    @Length(max = 40, message = "長度超過40")
    String author;

    @Column
    LocalDateTime publish_date;

}
