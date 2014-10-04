import sbt._
import sbt.Load.BuildStructure

trait CommandSupport {
  this: Plugin =>

  protected def fail(errorMessage: String)(implicit state: State): Nothing = {
    state.log.error(errorMessage)
    throw new IllegalArgumentException()
  }

  protected def log(implicit state: State) = state.log

  // our version of http://stackoverflow.com/questions/25246920
  implicit def enrichSetting[A](key: SettingKey[A]) = new {
    def gimme(implicit pr: ProjectRef, bs: BuildStructure, s: State): A =
      gimmeOpt getOrElse { fail("Missing setting: " + key.key.label) }
    def gimmeOpt(implicit pr: ProjectRef, bs: BuildStructure, s: State): Option[A] =
      key in pr get bs.data
  }

  implicit def enrichTask[A](key: TaskKey[A]) = new {
    def run(implicit pr: ProjectRef, bs: BuildStructure, s: State): A =
      runOpt.getOrElse { fail("Missing task key: " + key.key.label) }
    def runOpt(implicit pr: ProjectRef, bs: BuildStructure, s: State): Option[A] =
      EvaluateTask(bs, key, s, pr).map(_._2) match {
        case Some(Value(v)) => Some(v)
        case _ => None
      }
  }

}
