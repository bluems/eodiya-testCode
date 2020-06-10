package kr.ac.sunmoon.kiwoon.testretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit mRetrofit;
    private RetrofitAPI mRetrofitAPI;
    private Call<String> mCallMovieList;
    private TextView tvTmpText;
    private Button testBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRetrofitinit();
        tvTmpText = findViewById(R.id.tmpText);
        tvTmpText.setText(getString(R.string.baseUrl));
        testBtn = findViewById(R.id.btnTest);
        testBtn.setOnClickListener(v -> callSignup());

    }

    private void setRetrofitinit() {
        mRetrofit = new Retrofit.Builder().baseUrl(getString(R.string.baseUrl)).addConverterFactory(GsonConverterFactory.create()).build();
        mRetrofitAPI = mRetrofit.create(RetrofitAPI.class);
    }

    private void callSignup() {
        messagePOST post = new messagePOST("test1234", "12345678", "tmpUser1234");

        Call<messagePOST> call = mRetrofitAPI.getSignup(post);
        call.enqueue(new Callback<messagePOST>() {
            @Override
            public void onResponse(Call<messagePOST> call, Response<messagePOST> response) {
                if(!response.isSuccessful()) {
                    Log.d("Activity", "Code: " + response.code());
                    return ;
                }
            }

            @Override
            public void onFailure(Call<messagePOST> call, Throwable t) {

            }
        });
    }

    private Callback<String> mRetrofitCallback = new Callback<String>() {

        @Override
        public void onResponse(Call<String> call, Response<String> response) {
            String result = response.body();
            Log.d("Retrofit Test", result);
        }

        @Override
        public void onFailure(Call<String> call, Throwable t) {
            t.printStackTrace();
        }
    };
}
