package kr.ac.sunmoon.kiwoon.testretrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitAPI {
    @FormUrlEncoded
    @POST("/api/auth/signup")
    Call<messagePOST> getSignup(@Body messagePOST post);
}
