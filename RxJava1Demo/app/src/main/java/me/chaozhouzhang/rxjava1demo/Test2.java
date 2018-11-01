package me.chaozhouzhang.rxjava1demo;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created on 2018/10/24 17:09
 *
 * @author zhangchaozhou
 */
public class Test2 {


    public static void main(String[] args){
        /**
         * 打印数组
         */
        String[] names = new String[]{"zhang","chao","zhou"};
        Observable.from(names)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String name) {
                        System.out.println(name);
                    }
                });
    }
}
