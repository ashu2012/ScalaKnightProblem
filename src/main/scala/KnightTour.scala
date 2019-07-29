object KnightTour {

  var N :Integer =0

  def setGridSize(n:Int):Unit={
    N=n
  }

  /* A utility function to check if i,j are
     valid indexes for N*N chessboard */
  def isSafe(x:Int , y:Int, sol : Array[Array[Int]]):Boolean = {
    return (x >= 0 && x < N && y >= 0 &&
      y < N && sol(x)(y) == -1);
  }

  /* A utility function to print solution
     matrix sol[N][N] */
  def printSolution( sol: Array[Array[Int]]):Unit= {
    for ( x:Int <- 0 to N-1 ) {
      for ( y:Int <- 0 to N-1){
        System.out.print(sol(x)(y).toString + " ")

      }
      System.out.println();
    }
  }


  def   solveKT():Boolean= {
    var sol = Array.ofDim[Int](N,N);

    /* Initialization of solution matrix */
    for (  x:Int <- 0 to N-1){
      for ( y :Int <- 0 to N-1){
        sol(x)(y) = -1;
      }

    }



    var xMove:Array[Int] = Array(3, 0, -3, 0, -2, 2, 2, -2)
    var yMove:Array[Int] = Array(0, 3, 0, -3, -2, 2, -2, 2)
    // Since the Knight is initially at the first block
    sol(0)(0) = 0;

    /* Start from 0,0 and explore all tours using
       solveKTUtil() */
    if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
      System.out.println("Solution does not exist");
      return false
    } else
      printSolution(sol)

    return true;
  }

  /* A recursive utility function to solve Knight
     Tour problem */
  def solveKTUtil( x:Int,  y:Int, movei:Int,
                   sol:Array[Array[Int]],  xMove:Array[Int],
                   yMove:Array[Int]):Boolean ={

    if (movei == N * N)
      return true;

    /* Try all next moves from the current coordinate
        x, y */
    for (k:Int <- 0 to 8-1 ) {
      var next_x = x + xMove(k);
      var next_y = y + yMove(k);
      if (isSafe(next_x, next_y, sol)) {
        sol(next_x)(next_y) = movei;
        if (solveKTUtil(next_x, next_y, movei + 1,
          sol, xMove, yMove))
          return true;
        else
          sol(next_x)(next_y) = -1;// backtracking
      }
    }

    return false;
  }


}


case class KnightTour(N:Int){

  def printMove:Unit= {
    KnightTour.setGridSize(N)
    KnightTour.solveKT()
  }


}