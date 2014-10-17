[![Bountysource](https://www.bountysource.com/badge/tracker?tracker_id=239449)](https://www.bountysource.com/trackers/239449-ensime?utm_source=239449&utm_medium=shield&utm_campaign=TRACKER_BADGE)
[![Build Status](https://travis-ci.org/ensime/ensime-sbt.svg?branch=master)](https://travis-ci.org/ensime/ensime-sbt)

# ENSIME SBT

This [sbt](http://github.com/sbt/sbt) plugin generates a `.ensime` file for use with an [ENSIME server](http://github.com/ensime/ensime-server).

The ENSIME ecosystem is actively developed and always looking for new
contributors. This is a fairly small and easy to understand plugin, so
please consider sending us a Pull Request if you have any feature
request ideas.

## Installation

ENSIME is effectively using a rolling release strategy until version
1.0. The latest plugin is available by adding the following
to your `~/.sbt/0.13/plugins/plugins.sbt`:

Ensime is now an [AutoPlugin](http://www.scala-sbt.org/release/docs/Plugins.html#Creating+an+auto+plugin), which requires SBT 0.13.5+. A backport exists only for sbt 0.12.x.

```scala
resolvers += Resolver.sonatypeRepo("snapshots")

addSbtPlugin("org.ensime" % "ensime-sbt" % "0.1.5-SNAPSHOT")
```

We recommend installing the plugin in `~/.sbt` as opposed to
`project/plugins.sbt` because the decision to use ENSIME is per-user,
rather than per-project.


**BUG IN SBT: see https://github.com/sbt/sbt/issues/1592 if you get any problems about `error: value enablePlugins is not a member of sbt.Project`.**


If you want to customise the output, create a file `project/ensime.sbt`
which is ignored by SCM (or use `~/.sbt/0.13/ensime.sbt`), and customise
like so:

```scala
import org.ensime.Imports._

EnsimeKeys.compilerArgs in Compile := (scalacOptions in Compile).value ++ Seq("-Ywarn-dead-code", "-Ywarn-shadowing")

// custom settings (this is an example of adding scalariform formatting preferences):
EnsimeKeys.additionalSExp in Compile := (additionalSExp in Compile) := ":custom-key custom-value"
```

For the 0.12.x branch, these files must go into `~/.sbt`
(that is `~/.sbt/plugins/plugins.sbt`, `~/.sbt/ensime.sbt`) and the `ensime.sbt` must start with

```scala
import EnsimePlugin._
import EnsimeKeys._
```

instead of `import org.ensime.Imports._`


## Usage

Type `sbt gen-ensime` or, from the sbt prompt:

```bash
> gen-ensime
```

Downloading and resolving the sources and javadocs can take some time on first use.

## Developers / Workarounds

Fork and clone this repository, (optionally: add awesomeness), and
then:

```bash
> sbt publishLocal
```

(`sbt publish-local` for the 0.12 branch)
