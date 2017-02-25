package com.sandbox.service;

import com.sandbox.VO.PullwaveVO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mike on 2017/2/22.
 */
public interface PullWaveService {

    @GET("get.php?json=1&auth_usr=free_vi") // -> get.php?json=1&auth_usr=free_vip&w1=%E9%98%B4%E9%98%B3%E5%B8%88&w2=&end_date=2016-12-27
    Call<PullwaveVO> wave(@Query("w1") String word);
}
