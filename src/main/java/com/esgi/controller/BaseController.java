package com.esgi.controller;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.Reader;

/**
 * Class BaseController
 */
abstract class BaseController {

    @Value("${moviereviewer.webservice.url}")
    protected String URL_API;
    @Value("${moviereviewer.webservice.params.query}")
    protected String URL_GET_SEARCH;
    @Value("${moviereviewer.webservice.params.filter}")
    protected String URL_GET_FILTER;

    // Filters
    protected static final String FILTER_MOVIE = "movie";
    protected static final String FILTER_PERSON = "person";

    protected String parseJsonFromReader(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
