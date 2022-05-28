package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.List;

public class CatTest {
    private Cat cat;
    @Mock
    private Feline feline;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setup() {
        cat = new Cat(feline);
    }

    @Test
    public void getSound() {
        Assert.assertEquals("Cat's sound isn't matching", "Мяу", cat.getSound());
    }

    @Test
    public void getFood() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(food);
        List<String> actualFood = cat.getFood();
        Assert.assertEquals("Cat's food isn't matching", food, actualFood);
    }
}