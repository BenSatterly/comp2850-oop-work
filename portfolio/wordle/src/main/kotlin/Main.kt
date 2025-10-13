import kotlin.system.exitProcess

fun main(){
    val words = readWordList("words.txt")
    val randomWord = pickRandomWord(words)
    const val correctLetterMatch = 1

    var attemptNum = 0
    const val maxGuesses = 10

    while (attemptNum <= maxGuesses){
        var guess = obtainGuess(attemptNum)
        attemptNum++

        var comparisonResult = evaluateGuess(guess, randomWord)
        displayGuess(guess, comparisonResult)
    
        if (comparisonResult.all {it == correctLetterMatch}){
            println("Congratulations! You have successfully guessed the word!")
            exitProcess(0)
        }
    }
    println("Sorry! You've ran out of guesses to guess the correct word! The correct word was $randomWord")
    exitProcess(0)

}
