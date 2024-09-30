import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class JokeRepository {

    private val apiService: JokeApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://icanhazdadjoke.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(JokeApiService::class.java)
    }

    suspend fun getRandomJoke(): JokeModel? {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getRandomJoke()
                response
            } catch (e: Exception) {
                null
            }
        }
    }
}
