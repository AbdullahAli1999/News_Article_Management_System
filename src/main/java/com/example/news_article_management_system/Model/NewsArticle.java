package com.example.news_article_management_system.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewsArticle {
    @NotEmpty
    private String id;
    @NotEmpty
    @Size(min = 1, max = 100 , message = "Maximum length of 100 characters.")
    private String title;
    @NotEmpty
    @Size(min = 4,max = 20,message = "Maximum length of 20 characters.")
    private String author;
    @NotEmpty
    @Size(min = 1 , max = 200,message = "Must be more than 200 characters.")
    private String content;
    @NotEmpty
    @Pattern(regexp = "politics|sports|technology", message = "Category must be either 'politics', 'sports' or 'technology'")
    private String category;
    @NotEmpty
    private String imageUrl;
    private boolean isPublished = false;
    private LocalDate publishDate;

}
