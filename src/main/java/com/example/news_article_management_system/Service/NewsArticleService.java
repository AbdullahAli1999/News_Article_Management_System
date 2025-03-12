package com.example.news_article_management_system.Service;

import com.example.news_article_management_system.Model.NewsArticle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NewsArticleService {
    ArrayList<NewsArticle> newsArticles = new ArrayList<>();

    //GET
    public ArrayList<NewsArticle> getNewsArticles() {
        return newsArticles;
    }

    public boolean addNewsArticle(NewsArticle newsArticle) {
        for (int i = 0; i < newsArticles.size(); i++) {
            NewsArticle newsArticle1 = newsArticles.get(i);
            if (newsArticle1.getId().equals(newsArticle.getId())) {
                return false;
            }
        }
        newsArticles.add(newsArticle);
        return true;
    }

    public boolean updateNewsArticle(String id , NewsArticle newsArticle) {
        for (int i = 0; i < newsArticles.size(); i++) {
            if(newsArticles.get(i).getId().equalsIgnoreCase(id)){
                newsArticles.set(i,newsArticle);
                return true;
            }
        }
        return false;

    }

    public boolean deleteNewsArticle(String id) {
        for (int i = 0; i < newsArticles.size(); i++) {
            if (newsArticles.get(i).getId().equalsIgnoreCase(id)) {
                newsArticles.remove(i);
                return true;

            }
        }
        return false;
    }


}
