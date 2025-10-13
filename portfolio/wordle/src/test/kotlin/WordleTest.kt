import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({

    "Tests for isValid function" {
        isValid("TESTS") shouldBe true
        isValid("NOPE") shouldBe false
        isValid("YESSIR") shouldBe false
        isValid("") shouldBe false
    }

    "Randomly picked word should be 5 letters long, and from the list" {
        val words = readWordList("words.txt")
        pickRandomWord(words).length shouldBe 5
        words.contains(pickRandomWord(words)) shouldBe true
    }

    "evaluateGuess function should return the correct comparison with target word" {
        val words = readWordList("words.txt")
        val target = pickRandomWord(words)

        evaluateGuess("XXXXX", target) shouldBe mutableListOf(0, 0, 0, 0, 0)
        evaluateGuess(target, target) shouldBe mutableListOf(1, 1, 1, 1, 1)
    }

    "word list (from input words file) should be a list with multiple elements (words)" {
        val words = readWordList("words.txt")
        words::class.simpleName shouldBe "MutableList"
        (words.count() > 1) shouldBe true
    }
})
