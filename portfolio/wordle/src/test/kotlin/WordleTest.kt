import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({

    "isValid - Tests that function correctly validates data entry" {
        isValid("TESTS") shouldBe true
        isValid("NOPE") shouldBe false
        isValid("YESSIR") shouldBe false
        isValid("") shouldBe false
    }

    "pickRandomWord - Randomly picked word should be 5 letters long, and from the list" {
        val words = readWordList("words.txt")
        pickRandomWord(words).length shouldBe 5
        words.contains(pickRandomWord(words)) shouldBe true
    }

    "evaluateGuess - Function should return the correct comparison with target word" {
        val words = readWordList("words.txt")
        val target = pickRandomWord(words)

        evaluateGuess("XXXXX", target) shouldBe mutableListOf(0, 0, 0, 0, 0)
        evaluateGuess(target, target) shouldBe mutableListOf(1, 1, 1, 1, 1)
    }

    "readWordList - Word list (from input words file) should have multiple elements (words)" {
        val words = readWordList("words.txt")
        (words.count() > 1) shouldBe true
    }
})
