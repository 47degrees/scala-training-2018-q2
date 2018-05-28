package exercises.types

object objects {

  //Singleton - Equivalence

  object Greeting {

    def english = "Hi"

    def espanol = "Hola"

  }


  //Companion object as factory

  class Movie(val name: String, val year: Short)

  object Movie {

    def academyAwardBestMoviesForYear(x: Short): Option[Movie] = {
      x match {
        case 1930 => Some(new Movie("All Quiet On the Western Front", 1930))
        case 1931 => Some(new Movie("Cimarron", 1931))
        case 1932 => Some(new Movie("Grand Hotel", 1932))
        case _ => None
      }
    }

  }

  //Companion object: accessing to private values

  class Nerd(val name: String, private val superheroName: String) //The superhero name is private!

  object Nerd {
    def showMeInnerSecret(x: Nerd) = x.superheroName
  }

}
