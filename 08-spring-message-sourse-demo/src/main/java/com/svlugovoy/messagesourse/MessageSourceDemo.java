package com.svlugovoy.messagesourse;

import java.util.Locale;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageSourceDemo {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-xml.xml");
        ctx.refresh();

        Locale english = Locale.ENGLISH;
        Locale ital = new Locale("it", "IT");

        System.out.println(ctx.getMessage("msg", null, english));
        System.out.println(ctx.getMessage("msg", null, ital));

        System.out.println(ctx.getMessage("nameMsg", new Object[]{"Ivan", "Ivanov"}, english));
        System.out.println(ctx.getMessage("nameMsg", new Object[]{"Petr", "Petrov"}, "Petr Default", ital));
    }
}
