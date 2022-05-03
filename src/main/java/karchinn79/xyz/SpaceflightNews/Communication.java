package karchinn79.xyz.SpaceflightNews;

import karchinn79.xyz.SpaceflightNews.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

 
public class Communication {
    @Autowired
    private RestTemplate restTemplate;
    private final String webURL = "https://api.spaceflightnewsapi.net/v3/articles";
    private final String LIMITPARAM = "?_limit=";
    private final String SKIPPARAM = "&_start=";

    public List<Article> getArticles (int limit, int skips){
        String URL;
        if(limit > 0 && skips > 0){
            URL = webURL + LIMITPARAM + limit + SKIPPARAM + skips;
        }
        else{
            URL = webURL;
        }
        ResponseEntity<List<Article>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Article>>() {});
        List<Article> allArticles = responseEntity.getBody();

        return allArticles;
    }

    public Article getArticle(int id){
        return null;
    }
    public void saveArticle(Article article){

    }
    public void removeArticle(int id){

    }
}

