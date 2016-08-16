package com.esgi.person.utils;

import com.esgi.utils.SearchUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class PersonUtilsTest {
    private SearchUtils personUtils = new SearchUtils();

    @Test
    public void should_equals() {
        String search = "Frank";
        personUtils.setResearch(search);

        assertThat(personUtils.getResearch(),is("Frank"));
    }
}
