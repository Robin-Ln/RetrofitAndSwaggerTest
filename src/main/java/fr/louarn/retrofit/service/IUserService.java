package fr.louarn.retrofit.service;

import fr.louarn.retrofit.modele.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface IUserService {

    @GET(value = "/users")
    Call<List<User>> getUsersByPage(
            @Query("per_page") Integer per_page,
            @Query("page") Integer page
    );

    @GET(value = "/users")
    Call<List<User>> getUsers();

    @GET(value = "/users/{username}")
    Call<User> getUser(@Path("username") String userName);
}
