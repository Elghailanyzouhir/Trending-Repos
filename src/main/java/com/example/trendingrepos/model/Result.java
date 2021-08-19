package com.example.trendingrepos.model;

import java.util.List;

/**
 * Result model is used to display the results of this api
 **/
public class Result {
    private String language;
    private int numberOfRepos;
    private List<String> repoList;

    public Result(String language, int numberOfRepos, List<String> repoList) {
        this.language = language;
        this.numberOfRepos = numberOfRepos;
        this.repoList = repoList;
    }

    public int getNumberOfRepos() {
        return numberOfRepos;
    }

    public void setNumberOfRepos(int numberOfRepos) {
        this.numberOfRepos = numberOfRepos;
    }

    public List<String> getRepoList() {
        return repoList;
    }

    public void setRepoList(List<String> repoList) {
        this.repoList = repoList;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
