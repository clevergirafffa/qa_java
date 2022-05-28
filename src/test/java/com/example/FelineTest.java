package com.example;

import org.junit.Assert;
import org.junit.Test;


public class FelineTest {
    private Feline feline = new Feline();

    @Test
    public void getFamily() {
        Assert.assertEquals("Feline family isn't matching", "Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensNoArguments() {
        Assert.assertEquals("Feline's amount of kittens differs from 1", 1, feline.getKittens());
    }

    @Test
    public void getKittensWithArguments() {
        Assert.assertEquals("Feline's amount of kittens isn't matching", 6, feline.getKittens(6));
    }
}