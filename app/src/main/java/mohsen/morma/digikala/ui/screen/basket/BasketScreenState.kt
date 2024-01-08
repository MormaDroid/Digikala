package mohsen.morma.digikala.ui.screen.basket

sealed class BasketScreenState<out T> {

    data class Success<T>(val data: T) : BasketScreenState<T>()

    data class Error(val message : Exception) :BasketScreenState<Nothing>()

    data object Loading : BasketScreenState<Nothing>()

}