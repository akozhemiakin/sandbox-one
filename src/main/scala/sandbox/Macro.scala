package sandbox

import scala.language.experimental.macros
import scala.reflect.macros.blackbox

object Macro {
  def annosOnFoo[T](expr: T): Int = macro testImpl[T]

  def testImpl[T: c.WeakTypeTag](c: blackbox.Context)(expr: c.Expr[T]): c.Tree = {
    import c.universe._

    val n = weakTypeOf[T].typeArgs.head.member(TermName("foo")).annotations.length

    q"$n"
  }
}
