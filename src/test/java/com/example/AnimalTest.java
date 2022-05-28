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

    @Parameterized.Parameter(0)
    public String family;
    @Parameterized.Parameter(1)
    public List<String> food;
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