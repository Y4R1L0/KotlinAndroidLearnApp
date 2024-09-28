import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class JokeViewModel : ViewModel() {

    private val repository = JokeRepository()

    fun getJoke(): LiveData<JokeModel?> {
        return repository.getRandomJoke()
    }
}
