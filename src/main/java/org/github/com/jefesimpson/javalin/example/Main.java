package org.github.com.jefesimpson.javalin.example;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create();
        app.get("/", context -> {
            methodAndHeaderOfClient(context);
            context.result("Hello World!");
        });
        app.get("/helloworld", Main::helloWorld);
        app.start(9090);
    }
    public static void helloWorld(Context context){
        methodAndHeaderOfClient(context);
        context.result("Hello World!!!");
    }
    public static void methodAndHeaderOfClient(Context context){
        System.out.println("header from client: ");
        System.out.println(context.headerMap());
        System.out.println("method from client: ");
        System.out.println(context.method());
    }
}
