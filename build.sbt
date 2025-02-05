name := "dfdl-mil-std-2045"

organization := "com.owlcyberdefense"

version := "1.3.0"

scalaVersion := "2.12.17"

libraryDependencies ++= Seq(
  "org.apache.daffodil" %% "daffodil-tdml-processor" % "3.4.0" % "test",
  "junit" % "junit" % "4.13.2" % "test",
  "com.github.sbt" % "junit-interface" % "0.13.3" % "test",
  "org.apache.logging.log4j" % "log4j-core" % "2.19.0" % "test"
)

testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")

crossPaths := false
