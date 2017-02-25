package com.sandbox.controller;

import com.sandbox.VO.PullwaveVO;
import com.sandbox.VO.Sandbox;
import com.sandbox.service.PullWaveService;
import com.sandbox.utils.PullwaveConverter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mike on 2017/2/19.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final Logger logger =  LoggerFactory.getLogger(HelloController.class);

    @Value("${hello.name}")
    private String name;

    @RequestMapping("/")
    @ResponseBody
    public Map<String, Object> sayHi() throws Exception{
        logger.debug("logger test in hello.class");
        Map<String, Object> result = new HashMap<>();
        result.put("a", 11);
        result.put("b", "hello");
        return result;
    }

    @RequestMapping("/error")
    @ResponseBody
    public String testError() throws Exception{
        throw new Exception("发生错误.");
    }

    @RequestMapping("/iv")
    public String injectValue(){
        return String.format("hello, %s", name);
    }

    @RequestMapping("/r2")
    public Sandbox fetch() throws Exception {
        Sandbox sandbox = new Sandbox();
        sandbox.setMsg("Retrofit.test");
        OkHttpClient okhttpClient = new OkHttpClient();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okhttpClient = okhttpClient.newBuilder().addInterceptor(logging).build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okhttpClient)
                .addConverterFactory(new PullwaveConverter())
                .baseUrl("http://pullwave.com/")
                .build();
        PullWaveService pullWaveService = retrofit.create(PullWaveService.class);
        Call<PullwaveVO> call = pullWaveService.wave("CEO");
//        // 异步请求
//        call.enqueue(new Callback<PullwaveVO>() {
//            @Override
//            public void onResponse(Call<PullwaveVO> call, Response<PullwaveVO> response) {
//                logger.debug(String.format("Retrofit Response => %s", response));
//                logger.info(String.format("Body => %s", response.body().toString()));
//            }
//            @Override
//            public void onFailure(Call<PullwaveVO> call, Throwable t) {
//                logger.error("Pullwave failure.");
//            }
//        });
        Response<PullwaveVO> response = call.execute();
        ModelMap modelMap = new ModelMap();
        modelMap.put("data", response.body());
        modelMap.put("meta", "retrofit2");
        sandbox.setResult(modelMap);
        return sandbox;
    }

}
