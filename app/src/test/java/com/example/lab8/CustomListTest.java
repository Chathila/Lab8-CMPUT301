package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return list
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan","SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void deleteCityTest(){
        list = MockCityList();
        City Edmonton = new City("Edmonton","AB");
        City Vancouver = new City("Vancouver","BC");
        City Estevan = new City("Estevan","SK");
        list.addCity(Edmonton);
        list.addCity(Vancouver);
        list.addCity(Estevan);
        int listSize = list.getCount();
        list.deleteCity(Estevan);
        assertEquals(list.getCount(),listSize - 1);
        assertTrue(list.cityExists(Edmonton));
        assertTrue(list.cityExists(Vancouver));
        assertFalse(list.cityExists(Estevan));
    }

}
