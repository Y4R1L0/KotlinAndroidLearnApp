import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class JokeRepository {

    private val apiService: JokeApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://icanhazdadjoke.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(JokeApiService::class.java)
    }

    fun getRandomJoke(): LiveData<JokeModel?> {
        val jokeLiveData = MutableLiveData<JokeModel?>()

        apiService.getRandomJoke().enqueue(object : Callback<JokeModel> {
            override fun onResponse(call: Call<JokeModel>, response: Response<JokeModel>) {
                if (response.isSuccessful) {
                    jokeLiveData.postValue(response.body())
                } else {
                    jokeLiveData.postValue(null)
                }
            }

            override fun onFailure(call: Call<JokeModel>, t: Throwable) {
                jokeLiveData.postValue(null)
            }
        })

        return jokeLiveData
    }
}
