package mohsen.morma.digikala.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mohsen.morma.digikala.repository.CheckoutRepository
import javax.inject.Inject

@HiltViewModel
class CheckoutVM @Inject constructor(private val repository: CheckoutRepository) : ViewModel() {


}