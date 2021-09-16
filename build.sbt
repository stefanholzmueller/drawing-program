name := "drawing-program"
version := "0.1"
organization := "stefanholzmueller"

scalaVersion := "3.0.1"
scalacOptions := Seq("-unchecked", "-deprecation")

libraryDependencies ++= Seq(
  "org.scalameta" %% "munit" % "0.7.29" % Test
)