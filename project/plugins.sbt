//resolvers += "Typesafe repository" at  "http://repo.typesafe.com/typesafe/releases/"
//resolvers += Resolver.url("fix-sbt-plugin-releases", url("https://dl.bintray.com/sbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)

addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.9.2")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "1.1.0")
addDependencyTreePlugin