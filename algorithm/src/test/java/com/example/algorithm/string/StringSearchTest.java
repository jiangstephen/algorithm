package com.example.algorithm.string;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringSearchTest {
	
    @Parameters(name = "{0} search")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
        	{"Naive", new NaiveSearch()},
        	{"Robin Karp", new RobinKarpSearch()},
        	{"FiniteAutomata", new FiniteAutomataSearch()}
        	});
    }

    private Search testee;


    public StringSearchTest(String name, Search testee) {
        this.testee = testee;
    }

    @Test
    public void test() {
        Assert.assertEquals(-1, testee.indexOf("abc", "a"));
        Assert.assertEquals(0, testee.indexOf("abc", "abcabc"));
        Assert.assertEquals(5, testee.indexOf("abc", "bbcadabc"));
        Assert.assertEquals(5, testee.indexOf("abc", "bbcadabcdefeg"));
        "abc".indexOf("abc");
    }

}
