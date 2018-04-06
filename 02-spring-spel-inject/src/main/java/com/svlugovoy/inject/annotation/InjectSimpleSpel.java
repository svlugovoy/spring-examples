package com.svlugovoy.inject.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimpleSpel")
public class InjectSimpleSpel {
    @Value("#{injectSimpleConfig.name} Petrovich")
    private String name;

    @Value("#{injectSimpleConfig.age + 10}")
    private int age;

    @Value("#{injectSimpleConfig.height}")
    private float height;

    @Value("false")
    private boolean programmer;

    @Value("#{injectSimpleConfig.ageInSeconds}")
    private Long ageInSeconds;

    public String toString() {
        return "Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "Age in Seconds: " + ageInSeconds + "\n"
                + "Height: " + height + "\n"
                + "Is Programmer?: " + programmer;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();

        InjectSimpleConfig simple0 = ctx.getBean(InjectSimpleConfig.class);
        InjectSimpleSpel simple1 = (InjectSimpleSpel)ctx.getBean("injectSimpleSpel");

        System.out.println(simple0);
        System.out.println(simple1);
    }
}

