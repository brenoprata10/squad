package br.com.cabal.squardsippe.modelo;

import org.junit.Before;
import org.junit.Test;
import org.reflections.Reflections;

import java.io.Serializable;
import java.util.Set;

public class ModelTest {

    Set<Class<? extends Serializable>> allClasses;
    GetterAndSetterTester tester;

    @Before
    public void setUp() {
        tester = new GetterAndSetterTester();
        Reflections reflections = new Reflections("br.com.cabal.squadsippe.model.*");
        allClasses = reflections.getSubTypesOf(Serializable.class);
    }

    @Test
    public void testarTodasEntidades() {
        for (Class<? extends Object> clazz : allClasses)
            tester.testClass(clazz);
    }
}
