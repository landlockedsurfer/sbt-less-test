
lazy val root = (project in file(".")).enablePlugins(SbtWeb)

includeFilter in (Assets, LessKeys.less) := "*.less"

val appName = "LessTestProject"

lazy val main:Project = Project(appName, base = file(".")).
  settings(
    resolvers ++= Seq(
      "Typesafe private" at "https://private-repo.typesafe.com/typesafe/maven-releases",
      "Typesafe snapshots" at "https://repo.typesafe.com/typesafe/snapshots/"
    )
  )
  .enablePlugins(PlayScala, SbtWeb)

