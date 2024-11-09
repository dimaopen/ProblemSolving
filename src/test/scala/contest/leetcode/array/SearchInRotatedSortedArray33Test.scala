package contest.leetcode.array

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

/**
 * @author Dmitry Openkov
 */
class SearchInRotatedSortedArray33Test extends AnyWordSpec {

  "SearchInRotatedSortedArray" when {
    "given a non-rotated array" should {
      "find an element" in {
        SearchInRotatedSortedArray33.search(Array(0, 1, 2, 4, 5, 6, 7), target = 0) shouldBe 0
        SearchInRotatedSortedArray33.search(Array(0, 1, 2, 4, 5, 6, 7), target = 1) shouldBe 1
        SearchInRotatedSortedArray33.search(Array(0, 1, 2, 4, 5, 6, 7), target = 2) shouldBe 2
        SearchInRotatedSortedArray33.search(Array(0, 1, 2, 4, 5, 6, 7), target = 4) shouldBe 3
        SearchInRotatedSortedArray33.search(Array(0, 1, 2, 4, 5, 6, 7), target = 5) shouldBe 4
        SearchInRotatedSortedArray33.search(Array(0, 1, 2, 4, 5, 6, 7), target = 6) shouldBe 5
        SearchInRotatedSortedArray33.search(Array(0, 1, 2, 4, 5, 6, 7), target = 7) shouldBe 6
        SearchInRotatedSortedArray33.search(Array(0, 1, 2, 3, 4, 5, 6, 7), target = 0) shouldBe 0
        SearchInRotatedSortedArray33.search(Array(0, 1, 2, 3, 4, 5, 6, 7), target = 1) shouldBe 1
        SearchInRotatedSortedArray33.search(Array(0, 1, 2, 3, 4, 5, 6, 7), target = 2) shouldBe 2
        SearchInRotatedSortedArray33.search(Array(0, 1, 2, 3, 4, 5, 6, 7), target = 3) shouldBe 3
        SearchInRotatedSortedArray33.search(Array(0, 1, 2, 3, 4, 5, 6, 7), target = 4) shouldBe 4
        SearchInRotatedSortedArray33.search(Array(0, 1, 2, 3, 4, 5, 6, 7), target = 5) shouldBe 5
        SearchInRotatedSortedArray33.search(Array(0, 1, 2, 3, 4, 5, 6, 7), target = 6) shouldBe 6
        SearchInRotatedSortedArray33.search(Array(0, 1, 2, 3, 4, 5, 6, 7), target = 7) shouldBe 7
      }
    }
    "given a single element array" should {
      "find that element" in {
        SearchInRotatedSortedArray33.search(Array(-10), target = -10) shouldBe 0
      }
      "return -1 if it not equals to target" in {
        SearchInRotatedSortedArray33.search(Array(-10), target = 10) shouldBe -1
      }
    }
    "given a rotated array" should {
      "find an element if it is there" in {
        SearchInRotatedSortedArray33.search(Array(4, 5, 6, 7, 0, 1, 2), target = 4) shouldBe 0
        SearchInRotatedSortedArray33.search(Array(4, 5, 6, 7, 0, 1, 2), target = 0) shouldBe 4
      }
      "return -1 if it's not there" in {
        SearchInRotatedSortedArray33.search(Array(4, 5, 6, 7, 0, 1, 2), target = 3) shouldBe -1
      }
    }
  }
}
