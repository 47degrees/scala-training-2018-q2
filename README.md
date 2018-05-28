# Scala Training: 2018 Q2

#### Attendees:

| Name | Email |
|--------|--------|
| Paolo | antonio.mateo@47deg.com |
| Juan Carlos García Ruiz	| jcgbuzon@gmail.com |
| Javier Osuna Herrera	| javier.osunaherrera@gmail.com |
| Carlos Gallardo Polanco	| carlosgallardopolanco@gmail.com |
| David Corral	| david.corral@uca.es |
| Ana Gómez	| angoglez@gmail.com |
| Jose Gutiérrez	| gutiory@gmail.com |
| Juan de la Cruz García | jcruzgar@gmail.com |
| Daniel Peralta	| dani.peralta.de@gmail.com |
| Ignacio González Sainz	| ignacio.glez.s@gmail.com |
| José Joaquín	Arias Gómez-Calcerrada	| tatinarias@hotmail.com |

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


Open IntelliJ IDEA and add the project.

