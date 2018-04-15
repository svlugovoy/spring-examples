package com.svlugovoy.initdestroy;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SimpleBean implements InitializingBean, DisposableBean {

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //init - first
    @PostConstruct
    public void someMethod() {
        System.out.println("@PostConstruct... " + name);
    }

    //init - second
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("@Override afterPropertiesSet()... " + name);
    }

    //init - third
    public void init() {
        System.out.println("init-method in xml... " + name);
    }

    //destroy - first, no for scope="prototype"
    @PreDestroy
    public void someMethod1() {
        System.out.println("@PreDestroy... " + name);
    }

    //destroy - second, no for scope="prototype"
    @Override
    public void destroy() throws Exception {
        System.out.println("@Override destroy()... " + name);
    }

    //destroy - third, no for scope="prototype"
    public void destroy1() {
        System.out.println("destroy-method in xml... " + name);
    }

    public String toString() {
        return "Name: " + name + " Age: " + age;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-xml.xml");
        ctx.refresh();
        System.out.println("----------------------");
        SimpleBean simpleBean1 = (SimpleBean) ctx.getBean("simpleBean1");
        SimpleBean simpleBean2 = (SimpleBean) ctx.getBean("simpleBean2");
        System.out.println("----------------------");
        System.out.println(simpleBean1);
        System.out.println(simpleBean2);

        System.out.println("----------------------");
        ctx.close();

    }


}
