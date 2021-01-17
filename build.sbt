name := "Group1-Sagar Goel SBT"

version := "1.0"

scalaVersion := "2.12.12"


//noinspection Annotator
lazy val common = project.in(file("common"))
  .settings(

    libraryDependencies ++= Seq("org.json4s" %% "json4s-native" % "3.7.0-M7",
      "org.slf4j" % "slf4j-api" % "2.0.0-alpha1",
      "puppetlabs" %% "typesafe-config" % "0.1.5",
      "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test,
      "org.mockito" %% "mockito-scala" % "1.16.15" % Test
    )
  )

lazy val persistence = project.in(file("Persistence"))
  .settings(

    libraryDependencies ++= Seq("com.typesafe.slick" %% "slick" % "3.3.3",
      "org.postgresql" % "postgresql" % "42.2.18",
      "com.h2database" % "h2" % "1.4.200" % Test
    )
  ).dependsOn(common)

lazy val root = project.in(file(".")).aggregate(common , persistence)

