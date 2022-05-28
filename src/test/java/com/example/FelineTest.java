package com.example;

import org.junit.Assert;
import org.junit.Test;


public class FelineTest {
    private Feline feline = new Feline();

    @Test
    public void getFamily() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensNoArguments() {
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithArguments() {
        Assert.assertEquals(6, feline.getKittens(6));
    }
}