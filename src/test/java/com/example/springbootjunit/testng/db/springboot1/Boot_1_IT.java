package com.example.springbootjunit.testng.db.springboot1;

import com.example.springbootjunit.dao.FooRepository;
import com.example.springbootjunit.pojo.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@SpringBootTest
@SpringBootApplication(scanBasePackageClasses = FooRepository.class)
public class Boot_1_IT extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private FooRepository fooRepository;


    @BeforeMethod
    public void creat() {
        this.fooRepository.create();
    }

    @AfterMethod
    public void drop(){
        fooRepository.drop();
    }

    @Test
    public void testSave() {
        Foo foo = new Foo();
        foo.setName("Bob");
        this.fooRepository.save(foo);

        assertEquals(countRowsInTable("FOO"), 1);
        countRowsInTableWhere("FOO", "name = 'Bob'");
    }

    @Test(dependsOnMethods = "testSave")
    public void testDelete() {

        assertEquals(countRowsInTable("FOO"), 0);

        Foo foo = new Foo();
        foo.setName("Bob");
        this.fooRepository.save(foo);

        this.fooRepository.delete(foo.getName());
        assertEquals(countRowsInTable("FOO"), 0);

    }


}
