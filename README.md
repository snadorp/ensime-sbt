# ENSIME SBT

This [sbt](http://github.com/sbt/sbt) plugin generates a `.ensime`
file for use with an
[ENSIME server](http://github.com/ensime/ensime-server).

The ENSIME ecosystem is actively developed and always looking for new
contributors. This is a fairly small and easy to understand plugin, so
please consider sending us a Pull Request if you have any feature
request ideas.


## Installation

ENSIME is effectively using a rolling release strategy until version
1.0. Therefore, the latest plugin is available by adding the following
to your `project/plugins.sbt`:


```scala
    resolvers += Resolver.sonatypeRepo("snapshots")

    addSbtPlugin("org.ensime" % "ensime-sbt" % "0.1.5-SNAPSHOT")
```

Only sbt 0.13.x is supported.

An older 0.1.1 release is available for sbt 0.12, but we don't
recommend it.


## Using

Type `sbt 'ensime generate -s'` or, from the sbt prompt:

```
ensime generate -s
```

leave off the `-s` if you don't want source jars to be downloaded and
referenced in the resulting `.ensime` file.


## Developers / Workarounds

Fork and clone this repository, (optionally: add awesomeness), and
then:

```
sbt publishLocal
```
