package com.example.trendingrepos.controller;


import com.example.trendingrepos.model.ApiResponseModel;
import com.example.trendingrepos.model.Repository;
import com.example.trendingrepos.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


@RestController
public class TrendingReposController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/trendingRepos")
    public List<Result>  getTrendingRepos(){

        //-Format today date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());

        //-Get the trending repositories from the git api
        ApiResponseModel trendingRepos = restTemplate.getForObject("https://api.github.com/search/repositories?q="+date+"&sort=stars&order=desc", ApiResponseModel.class);


        //-Build a map of the language and the list of repositories using this language
        assert trendingRepos != null;
        Map<String, List<String>> resultMap =
                trendingRepos.getItems()
                        .stream()
                        .filter(repo -> repo.getLanguage() != null)
                        .collect(Collectors.toList())
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Repository::getLanguage,
                                        Collectors.mapping(Repository::getGit_url, Collectors.toList()))
                        );

        //-Build the List of results
        return resultMap.keySet()
                .stream()
                .map(
                        key -> new Result(key,resultMap.get(key).size(),resultMap.get(key))
                ).collect(Collectors.toList());
    }
}

