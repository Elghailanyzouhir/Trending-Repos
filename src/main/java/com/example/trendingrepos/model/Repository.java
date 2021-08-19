package com.example.trendingrepos.model;

/*
 * Repository model is used to handle the list of items in the response of the git api
 **/
public class Repository {
    private final String name;
    private final String language;
    private final String git_url;

    public Repository(String name, String language, String git_url) {
        this.name = name;
        this.language = language;
        this.git_url = git_url;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getGit_url() {
        return git_url;
    }
}
