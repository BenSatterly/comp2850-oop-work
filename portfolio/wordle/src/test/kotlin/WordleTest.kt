import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({
    isValid("TESTS") shouldBe true
    isValid("NOPE") shouldBe false
    isValid("YESSIR") shouldBe false
    isValid("") shouldBe false

    var words = readWordList("words.txt")
    (pickRandomWord(words)).length shouldBe 5
    words.contains(pickRandomWord(words)) shouldBe true


    var words = readWordList("words.txt")
    val target = pickRandomWord(words)

    evaluateGuess("XXXXX", target) shouldBe [0, 0, 0, 0, 0]
    evaluateGuess(target, target) shouldBe [1, 1, 1, 1, 1]

    var words = readWordList("words.txt")
    words::class.simpleName shouldBe "List"
    words.count()>1 shouldBe true
})
