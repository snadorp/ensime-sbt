import net.virtualvoid.sbt.graph.Plugin.graphSettings

name := "ensime-sbt"

organization := "org.ensime"

version := "0.1.5-SNAPSHOT"

sbtPlugin := true

scalacOptions in Compile ++= Seq(
  "-encoding", "UTF-8", "-target:jvm-1.5",
  "-Xfatal-warnings"
)

// we actually depend at runtime on scalariform
// TODO: when ENSIME itself is ready for a reformat, depend on the recent scalariform
addSbtPlugin("com.typesafe.sbt" %% "sbt-scalariform" % "1.0.1")

licenses := Seq("BSD 3 Clause" -> url("http://opensource.org/licenses/BSD-3-Clause"))

homepage := Some(url("http://github.com/ensime/ensime-server"))

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

credentials += Credentials(
  "Sonatype Nexus Repository Manager", "oss.sonatype.org",
  sys.env.get("SONATYPE_USERNAME").getOrElse(""),
  sys.env.get("SONATYPE_PASSWORD").getOrElse("")
)

graphSettings

//scalariformSettings
