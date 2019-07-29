name := "knightProblem.scala"

version := "0.1"

scalaVersion := "2.12.4"



resolvers += Resolver.url("artifactory", url("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)

libraryDependencies ++= Seq(
  "com.eed3si9n" % "sbt-assembly" % "0.14.5"
)

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.5")

exportJars := true

mainClass in Compile := Some("knightProblem")
mainClass in(Compile, run) := Some("knightProblem")
mainClass in(Compile, packageBin) := Some("knightProblem")
mainClass in assembly := Some("knightProblem")
