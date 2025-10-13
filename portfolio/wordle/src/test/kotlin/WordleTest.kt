import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({
    // Code for function 'isValid' testing goes here {
        isValid("TESTS") shouldBe true
        isValid("NOPE") shouldBe false
        isValid("YESSIR") shouldBe false
        isValid("") shouldBe false
    }
    
    // Code for function 'pickRandomWord' testing goes here {
        var words = readWordList("words.txt")
        (pickRandomWord(words)).length() shouldBe 5
        words.contains(pickRandomWord(words)) shouldBe true
    }

    // Code for function 'evaluateGuess' testing goes here {
        var words = readWordList("words.txt")
        val target = pickRandomWord(words)

        evaluateGuess("XXXXX", target) shouldBe [0, 0, 0, 0, 0]
        evaluateGuess(target, target) shouldBe [1, 1, 1, 1, 1]
    }

    // Code for function 'readWordList' testing goes here {
        var words = readWordList("words.txt")
        words::class.simpleName shouldBe "List"
        words.count()>1 shouldBe true
    }
})
