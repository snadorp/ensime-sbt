import sbt._
import scalariform.formatter.preferences.IFormattingPreferences

case class EnsimeConfig(
  root: File,
  cacheDir: File,
  name: String,
  scalaVersion: String,
  compilerArgs: List[String],
  modules: Map[String, EnsimeModule],
  javaHome: Option[File],
  javaFlags: List[String],
  javaSrc: Option[File],
  formatting: Option[IFormattingPreferences],
  raw: String
)

case class EnsimeModule(
    name: String,
    mainRoots: Set[File],
    testRoots: Set[File],
    target: File,
    testTarget: File,
    dependsOnNames: Set[String],
    compileJars: Set[File],
    runtimeJars: Set[File],
    testJars: Set[File],
    sourceJars: Set[File],
    docJars: Set[File]
) {

  def dependencies(implicit lookup: String => EnsimeModule): Set[EnsimeModule] =
    dependsOnNames map lookup

}
