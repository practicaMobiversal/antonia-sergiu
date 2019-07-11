package com.mobiversal.movieapp.movieappas.Network.response;

import com.google.gson.annotations.SerializedName;
import com.mobiversal.movieapp.movieappas.model.Movie;

import java.util.List;

public class MoviesResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int TotalResults;
    @SerializedName("total_pages")
    private int TotalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return TotalResults;
    }

    public void setTotalResults(int totalResults) {
        TotalResults = totalResults;
    }

    public int getTotalPages() {
        return TotalPages;
    }

    public void setTotalPages(int totalPages) {
        TotalPages = totalPages;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    private List<Movie> results;

}
