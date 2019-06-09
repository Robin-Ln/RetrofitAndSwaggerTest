package fr.louarn.retrofit;

import fr.louarn.retrofit.modele.User;
import fr.louarn.retrofit.service.IUserService;
import okhttp3.OkHttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RetrofitApplicationTests {

    @Test
    public void testCallSync() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();


        IUserService service = retrofit.create(IUserService.class);
        Call<User> callSync = service.getUser("eugenp");

        try {
            Response<User> response = callSync.execute();
            User users = response.body();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testCallAsync() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();


        IUserService service = retrofit.create(IUserService.class);
        Call<User> callAsync = service.getUser("eugenp");

        callAsync.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
            }

            @Override
            public void onFailure(Call<User> call, Throwable throwable) {
                System.out.println(throwable);
            }
        });
    }

}
