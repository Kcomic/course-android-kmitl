package kmitl.lab07.bawonsak58070074.lazyinstagram.Api;

import kmitl.lab07.bawonsak58070074.lazyinstagram.Model.UserProfile;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by student on 10/17/2017 AD.
 */

public interface LazyInstagramApi {
    String BASE_URL = "https://us-central1-retrofit-course.cloudfunctions.net";

    @GET("/getProfile")
    Call<UserProfile> getProfile(@Query("user") String userName);
}
