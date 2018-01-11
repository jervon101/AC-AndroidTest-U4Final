package nyc.c4q.androidtest_unit4final.api;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jervon.arnoldd on 1/10/18.
 */

public interface Stuff {

    String BASE_URL= " https://raw.githubusercontent.com/";

    @GET("operable/cog/master/priv/css-color-names.json")
    Call<HashMap<String,String>> getcall();
//
}
