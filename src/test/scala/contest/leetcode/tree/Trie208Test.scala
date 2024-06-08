package contest.leetcode.tree

import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/**
 * @author Dmitry Openkov
 */
class Trie208Test extends AnyWordSpec with ScalaCheckPropertyChecks {

  "Trie" should {
    "search" in {
      val trie = Trie208()
      trie.insert("some")
      trie.search("some") shouldBe true
      trie.search("som") shouldBe false
      trie.search("k") shouldBe false
    }
    "prefix" in {
      val trie = Trie208()
      trie.insert("some")
      trie.startsWith("som") shouldBe true
      trie.startsWith("s") shouldBe true
      trie.startsWith("a") shouldBe false
      trie.startsWith("sok") shouldBe false
    }
    "empty" in {
      val trie = Trie208()
      trie.startsWith("a") shouldBe false
      trie.search("a") shouldBe false
    }
    "later insert" in {
      val trie = Trie208()
      trie.insert("apple")
      trie.startsWith("app") shouldBe true
      trie.search("app") shouldBe false
      trie.insert("app")
      withClue("After inserting 'app' it should be there:") {
        (trie.startsWith("app") shouldBe true)
        trie.search("app") shouldBe true
      }
    }
  }
}
