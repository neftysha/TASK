//ZADACHI1.TXT

/* Задача1
fun main() {
    print("Введите число: ")
    val num = readLine()!!.toInt()
    if (num % 2 == 0) {
        println("$num четное")
    } else {
        println("$num нечетное")
    }
}

// Задача2
fun main() {
    print("Введите первое число: ")
    val num1 = readLine()!!.toInt()
    print("Введите второе число: ")
    val num2 = readLine()!!.toInt()
    print("Введите третье число: ")
    val num3 = readLine()!!.toInt()

    val min = minOf(num1, num2, num3)
    println("Минимальное число: $min")
}

//Задача3
fun main() {
    for (i in 1..10) {
        println("5 * $i = ${5 * i}")
    }
}

//Задача4
fun main() {
    print("Введите число N: ")
    val N = readLine()!!.toInt()
    val sum = (1..N).sum()
    println("Сумма чисел от 1 до $N: $sum")
}

//Задача5
fun main() {
    print("Введите число N: ")
    val N = readLine()!!.toInt()
    var a = 0
    var b = 1
    for (i in 1..N) {
        print("$a ")
        val temp = a
        a = b
        b = temp + b
    }
}

//Задача6
fun main() {
    print("Введите число: ")
    val num = readLine()!!.toInt()
    var isPrime = true
    if (num <= 1) isPrime = false
    for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) {
            isPrime = false
            break
        }
    }
    if (isPrime) {
        println("$num простое число")
    } else {
        println("$num не простое число")
    }
}

//Задача7
fun main() {
    print("Введите число: ")
    val num = readLine()!!.toInt()
    for (i in num downTo 1) {
        print("$i ")
    }
}

//Задача8
fun main() {
    print("Введите первое число A: ")
    val A = readLine()!!.toInt()
    print("Введите второе число B: ")
    val B = readLine()!!.toInt()
    var sum = 0
    for (i in A..B) {
        if (i % 2 == 0) sum += i
    }
    println("Сумма четных чисел в диапазоне от $A до $B: $sum")
}

//Задача9
fun main() {
    print("Введите строку: ")
    val str = readLine()!!
    println("Обратная строка: ${str.reversed()}")
}

//Задача10
fun main() {
    print("Введите число: ")
    val num = readLine()!!.toInt()
    val count = num.toString().length
    println("Количество цифр в числе: $count")
}

//Задача11
fun main() {
    print("Введите число N: ")
    val N = readLine()!!.toInt()
    var factorial = 1
    for (i in 1..N) {
        factorial *= i
    }
    println("Факториал числа $N: $factorial")
}

//Задача12
fun main() {
    print("Введите число: ")
    val num = readLine()!!.toInt()
    val sum = num.toString().map { it.toString().toInt() }.sum()
    println("Сумма цифр числа: $sum")
}

//Задача13
fun main() {
    print("Введите строку: ")
    val str = readLine()!!
    if (str == str.reversed()) {
        println("Строка является палиндромом")
    } else {
        println("Строка не является палиндромом")
    }
}

//Задача14
fun main() {
    print("Введите размер массива: ")
    val size = readLine()!!.toInt()
    val arr = IntArray(size)
    for (i in 0 until size) {
        print("Введите элемент массива: ")
        arr[i] = readLine()!!.toInt()
    }
    val max = arr.maxOrNull() ?: 0
    println("Максимальное число в массиве: $max")
}

//Задача15
fun main() {
    print("Введите размер массива: ")
    val size = readLine()!!.toInt()
    val arr = IntArray(size)
    for (i in 0 until size) {
        print("Введите элемент массива: ")
        arr[i] = readLine()!!.toInt()
    }
    val sum = arr.sum()
    println("Сумма всех элементов массива: $sum")
}

//Задача16
fun main() {
    print("Введите размер массива: ")
    val size = readLine()!!.toInt()
    val arr = IntArray(size)
    var positive = 0
    var negative = 0
    for (i in 0 until size) {
        print("Введите элемент массива: ")
        arr[i] = readLine()!!.toInt()
        if (arr[i] > 0) positive++ else if (arr[i] < 0) negative++
    }
    println("Положительных чисел: $positive, отрицательных чисел: $negative")
}

//Задача17
fun main() {
    print("Введите первое число A: ")
    val A = readLine()!!.toInt()
    print("Введите второе число B: ")
    val B = readLine()!!.toInt()

    for (num in A..B) {
        var isPrime = true
        if (num <= 1) continue
        for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
            if (num % i == 0) {
                isPrime = false
                break
            }
        }
        if (isPrime) println(num)
    }
}
//Задача18
fun main() {
    print("Введите строку: ")
    val str = readLine()!!.toLowerCase()
    var vowels = 0
    var consonants = 0
    for (char in str) {
        if (char in "аеёиоуыэюя") vowels++
        else if (char in "бвгдежзйклмнопрстфхцчшщ") consonants++
    }
    println("Гласных: $vowels, Согласных: $consonants")
}

 //Задача19
 fun main() {
    print("Введите строку: ")
    val str = readLine()!!
    val reversed = str.split(" ").reversed().joinToString(" ")
    println("Переставленные слова: $reversed")
}
 */


//Задача20
fun main() {
    print("Введите число: ")
    val num = readLine()!!.toInt()
    val digits = num.toString().length
    val sum = num.toString().map { Math.pow(it.toString().toDouble(), digits.toDouble()).toInt() }.sum()
    if (sum == num) {
        println("$num — это число Армстронга")
    } else {
        println("$num — это не число Армстронга")
    }
}











