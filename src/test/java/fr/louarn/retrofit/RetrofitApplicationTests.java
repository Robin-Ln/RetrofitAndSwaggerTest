package fr.louarn.retrofit;

import fr.louarn.retrofit.config.retrofit.GitHubServiceGenerator;
import fr.louarn.retrofit.modele.User;
import fr.louarn.retrofit.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RetrofitApplicationTests {

    @Test
    public void testCallSync() {

        IUserService service = GitHubServiceGenerator.createService(IUserService.class);
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

        IUserService service = GitHubServiceGenerator.createService(IUserService.class);
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
