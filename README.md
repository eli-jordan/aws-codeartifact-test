# Scala sbt project (Maven Jar artifact type)

This is a Scala project that uses the [sbt](https://www.scala-sbt.org/) build tool and produces a Maven Jar artifact.
This project is tested using the [`scala.yml`](.github/workflows/scala.yml) GitHub Actions workflow.

## Setup

- This is a minimal Scala project: `app` peojct depends on the `lib` project with minimum code.
- It uses our recommended project setup via the `sbt-tapad` plugin.
- It relies on [sbt-gcs-resolver](https://github.com/abdolence/sbt-gcs-resolver) plugin for interaction with GAR.

## Manual testing

To test this project manually, you can run the following commands:

```bash
cd scala
sbt
```

then in the sbt shell, you can try to publish the `lib` project:

```bash
sbt> lib/publish
```

The version is dynamic and depends on the Git state. Once it's published, you can try to update the `app` project:

```bash
sbt> app/run
```

This depends on the `lib` project, so this will verify that the `lib` project was published correctly and the artifacts can be downloaded.