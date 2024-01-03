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
    fun digitByClockSeparator(time: Int) : String{

        val hour = time / 3600
        val minute = ((time % 3600)/60)
        val second = ((time % 3600 % 60))

        val digitHour = if (hour<10) "0$hour" else hour.toString()
        val digitMinute = if (minute<10) "0$minute" else minute.toString()
        val digitSecond = if (second<10) "0$second" else second.toString()

        return "$digitHour:$digitMinute:$digitSecond"

    }

    fun applyDiscount(price:Int , discount:Int):String{
        return (price-(price * discount) / 100).toString()
    }

    fun digitBySeparatorAndLocate(number: String) : String {
        val locateNumber = digitByLocate(number)
        return digitBySeparator(locateNumber)
    }

}