package mohsen.morma.digikala.util

import java.text.DecimalFormat

object DigitHelper {

    fun digitByLocate(number: String): String {

        if (Constants.USER_LANG == Constants.PERSIAN_LANG){
            var newNumber = ""
            number.forEach {
                when (it) {
                    '0' -> {
                        newNumber += '۰'
                    }
                    '1' -> {
                        newNumber += '۱'
                    }
                    '2' -> {
                        newNumber += '۲'
                    }
                    '3' -> {
                        newNumber += '۳'
                    }
                    '4' -> {
                        newNumber += '۴'
                    }
                    '5' -> {
                        newNumber += '۵'
                    }
                    '6' -> {
                        newNumber += '۶'
                    }
                    '7' -> {
                        newNumber += '۷'
                    }
                    '8' -> {
                        newNumber += '۸'
                    }
                    '9' -> {
                        newNumber += '۹'
                    }
                    else -> {newNumber +=it}
                }
            }
            return newNumber
        }

        return number


    }

    private fun digitBySeparator(number: String) : String = DecimalFormat("###,###").format(Integer.valueOf(number))

    fun applyDiscount(price:Int , discount:Int):String{
        return (price-(price * discount) / 100).toString()
    }

    fun calculateDiscount(price:Int,discount:Int) = ((price *discount)/100)



    fun digitBySeparatorAndLocate(number: String) : String {
        val locateNumber = digitByLocate(number)
        return digitBySeparator(locateNumber)
    }

}