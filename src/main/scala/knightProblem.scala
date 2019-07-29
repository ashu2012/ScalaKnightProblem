

object knightProblem extends  App {


  //scala.io.Source.fromInputStream(Console.in).getLines()
  //OrderProcessor.process( System.in , Console.out)
 println("Enter \"N\" number for NxN grid")
  var numInputs = scala.io.Source.fromInputStream(System.in ).bufferedReader().readLine().toInt
  var kT=  new KnightTour(numInputs)

    kT.printMove


}

