package com.example.news_article_management_system.Controller;

import com.example.news_article_management_system.Api.ApiResponse;
import com.example.news_article_management_system.Model.NewsArticle;
import com.example.news_article_management_system.Service.NewsArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/news")
@RequiredArgsConstructor
public class NewsArticleController {
    private final NewsArticleService newsArticleService;

    @GetMapping("/get")
    public ResponseEntity getAllNews() {
        ArrayList<NewsArticle> newsArticles = newsArticleService.getNewsArticles();
        return ResponseEntity.status(200).body(newsArticles);
    }

    @PostMapping("/add")
    public ResponseEntity addNews(@RequestBody @Valid NewsArticle newsArticle, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        if (newsArticleService.addNewsArticle(newsArticle)) {
            return ResponseEntity.status(200).body(new ApiResponse("Added"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Not Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateNews(@PathVariable String id,@RequestBody @Valid NewsArticle newsArticle, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        boolean isUpdated = newsArticleService.updateNewsArticle(id,newsArticle);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Updated"));

        }
        return ResponseEntity.status(400).body(new ApiResponse("Not Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteNews(@PathVariable String id) {
        if (newsArticleService.deleteNewsArticle(id)) {
            return ResponseEntity.status(200).body(new ApiResponse("Deleted"));

        }
        return ResponseEntity.status(400).body(new ApiResponse("Not Deleted"));
    }





}
