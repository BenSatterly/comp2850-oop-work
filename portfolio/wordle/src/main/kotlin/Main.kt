import kotlin.system.exitProcess

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