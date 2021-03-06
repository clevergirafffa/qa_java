package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    Lion lion;

    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();
    @Mock
    Feline feline;

    private final String gender;
    private final boolean expectedGender;

    public LionParametrizedTest(String gender, boolean expectedGender) {
        this.gender = gender;
        this.expectedGender = expectedGender;
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Object[] getLionData() {
        return new Object[][] {
                { "Самец", true},
                { "Самка", false},
        };
    }

    @Test
    public void ifLionHasMane() throws Exception {
        lion = new Lion(gender, feline);
        Assert.assertEquals(expectedGender, lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void lionHasManeException() throws Exception {
        lion = new Lion("asd", feline);
    }

    @Test
    public void getFood() throws Exception {
        lion = new Lion("Самка", feline);
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(food);
       List<String> actualFood = lion.getFood();
        Assert.assertEquals(food, actualFood);
    }

    @Test
    public void getKittens() throws Exception {
        lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }
}
