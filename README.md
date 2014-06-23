# ENSIME-sbt
An sbt plugin that supports integration with the ENSIME server.


## Versions

__For use with ENSIME 0.9+__

* 0.1.4 for scala 2.10 and sbt 0.13
* 0.1.1 for scala 2.9/2.10 and sbt 0.12


## How to Install
Add the following to your `~/.sbt/0.13/plugins/plugins.sbt` (ommit the `0.13` part for older versions of `sbt`) or `YOUR_PROJECT/project/plugins.sbt`:

    addSbtPlugin("org.ensime" % "ensime-sbt" % "VERSION")

Adding the line above to YOUR_PROJECT/build.sbt won't activate the plugin, you must add it one level above, to either YOUR_PROJECT/project/plugins.sbt or YOUR_PROJECT/project/build.sbt.

## How to Use
The above automatically adds the `ensime generate` command to your sbt build. This command will write a .ensime file to your project's root directory.

The `ensime generate -s` command causes sbt to download the source jars of your project's dependencies (as with `update-classifiers`) and include their paths in the .ensime file. This is only useful with a recent version of Ensime that can navigate to source jars.

Note: Currently, it may be necessary to first delete your project/target directories before running 'ensime generate'.

### Use locally compiled version
Clone the repository to your local machine and run

    sbt publishLocal

Change the plugin version in your `plugins.sbt` file to the one declared in the `ensime-sbt/build.sbt`.

## License
BSD License
