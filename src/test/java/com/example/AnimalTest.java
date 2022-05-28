package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalTest {
    private Animal animal;

    private final String family;
    private final List<String> food;

    public AnimalTest(String family, List<String> food) {
        this.family = family;
        this.food = food;
    }
    @Parameterized.Parameters
    public static Object[] getFamilyData() {
        return new Object[][] {
                { "Травоядное", List.of("Трава", "Различные растения")},
                { "Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }
    @Before
    public void setup(){
        animal = new Animal();
    }

    @Test
    public void getFoodPerFamily() throws Exception {
        Assert.assertEquals(food, animal.getFood(family));
    }

    @Test
    public void getFamily() {
        Assert.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }

    @Test(expected = Exception.class)
    public void familyException() throws Exception {
        animal.getFood("asd");
    }

}