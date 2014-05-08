import java.util.*;
import java.io.Console;

public class Gilmore {

    // pre: Matriu A (fluxes), Matriu B (distancies), Matriu C (costos linials)
    // post: Retorna la cota Gilmore-Lawler del Qap
    public static double Bound(double[][] A, double[][] B, double[][] C)
    {
			Qap qap = new Qap();

      qap.A = A;
      qap.B = B;
      qap.C = C;
      qap.Shift = 0;

      
      int n = qap.A.length;

      double[][] L = AssignmentMat(qap);

      // Resol LAP(L) per obtenir la cota
      int[] ip = new int[n];
      double[] ys = new double[n];
      double[] yt = new double[n];

      double bound = clcCotaHungarian(L);
      return bound;
    }

    // pre: -
    // post: Retorna la matriu L, que es la que li calculem la cota
    private static double[][] AssignmentMat(Qap qap)
    {
      int n = qap.A.length;

      // Copiem B_i a br_i excepte B_ii
      // Aquest Double en en majuscula (objecte) perque cal ordenar-ho en ordre invers
      Double[][] br = new Double[n][n-1];

      for(int i=0;i<n;i++) {
        for(int j=0;j<i;j++) br[i][j] = qap.B[i][j];
        for(int j=i+1;j<n;j++) br[i][j-1] = qap.B[i][j];
        // Ordenem en sentit invers
        Arrays.sort(br[i],Collections.reverseOrder());
      }

      // Ara calculem: L_ij=A_ii B_jj + c_ij
      double[][] L = new double[n][n];
      double[] ar_i=new double[n-1];
      for(int i=0;i<n;i++) {
        for(int j=0;j<i;j++) ar_i[j] = qap.A[i][j];
        for(int j=i + 1;j<n;j++) ar_i[j - 1] = qap.A[i][j];
        // Ordenem en sentit natural
        Arrays.sort(ar_i);
        for(int j=0;j<n;j++) {
          double l_ij=qap.A[i][i] * qap.B[j][j] + qap.C[i][j];
          for(int k = 0; k < n - 1; k++) l_ij += ar_i[k] * br[j][k];
          L[i][j] = l_ij;
        }
      }
      return L;
    }
    
    // Pre: -
    // Post: Preparacio per a cridar el Hungarian Algorithm
    private static double clcCotaHungarian(double[][] mMatriu) {
    double resultat = 0;
    int nRangfil = mMatriu.length;
    int nRangcol = mMatriu[0].length;

    double[][] mMat = new double[nRangfil][nRangcol];
    for(int f=0;f<nRangfil;f++) for(int c=0;c<nRangcol;c++) mMat[f][c] = mMatriu[f][c];

    HungarianAlgorithm ha = new HungarianAlgorithm();
    int[][] haResultat = ha.computeAssignments(mMat);
    for(int f=0;f<nRangfil;f++) {
      int haf = haResultat[f][0];
      int hac = haResultat[f][1];
      double suma = mMatriu[haf][hac];
      resultat = resultat + suma;
    }
    return resultat;
}
   
  // El Quadratic Assignment Problem
  public static class Qap
  {
    // A (fluxes)
    public double[][] A;
    // B (distancies)
    public double[][] B;
    // C (costos linials)
    public double[][] C;
    // Terme constant
    public double Shift;
  
  // private static Qap Reduir(Qap qap, int i, int j)
  // {
  //   Qap r = new Qap();

  //   r.A = Reduir(qap.A, i, i);
  //   r.B = Reduir(qap.B, j, j);
  //   r.C = Reduir(qap.C, i, j);

  //   // Tack on: 2 a'_i b'_j (where a'_i is row i of A, with element i removed)
  //   for(int ii=0; ii < r.A.length; ii++)
  //   {
  //     for(int jj=0; jj < r.A.length; jj++)
  //     {
  //       r.C[ii][jj] += 2 * qap.A[i][ii < i ? ii : ii + 1] * qap.B[jj < j ? jj : jj + 1][j];
  //     }
  //   }

  //   r.Shift = qap.Shift + qap.A[i][i] * qap.B[j][j] + qap.C[i][j];

  //   return r;
  // }

  // private static double[][] Reduir(double[][] M, int i, int j)
  // {
  //   double[][] R = new double[M.length-1][M.length-1];
  //   for(int ii=0; ii < R.length; ii++)
  //   {
  //     for(int jj=0; jj < R[ii].length; jj++)
  //     {
  //         R[ii][jj] = M[ii < i ? ii : ii + 1][jj < j ? jj : jj + 1];
  //     }
  //   }
  //   return R;
  // }
  

  }
}
  
