package com.benz.main;

import com.benz.main.retrofitdemo.GetRequest;
import com.benz.main.retrofitdemo.PostRequest;

/**
 * Created by zfg on 2017/3/23.
 */
public class ClassMain {
    public static void main(String[] args) {
        //GetRequest getRequest = new GetRequest();
        //getRequest.request();

        PostRequest postRequest = new PostRequest();
        postRequest.request();

    }
}
