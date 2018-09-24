// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// Add sonatype repo
resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

// code quality
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0")

addSbtPlugin("org.wartremover" %% "sbt-wartremover" % "2.3.7")

// dependency tree
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.2")