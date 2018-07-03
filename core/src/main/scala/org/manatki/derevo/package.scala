package org.manatki.derevo
import scala.annotation.{StaticAnnotation, compileTimeOnly}

@compileTimeOnly("enable macro paradise to expand macro annotations")
class derive(instances: InstanceDef*) extends StaticAnnotation {
  def macroTransform(annottees: Any*): Any = macro Derevo.deriveMacro
}

class delegating(to: String) extends StaticAnnotation
class phantom

sealed trait InstanceDef
trait Derivation[TC[_]] extends InstanceDef
trait PolyDerivation[FromTC[_], ToTC[_]] extends InstanceDef