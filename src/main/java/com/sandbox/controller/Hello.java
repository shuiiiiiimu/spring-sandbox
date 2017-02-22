package com.sandbox.controller;

import com.sandbox.service.PullWaveService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mike on 2017/2/19.
 */
@RestController
@RequestMapping("/hello")
public class Hello {

    private static final Logger logger =  LoggerFactory.getLogger(Hello.class);

    @Value("${hello.name}")
    private String name;

    @RequestMapping("/")
    @ResponseBody
    public Map<String, Object> sayHi(){
        logger.debug("logger test in hello.class");
        Map<String, Object> result = new HashMap<>();
        result.put("a", 11);
        result.put("b", "hello");
        return result;
    }

    @RequestMapping("/iv")
    public String injectValue(){
        return String.format("hello, %s", name);
    }

    @RequestMapping("/git")
    public String fetchGitUsers() {
        String result = "Retrofit.test";

        OkHttpClient okhttpClient = new OkHttpClient();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okhttpClient = okhttpClient.newBuilder().addInterceptor(logging).build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okhttpClient)
                .baseUrl("http://pullwave.com/")
                .build();
        PullWaveService pullWaveService = retrofit.create(PullWaveService.class);
        Call<okhttp3.ResponseBody> call = pullWaveService.wave("CEO");
        call.enqueue(new Callback<okhttp3.ResponseBody>() {
            @Override
            public void onResponse(Call<okhttp3.ResponseBody> call, Response<okhttp3.ResponseBody> response) {
                logger.debug(String.format("Retrofit Response => %s", response));
                logger.info(String.format("Body => %s", response.body()));
            }
            @Override
            public void onFailure(Call<okhttp3.ResponseBody> call, Throwable t) {}
        });
        return result;
    }

}
