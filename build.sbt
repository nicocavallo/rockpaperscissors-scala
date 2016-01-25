name := "rockpaperscissors-scala"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.7" % "test",
                            "org.specs2" %% "specs2"      % "3.7" % "test")

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-Xfatal-warnings")

// Coverage
coverageMinimum := 80

coverageFailOnMinimum := true