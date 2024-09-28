import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface JokeApiService {
    @Headers("Accept: application/json")
    @GET("/")
    fun getRandomJoke(): Call<JokeModel>
}

