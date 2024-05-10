package contest.leetcode.graph

import contest.leetcode.graph.CloneGraph133.Node
import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import contest.leetcode.testutil.Arrays.toArray

import scala.collection.mutable

/**
 * @author Dmitry Openkov
 */
class CloneGraph133Test extends AnyWordSpec {
  class GraphBuilder {
    val created = mutable.Map.empty[Int, Node]

    def createGraph(adjacencyList: Array[Int]*): Node = {
      (1 to adjacencyList.length).foreach{ i =>
        val node = new Node(i)
        created.put(i, node)
      }
      adjacencyList.zip(1 to adjacencyList.length).foreach { case (neighs, i) =>
        val node = created(i)
        node.neighbors = neighs.map(created).toList
      }
      created.get(1).orNull
    }
  }

  "CloneGraph" should {
    "clone circle graph" in {
      val graph = new GraphBuilder().createGraph((2, 4), (1, 3), (2, 4), (1, 3))
      val node1 = CloneGraph133.cloneGraph(graph)
      node1.value shouldBe 1
      node1.neighbors.map(_.value) should contain theSameElementsAs List(2, 4)
      val node2 = node1.neighbors.find(_.value == 2).get
      val node4 = node1.neighbors.find(_.value == 4).get
      node2.neighbors.map(_.value) should contain theSameElementsAs List(1, 3)
      node4.neighbors.map(_.value) should contain theSameElementsAs List(1, 3)
      val node3 = node2.neighbors.find(_.value == 3).get
      node3.neighbors.map(_.value) should contain theSameElementsAs List(2, 4)
    }
    "clone single node graph" in {
      val graph = new GraphBuilder().createGraph(Array())
      val node1 = CloneGraph133.cloneGraph(graph)
      node1.value shouldBe 1
      node1.neighbors shouldBe empty
    }
  }
}
