package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;


public class CatTest {

    private Cat cat;


    private Feline feline = new Feline() ;

    @Before
    public void setup(){
        cat = new Cat(feline);
    }


    @Test
    public void getSound(){
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFood() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
       List<String> actualFood = cat.getFood();
       Assert.assertEquals(food, actualFood);
    }
}