package com.sandbox.utils;

import com.google.gson.Gson;
import com.sandbox.VO.PullwaveVO;
import retrofit2.Converter;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Created by mike on 2017/2/25.
 */
public class PullwaveConverter extends Converter.Factory{
    private static final Logger logger =  LoggerFactory.getLogger(PullwaveConverter.class);

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new Converter<ResponseBody, PullwaveVO>() {
            @Override
            public PullwaveVO convert(ResponseBody value) throws IOException {
                Gson gson = new Gson();
                PullwaveVO pullwaveVO = gson.fromJson(value.string(), PullwaveVO.class);
                logger.debug("Convert result => " + pullwaveVO.toString());
                pullwaveVO.getQushi().forEach(qushi -> {
                    logger.debug(qushi.toString());
                });
                return pullwaveVO;
            }
        };
    }
}
