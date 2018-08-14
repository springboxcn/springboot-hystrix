package edu.maskleo.simplehystrix;

import rx.Observable;

import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        String s1 = new CommandHelloWorld("Bob").execute();
        Future<String> s2 = new CommandHelloWorld("Bob").queue();
        Observable<String> s3 = new CommandHelloWorld("Bob").observe();
    }

}
