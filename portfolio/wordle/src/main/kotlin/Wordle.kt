// Implement the six required functions here
import java.io.File
import kotlin.random.Random
import kotlin.system.exitProcess

fun isValid(word: String): Boolean{
    // Returns true if the given word is valid in Wordle (i.e. it consists of exactly 5 letters)
    if (word.length == 5){
        return true
    }
    else{
        return false
    }
}

fun readWordList(filename: String): MutableList<String>{
    // Reads Wordle target words from the specified file, returning them as a list of strings
    var words: MutableList<String> = mutableListOf()
    File("../../../data/$filename").forEachLine {words.add(it.toString())}
    return words
}

fun pickRandomWord(words: MutableList<String>): String{
    var lengthOfList = (words.count() + 1).toInt()
    val randomIndex = Random.nextInt(0, lengthOfList)
    words.removeAt(randomIndex)
    val randomWord = words.get(randomIndex)
    return randomWord
}

fun obtainGuess(attempt: Int): String{
    print("Guess $attempt : ")
    val input = (readLine() ?: "").uppercase()
    if (isValid(input) == true){
        return input
    }
    else{
        println("Invalid Guess! Guess should be exactly 5 letters long...")
        return obtainGuess(attempt)
    }
}

fun evaluateGuess(guess: String, target: String): List<Int>{
    val target = target.toList()
    val guess = guess.toList()
    var resultingComparison: MutableList<Int> = mutableListOf()

    for ((index, value) in guess.withIndex()) {
        if (value == target.elementAt(index)){
            resultingComparison.add(1)
        }
        else{
            resultingComparison.add(0)
        }
    }
    return resultingComparison
}

fun displayGuess(guess: String, matches: List<Int>){
    var guessFeedback: MutableList<Char> = mutableListOf()
    for ((index, value) in matches.withIndex()) {
        if (value == 1){
            guessFeedback.add(guess.elementAt(index))
        }
        else {
            guessFeedback.add('?')
        }
    }

    println(guessFeedback)
}

fun main(){
    val words = readWordList("words.txt")
    val randomWord = pickRandomWord(words)
    
    var attemptNum = 0
    while (attemptNum <= 10){
        var guess = obtainGuess(attemptNum)
        attemptNum++

        var comparisonResult = evaluateGuess(guess, randomWord)
        displayGuess(guess, comparisonResult)
    
        if (comparisonResult.all {it == 1}){
            println("Congratulations! You have successfully guessed the word!")
            exitProcess(0)
        }
    }
    println("Sorry! You've ran out of guesses to guess the correct word! The correct word was $randomWord")
    exitProcess(0)

}