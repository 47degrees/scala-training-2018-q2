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

##### Maps

- Create a new suite called [`MapsSpec` in `test.exercises.collections`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/collections/MapsSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/3a2729ebb04de7beaec7ec8d2edea9138d7983eb)

##### Sets

- Create a new suite called [`SetsSpec` in `test.exercises.collections`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/collections/SetsSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/7dd59e0f822837b5223a2e8bd28ba2a848eb855f)


##### Ranges

- Create a new suite called [`RangesSpec` in `test.exercises.collections`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/collections/RangesSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/3396b1359d49164eb4fbd5f457bd4f452cd00897)

##### Sequences

- Create a new suite called [`SequencesSpec` in `test.exercises.collections`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/collections/SequencesSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/95588e4a7c1a225910d33d92a56b8ace387b97f6)


##### Iterables

- Create a new suite called [`IterablesSpec` in `test.exercises.collections`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/collections/IterablesSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/59c08bf4a3ab35858b48f8a1068009d37cdf2a1e)

##### Traversables

- Create a new suite called [`TraversablesSpec` in `test.exercises.collections`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/collections/TraversablesSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/1ee3246eade3b121adeac9ab8079af3aecdc1818)

#### Statements

Create a new package called `statements` in `exercises` (only in test).

##### Pattern matching

- Create a new suite called [`PatternMatchingSpec` in `test.exercises.statements`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/statements/PatternMatchingSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/24a63a03681b9144b8c556101d4c9cb0cc2f3d00)

##### For expressions

- Create a new suite called [`ForExpressionsSpec` in `test.exercises.statements`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/statements/ForExpressionsSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/25d209a09df3c3548018fee27c3d18d9e25e3837)

##### Implicits

- Create a new suite called [`ImplicitsSpec` in `test.exercises.statements`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/statements/ImplicitsSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/7d10cc43f245922f1840cc89a4d516fde8827ce5)

#### Functions

Create a new package called `functions` in `exercises` (only in test).

##### High order functions

- Create a new suite called [`HighOrderFunctionsSpec` in `test.exercises.functions`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/functions/HighOrderFunctionsSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/2cfdc54e75dc584d9d8f01a803fef8e35589259d)

##### Partially applied functions

- Create a new suite called [`PartiallyAppliedFunctionsSpec` in `test.exercises.functions`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/functions/PartiallyAppliedFunctionsSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/b4969e8c0ae63ad363cf82cd8ebfa81db88c08f6)

##### Partial functions

- Create a new suite called [`PartialFunctionsSpec` in `test.exercises.functions`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/functions/PartialFunctionsSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/3376612e55bb5eacf7d412ead3535225c1070021)

##### Infix prefix and postfix operators

- Create a new suite called [`InfixPrefixandPostfixOperatorsSpec` in `test.exercises.functions`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/functions/InfixPrefixandPostfixOperatorsSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/34c55d0c38e9d729b2b8255083718d5e14b56ba0)

##### By-name parameter

- Create a new suite called [`ByNameParameterSpec` in `test.exercises.functions`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/functions/ByNameParameterSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/c48e39cb94eae8ead6356c2a28a33e1973f85032)

##### Repeated parameters

- Create new object called [`RepeatedParametersHelper` in `exercises.functions`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/exercises/functions/RepeatedParametersHelper.scala)
- Create a new suite called [`RepeatedParametersSpec` in `test.exercises.functions`](https://github.com/47deg/scala-training-2018-q2/blob/master/src/test/scala/exercises/functions/RepeatedParametersSpec.scala)
- [Commit](https://github.com/47deg/scala-training-2018-q2/commit/cfb500442af431d563937f80de2115f9bc966c93)


### Functional Programming fundamentals:

- Exposed the problem: [Ignoring side effects](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/program01.scala)
- Created the [_Maybe_](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/datatypes.scala) date type to wrap non existing values
- We need to be able to [combine](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/program03.scala)
    - Added the [Combinator](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/typeclasses.scala#L5-L7) typeclass.
    - Added its [instances](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/instances.scala#L8-L22) for `Int` and `Maybe`
    - Added its [implicits](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/implicits.scala#L9-L11) instances
    - And some [syntax](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/implicits.scala#L23-L25)
- Exposed another problem: [We need to handle the content](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/program03.scala)
    - Added the [Transformer](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/typeclasses.scala#L9-11) typeclass.
    - Added its [instances](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/instances.scala#L24-L29) for `Maybe`
    - Added its [implicits](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/implicits.scala#L13) instances
    - And some [syntax](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/implicits.scala#L27-L29)
- Exposed another problem: [We need to lift values](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/program04.scala)
    - Added the [Lifter](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/typeclasses.scala#L13-15) typeclass.
    - Added its [instances](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/instances.scala#L31-L33) for `Maybe`
    - Added its [implicits](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/implicits.scala#L15) instances
    - And some [syntax](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/implicits.scala#L31-L33)
- Exposed another problem: [We need to compute operations sequentially](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/program05.scala)
    - Added the [Flattener](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/typeclasses.scala#L17-19) typeclass.
    - Added its [instances](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/instances.scala#L35-L40) for `Maybe`
    - Added its [implicits](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/implicits.scala#L17) instances
    - And some [syntax](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/implicits.scala#L35-L37)
- Shown the [same solution](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/fp/program06.scala) using:
    - `scala.Option` instead of `Maybe`
    - `Some` instead of `Yes`
    - `None` instead of `No`
    - `cats.Semigroup` instead of `Combinator`
    - `cats.Functor` instead of `Transformer`
    - `cats.Applicative` instead of `Lifter`
    - `cats.Monad` instead of `Flattener`

[Commit](https://github.com/47deg/scala-training-2018-q2/commit/42d5f4c9e31dbf5cf21391e8a8ab69800310d672)


### Tagless Final and Transport layer (REST API - Http4s + Circe)

- Models:
    - [Task](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/com/example/mytasks/models/Task.scala)
    - [User](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/com/example/mytasks/models/User.scala)
    
- Algebras:
    - [Tasks](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/com/example/mytasks/algebras/Tasks.scala)
    - [Users](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/com/example/mytasks/algebras/Users.scala)
    
- Interpreters:
    - [TasksInterpreter](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/com/example/mytasks/interpreters/TasksInterpreter.scala)
    - [UsersInterpreter](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/com/example/mytasks/interpreters/UsersInterpreter.scala)
    
- Module:
    - [Workflow](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/com/example/mytasks/modules/Workflow.scala)
    
- Runtime:
    - [Implicits](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/com/example/mytasks/implicits/runtime.scala)
         
- HttpService:
    - [Routes](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/com/example/mytasks/http/Routes.scala)
    - [Codecs](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/com/example/mytasks/implicits/http.scala)
    - [Server](https://github.com/47deg/scala-training-2018-q2/blob/master/src/main/scala/com/example/mytasks/Server.scala)
         
         
       
    
    
    
    
    
    