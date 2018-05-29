# Scala Training: 2018 Q2

#### Attendees:

| Name | Email | Project |
|--------|--------|---------|
| Paolo | antonio.mateo@47deg.com | [@AntonioMateoGomez](https://github.com/AntonioMateoGomez/my-task) |
| Juan Carlos García Ruiz	| jcgbuzon@gmail.com | [@JCGhub](https://github.com/JCGhub/my-tasks) |
| Javier Osuna Herrera	| javier.osunaherrera@gmail.com | [@javosuher](https://github.com/javosuher/my-tasks) |
| Carlos Gallardo Polanco	| carlosgallardopolanco@gmail.com | [@gpcarlos](https://github.com/gpcarlos/my-tasks) |
| David Corral	| david.corral@uca.es | [@DavidCorral94](https://github.com/DavidCorral94/my-task) |
| Ana Gómez	| angoglez@gmail.com | [angoglez](https://github.com/angoglez/my-task) |
| Jose Gutiérrez	| gutiory@gmail.com | [@gutiory](https://github.com/gutiory/my-task) |
| Juan de la Cruz García | jcruzgar@gmail.com | [jdlcgarcia](https://github.com/jdlcgarcia/my-tasks) |
| Daniel Peralta	| dani.peralta.de@gmail.com | [@DaniPeralta](https://github.com/DaniPeralta/my-task) |
| Ignacio González Sainz	| ignacio.glez.s@gmail.com | [@ignaciogs](https://github.com/ignaciogs/MyTask) |
| José Joaquín	Arias Gómez-Calcerrada	| tatinarias@hotmail.com | [@empiremay](https://github.com/empiremay/my-tasks) |

#### Welcome email:

Hi all!

If you have received this email is because you have been selected to attend the first sponsored Scala Training by 47Degrees Academy. So, congratulations for that.

As you probably know, the entire course will actually be just six intensive sessions, so we expect you all to be fully motivated and ready to learn a huge of passionating concepts.

**The content:**

- Mon. 28th May: Environment, SBT, Scala.
- Wed. 30th May: Scala - Stdlib.
- Fri. 1st June: FP Principles: Semigroup, Monoid, Applicative, Monad.
- Mon. 4th June: REST API - Http4s + Circe.
- Wed. 6th June: DB Doobie Postgres - Concepts. Relational DB, NoSQL.
- Fri. 8th June: Project - Testing + altogether + Deployment.

**What do we expect from you guys, during this course?**
- Just motivation, commitment, and happiness.

**What do we expect from you to have ready next Monday?**
- [SBT](https://www.scala-sbt.org/download.html) (Scala Build Tool) installed
- [IntelliJ IDEA Community](https://www.jetbrains.com/idea/download/) installed:
- A valid GitHub account.


**How is the course to work?**

Well, it's our first edition and probably we will learn along with you all. We are not an actual academy, we are consultants, so we want to teach you how a real project works. That means that we won't pay attention just to the code exclusively, but also we'll focus the course on the methodology as well. If we use strict version-control procedures, English communication, agile methodologies for planning, etc. why don't to take all these valuable capabilities into account in a training?

So next Monday I will extend more information about all these details, but in summary, you will have your own repository where the advances need to be merged through Pull Request with its valid code review, we will use Slack to communicate each other (in English), etc.

That's all for now.




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


Open IntelliJ IDEA and add the project. Explain some concepts:

- Sbt shell
- Running tests in IntelliJ
- Version Control
- Add .gitignore

### Issues, branches and pull-requests

- Issues
- Branches naming convention
- PR specs

### Standard Library

Create new package called `exercises`.

Road map:

- Types: Classes, Objects, Case classes, Traits, Tuples, Literals and Option
- Collections: List, Maps, Sets, Ranges, Sequences, Array, Iterables, Traversable
- Statements: Pattern Matching, For-expression, Implicit.
- Functions: Higher Order Functions, Partially Applied Functions, Partial Functions, Infix/Postfix Operation, Byname Parameters, Repeated Params.

#### Types

Create a new package called `types` in `exercises` (also in test).

##### Classes

- Create new object called [`classes` in `exercises.types`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/exercises/types/classes.scala)
- Create a new suite called [`ClassesSpec` in `test.exercises.types`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/types/ClassesSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/00b4ec3a64cf542e3f01c6731ead13ed8097049c)


##### Objects

- Create new object called [`objects` in `exercises.types`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/exercises/types/objects.scala)
- Create a new suite called [`ObjectsSpec` in `test.exercises.types`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/types/ObjectsSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/34564860e80966aa03ac62728d6004904bd955d0)


##### Case classes

- Create new object called [`caseclasses` in `exercises.types`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/exercises/types/caseclasses.scala)
- Create a new suite called [`CaseClassesSpec` in `test.exercises.types`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/types/CaseclassesSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/a07d95cb478879ae0b656f0da761ddd730c4bd36)


##### Traits

- Create new object called [`traits` in `exercises.types`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/exercises/types/traits.scala)
- Create a new suite called [`TraitsSpec` in `test.exercises.types`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/types/TraitsSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/8d5dcf6e50a8659bf7614ec8b52a7cee19906d53)

##### Tuples

- Create a new suite called [`TuplesSpec` in `test.exercises.types`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/types/TuplesSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/9ab99f9839706a0716cee6a74137c0c9d8deae5d)

##### Literals

- Create a new suite called [`LiteralsSpec` in `test.exercises.types`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/types/LiteralsSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/3a9e11343dd3cc31c173eb2ad1f9fcc40956c6a2)


##### Option

- Create new object called [`options` in `exercises.types`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/exercises/types/options.scala)
- Create a new suite called [`OptionsSpec` in `test.exercises.types`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/types/OptionsSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/6ad3adbd0ca1868711e090c4b1febebbb902fdf6)

#### Collections

Create a new package called `collections` in `exercises` (also in test).

##### Lists

- Create new object called [`lists` in `exercises.collections`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/exercises/collections/lists.scala)
- Create a new suite called [`ListsSpec` in `test.exercises.collections`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/collections/ListsSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/904c6fcc4b3c63412401a98bc42901b312f1fd2c)

