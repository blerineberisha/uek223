package com.example.demo.domain.blog;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String text;
    private String category;

}
