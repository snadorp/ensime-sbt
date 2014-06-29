import bintray.Keys._
import com.typesafe.sbt.SbtGit._

versionWithGit

git.baseVersion := "0.1.4"

sbtPlugin := true

name := "ensime-sbt"

organization := "org.ensime"

publishMavenStyle := false

bintrayPublishSettings

bintrayOrganization in bintray := Some("ensime")

repository in bintray := "sbt-plugins"

licenses += ("BSD", url("http://opensource.org/licenses/BSD-3-Clause"))

