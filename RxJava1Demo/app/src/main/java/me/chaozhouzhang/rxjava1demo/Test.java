package me.chaozhouzhang.rxjava1demo;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created on 2018/10/24 16:49
 *
 * @author zhangchaozhou
 */
public class Test {


    public static void main(String[] args) {


        /**
         * 观察者
         */

        Observer<String> observer = new Observer<String>() {

            @Override
            public void onNext(String s) {
                System.out.println("Item: " + s);
            }

            @Override
            public void onCompleted() {
                System.out.println("Completed!");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Error!");
            }
        };


        Subscriber<String> subscriber = new Subscriber<String>() {

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onNext(String s) {
                System.out.println("Item: " + s);
            }

            @Override
            public void onCompleted() {
                System.out.println("Completed!");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Error!");
            }
        };


        Action1<String> onNextAction = new Action1<String>() {
            // onNext()
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        };
        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            // onError()
            @Override
            public void call(Throwable throwable) {
                // Error handling
                System.out.println(throwable.getMessage());
            }
        };
        Action0 onCompletedAction = new Action0() {
            // onCompleted()
            @Override
            public void call() {
                System.out.println("onCompleted");
            }
        };




        /**
         * 被观察者
         */
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("Hi");
                subscriber.onNext("Aloha");
                subscriber.onCompleted();
            }
        });

        Observable observableJust = Observable.just("Hello", "Hi", "Aloha");

        String[] words = {"Hello", "Hi", "Aloha"};
        Observable observableFrom = Observable.from(words);





        /**
         * 订阅
         */
        observable.subscribe(observer);
        observable.subscribe(subscriber);
        observable.subscribe(onNextAction);
        observable.subscribe(onNextAction,onErrorAction);
        observable.subscribe(onNextAction,onErrorAction,onCompletedAction);
        observableJust.subscribe(observer);
        observableFrom.subscribe(observer);


    }
}
