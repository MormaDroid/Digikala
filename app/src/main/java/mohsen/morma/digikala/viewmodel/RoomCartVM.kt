package mohsen.morma.digikala.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mohsen.morma.digikala.repository.RoomCartRepository
import javax.inject.Inject

@HiltViewModel
class RoomCartVM @Inject constructor(private val repository: RoomCartRepository) : ViewModel() {

}