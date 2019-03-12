package com.app.tests;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersDemo {
    // Hamcrest library provides matchers (assertion method)
    // Rest Assured uses hamcrest assertions (matchers)
    // works with both junit and testng

    @Test
    public void test(){
        assertThat(1, equalTo(1));
        String str1 = "Kunkka";
        String str2 = "Kunkka";
        // verify if first argument is equal to the second
        assertThat(str1, is("Kunkka"));
        assertThat(str1, is(str2));

        // verify if first argument is NOT equal to the second

        assertThat(str1, is(not("Tidehunter")));

        // compare ignoring case
        assertThat(str1, equalToIgnoringCase("kunkka"));

        // compare ignoring space before and after
        assertThat(str1, equalToIgnoringWhiteSpace(" Kunkka "));

        // compare numbers
        assertThat(10, greaterThan(9));
        assertThat(10, lessThan(11));
        assertThat(10, lessThanOrEqualTo(11));

        // CMD+D  duplicate line
        // CTRL+D duplicate line

        // verify not null
        assertThat(str1, notNullValue());

        List<String> list = Arrays.asList("one", "too", "tree");

        assertThat(list, hasSize(3));

        assertThat(list, containsInAnyOrder("too", "tree", "one"));

        assertThat(list, hasItems("one", "too"));

        List<Integer> numbers = Arrays.asList(11, 12, 13);
        assertThat(numbers, everyItem(greaterThan(9)));

    }

}
