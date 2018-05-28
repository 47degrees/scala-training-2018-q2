# Scala Training: 2018 Q2

## Day 1

### Hello World in the command line

We start with the basic Scala Hello World:

```bash
sbt new scala/scala-seed.g8
```

We can name the app as `my-tasks`:

```bash
A minimal Scala project.

name [Scala Seed Project]: my-tasks

Template applied in ./my-tasks
```

#### Setting up the Git repo

After creating a new public repository in GitHub, we can:

```bash
cd my-tasks
git init
git add *
git commit -m "first commit"
git remote add origin git@github.com:<org>/<repo>.git
git push -u origin master
```

[Commit](https://github.com/47deg/scala-training-2018-q2/commit/be75a5af8ac6bd867b02180064df69ff2cc4a99a)

#### Run the app

Run:
```bash
sbt run
```

We'll have `[info] Running example.Hello` and `hello` as result.

#### Test the app

We can even run the tests:

```bash
sbt test
...
[info] HelloSpec:
[info] The Hello object
[info] - should say hello
[info] Run completed in 882 milliseconds.
[info] Total number of tests run: 1
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 1, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
```

Let's invite other team-mate to collaborate (and the teacher as well).

### Hello World in IntelliJ

Requirements: 

- Install Java 8
- Install plugin in IntelliJ: SBT


Open IntelliJ IDEA and add the project.

