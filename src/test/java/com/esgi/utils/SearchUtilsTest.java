package com.esgi.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class SearchUtilsTest {
    private SearchUtils searchUtils = new SearchUtils();

    @Test
    public void should_equals() {
        String search = "Frank";
        searchUtils.setResearch(search);

        assertThat(searchUtils.getResearch(),is("Frank"));
    }
}
