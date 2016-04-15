lazy val commonSettings = Seq(
  scalaVersion := "2.11.8"
)

lazy val sandbox = (project in file("."))
  .settings(commonSettings)
  .settings(Seq(
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      "org.scalatest" %% "scalatest" % "2.2.4" % "test"
    )
  ))
