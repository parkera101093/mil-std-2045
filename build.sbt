name := "mil-std-2045"

organization := "com.tresys"

version := "0.0.2"

scalaVersion in ThisBuild := "2.11.7"

scalacOptions in ThisBuild ++= Seq("-unchecked", "-deprecation", "-Yinline-warnings", "-Xfatal-warnings", "-Xxml:-coalescing")

parallelExecution in ThisBuild := false

concurrentRestrictions in Global += Tags.limit(Tags.Test, 1)

logBuffered in ThisBuild := false

testOptions in ThisBuild += Tests.Argument(TestFrameworks.JUnit, "-v")

transitiveClassifiers := Seq("sources", "javadoc")

resolvers in ThisBuild += "NCSA Sonatype Releases" at "https://opensource.ncsa.illinois.edu/nexus/content/repositories/releases"

libraryDependencies in ThisBuild := Seq(
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.10" % "test",
  "edu.illinois.ncsa" %% "daffodil-tdml" % "2.0.0-rc1" % "test"
)

retrieveManaged := true

exportJars in ThisBuild := true

exportJars in Test in ThisBuild := false

// this is so that the test jar containing the message_size definition is on
// the classpath and is available when compiling the schema
fullClasspath in Test <+= (packageBin in Test).map { dir => Attributed.blank(dir) }

publishMavenStyle in ThisBuild := true

publishArtifact in Test := false

publishTo in ThisBuild := {
  val nexus = "https://opensource.ncsa.illinois.edu/nexus/"
  if (isSnapshot.value)
    Some("NCSA Sonatype Nexus Snapshot" at nexus + "content/repositories/snapshots")
  else
    Some("NCSA Sonatype Nexus Release" at nexus + "content/repositories/releases")
}

pomIncludeRepository in ThisBuild := { _ => false }

pomExtra in ThisBuild := (
  <developers>
    <developer>
      <id>Tresys Technology</id>
      <name>Tresys Technology</name>
      <url>http://www.tresys.com</url>
    </developer>
  </developers>
)

scmInfo := Some(
  ScmInfo(
    browseUrl = url("https://github.com/DFDLSchemas/mil-std-2045"),
    connection = "scm:git:https://github.com/DFDLSchemas/mil-std-2045.git")
  )

homepage in ThisBuild := Some(url("https://github.com/DFDLSchemas/mil-std-2045"))
