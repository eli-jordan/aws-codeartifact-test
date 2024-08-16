import scala.util.Random
// https://stackoverflow.com/questions/64620633/publish-artifact-to-aws-codeartifact-with-sbt
//
// Note:
//  * The realm for the credentials needs to be {code artifact domain}/{repository name}

val CodeArtifactHost = "eli-test-565393054667.d.codeartifact.us-west-2.amazonaws.com"
val CodeArtifactRealm = "eli-test/maven"

credentials in ThisBuild += Credentials(CodeArtifactRealm, CodeArtifactHost, "aws", sys.env("CODEARTIFACT_AUTH_TOKEN"))

lazy val CodeArtifactRepo = "ca repo" at s"https://${CodeArtifactHost}/maven/maven/"

lazy val root = project.in(file("."))

lazy val lib = project
  .settings(
    version := "1.0.0-SNAPSHOT-" + sys.env.getOrElse("GITHUB_SHA", new Random().nextString(40)),
    publishMavenStyle := true,
    publishTo := Some(CodeArtifactRepo),
  )

//lazy val app = project // .dependsOn(lib)
//  .settings(
//    version := "1.0.0",
//    publish / skip := true,
//    resolvers ++= Seq(CodeArtifact),
//    libraryDependencies += "com.tapad" %% "lib" % (lib / version).value,
//  )

// TODO: try publishing an sbt-plugin artifact and see if it uses Ivy-style publishing