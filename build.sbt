import Dependencies._
import sbt._


ThisBuild / scalaVersion     := "2.12.10"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.ouag.demo.scala"
ThisBuild / organizationName := "ouag"

lazy val root = (project in file("."))
  .settings(
    name := "spring-boot-admin-client",
    libraryDependencies += scalaTest % Test,
    //assembly
    assembly / mainClass := Some("com.ouag.demo.DemoClientWebAPI"),
    assembly / assemblyJarName := "DemoClientWebAPI.jar"
  )


//--------------- dependency -------------------
//springboot
libraryDependencies += "org.springframework.boot"% "spring-boot-starter-web"%"2.5.5"
libraryDependencies += "org.springframework.boot" % "spring-boot-configuration-processor" % "2.5.5"
libraryDependencies += "org.springframework.boot"%"spring-boot-starter-actuator"%"2.5.5"

//swagger
libraryDependencies += "io.springfox"%"springfox-swagger2"%"2.9.2"
libraryDependencies += "io.springfox"%"springfox-swagger-ui"%"2.9.2"

//TESTS
libraryDependencies += "org.scalatest"%%"scalatest"%"2.2.4"% "test"


enablePlugins(JavaAppPackaging, AshScriptPlugin)


fork := true
javaOptions ++= Seq(
  "-Ddebug"
)

//Publish related main
mainClass in Compile := Some("com.ouag.demo.DemoClientWebAPI")


assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) =>
    xs match {
      case ("MANIFEST.MF" :: Nil) => MergeStrategy.discard
      // Concatenate everything in the services directory to keep GeoTools happy.
      case "mailcap" :: Nil => MergeStrategy.last
      case "mimetypes.default" :: Nil => MergeStrategy.last

      case ("services" :: _ :: Nil) =>
        MergeStrategy.concat
      // Concatenate these to keep JAI happy.
      case "javax.media.jai.registryFile.jai" :: Nil | "registryFile.jai" :: Nil | "registryFile.jaiext" :: Nil =>  MergeStrategy.concat
      case "spring.factories" :: Nil =>  MergeStrategy.concat
      case name :: Nil => {
        // Must exclude META-INF/*.([RD]SA|SF) to avoid "Invalid signature file digest for Manifest main attributes" exception.
        if (name.endsWith(".RSA") || name.endsWith(".DSA") || name.endsWith(".SF"))
          MergeStrategy.discard
        else
          MergeStrategy.first
      }
      case _ => MergeStrategy.first
    }
  case x => MergeStrategy.first
}