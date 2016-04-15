package sandbox

import org.scalatest.FunSuite
import sandbox.sub.B

class SandboxSpec extends FunSuite {
  class A[T](el: T)

  test("Test 1") {
    // Here we use simple macro to return number of annotations attached to the "foo" method of the A type arg
    assert(Macro.annosOnFoo(new A(new C)) == 1) // Will succeed
  }

  test("Test 2") {
    // Exactly the same case as above. The only difference: B is not in the same package as A and this test
    assert(Macro.annosOnFoo(new A(new B)) == 1) // Will fail
  }
}
