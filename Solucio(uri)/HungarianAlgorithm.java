import java.util.*;

public class HungarianAlgorithm{

	// pre: -
	// post: Retorna el resultat de Algorisme Hungarian, la cota.
	public double computeAssignments(double[][] mat) {
	  
		double[][] mMatOrig = new double[mat.length][mat[0].length];
    	for(int f=0;f<mat.length;f++) {
    		for(int c=0;c<mat[0].length;c++) {
    			mMatOrig[f][c] = mat[f][c];
    		}
    	}

		// extraiem el minim valor de les files i les columnes per crear els zeros
		reduirMatriu(mat);

		// EtiquetesPerFila
		int[] EtiquetesPerFila = new int[mat.length]; Arrays.fill(EtiquetesPerFila,-1);
		int[] EtiquetesPerColumna = new int[mat[0].length]; Arrays.fill(EtiquetesPerColumna,-1); 
		int[] preparatsPerFila = new int[mat.length]; Arrays.fill(preparatsPerFila,-1);

		// 0 significa que esta descobert
		int[] FilesCobertes = new int[mat.length];
		int[] ColsCobertes = new int[mat[0].length];

		// marca qualsevol zero que no te cap altre zero marcat a la mateixa linea o columna
		iniEtiquetes(mat, EtiquetesPerFila, EtiquetesPerColumna);
		cobrirColumnesZerosEtiq(EtiquetesPerColumna,ColsCobertes);

		while (!totsCoberts(ColsCobertes)) {

			int[] zerosPreparats = prepararZerosDescoberts(mat, preparatsPerFila, FilesCobertes, ColsCobertes);

			while (zerosPreparats == null) {
				// segueix fent mes zeros fins que trobem p.e. un zero descobert
				ferMesZeros(mat,FilesCobertes,ColsCobertes);
				zerosPreparats = prepararZerosDescoberts(mat, preparatsPerFila, FilesCobertes, ColsCobertes);
			}

			int indexCol = EtiquetesPerFila[zerosPreparats[0]];
			if (-1 == indexCol){

				incConjuntZerosEtiquetats(zerosPreparats, EtiquetesPerFila, EtiquetesPerColumna, preparatsPerFila);
				Arrays.fill(preparatsPerFila,-1);
				Arrays.fill(FilesCobertes,0);
				Arrays.fill(ColsCobertes,0);
				cobrirColumnesZerosEtiq(EtiquetesPerColumna,ColsCobertes);
			} else {
				// cobreix la fila dels zeros preparats i decobreixla columna del zero marcat a la mateixa fila
				FilesCobertes[zerosPreparats[0]] = 1;
				ColsCobertes[indexCol] = 0;
			}
		}

		int[][] retval = new int[mat.length][];
		for (int i = 0; i < EtiquetesPerColumna.length;  i++) {
			retval[i] = new int[]{EtiquetesPerColumna[i],i};
		}
		
		
    double resultat = 0;		
    for(int f=0;f<mMatOrig.length;f++) {
      int haf = retval[f][0];
      int hac = retval[f][1];
      double suma = mMatOrig[haf][hac];
      resultat = resultat + suma;
    }

		
		
		return resultat;
	}

	// pre: -
	// post: Ens diu si els elements de una columna son coberts o no
	private boolean totsCoberts(int[] ColsCobertes) {
		for (int coberta : ColsCobertes) {
			if (0 == coberta) return false;
		}
		return true;
	}


	// pre: -
	// post: Fem els primers passos de l'algoritme on prepararem la matriu per aconseguir la de costos
	private void reduirMatriu(double[][] mat) {

		for (int i = 0; i < mat.length; i++) {

			// busca el minim valor de la fila
			double minValFila = Double.MAX_VALUE;
			for (int j = 0; j < mat[i].length; j++) {
				if (minValFila > mat[i][j]) {
					minValFila = mat[i][j];
				}
			}

			// resta el minim valor de tots els elements de la fila
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] -= minValFila;
			}
		}

		for (int i = 0; i < mat[0].length; i++) {
			double minValCol = Double.MAX_VALUE;
			for (int j = 0; j < mat.length; j++) {
				if (minValCol > mat[j][i]) {
					minValCol = mat[j][i];
				}
			}

			for (int j = 0; j < mat.length; j++) {
				mat[j][i] -= minValCol;
			}
		}
	}

	// pre: -
	// post: Inicialitza els zeros marcats o etiquetats
	private void iniEtiquetes(double matriuCost[][], int[] EtiquetesPerFila, int[] EtiquetesPerColumna) {


		int [] FilesZeroEtiq = new int[matriuCost.length];
		int [] ColZeroEtiq = new int[matriuCost[0].length];

		for (int i = 0; i < matriuCost.length; i++) {
			for (int j = 0; j < matriuCost[i].length; j++) {
				if (0 == matriuCost[i][j] && 0 == FilesZeroEtiq[i] && 0 == ColZeroEtiq[j]) {
					EtiquetesPerFila[i] = j;
					EtiquetesPerColumna[j] = i;
					FilesZeroEtiq[i] = 1;
					ColZeroEtiq[j] = 1;
					break; // seguent linea
				}
			}
		}
	}



	// pre: -
	// post: Marca les columnes cobertes per qualsevol columna que contingui un zero marcat
	private void cobrirColumnesZerosEtiq(int[] EtiquetesPerColumna, int[] ColsCobertes) {
		for (int i = 0; i < EtiquetesPerColumna.length; i++) {
			ColsCobertes[i] = -1 == EtiquetesPerColumna[i] ? 0 : 1;
		}
	}

	// pre: - 
	// post: Busca els zeros descoberts i els prepara
	private int[] prepararZerosDescoberts(double mat[][], int[] preparatsPerFila,
									   int[] FilesCobertes, int[] ColsCobertes) {


		// busca el zero descobert
		for (int i = 0; i < mat.length; i++) {
			if (1 == FilesCobertes[i]) continue;
			for (int j = 0; j < mat[i].length; j++) {
				// if it's a zero and the column is not covered
				if (0 == mat[i][j] && 0 == ColsCobertes[j]) {

					preparatsPerFila[i] = j;
					return new int[]{i,j};
				}
			}
		}
		return null;

	}

	// pre: -
	// post: Incrementa el conjunt de zeros etiquetats
	private void incConjuntZerosEtiquetats(int[] zerosDesparellatsPrep, int[] EtiquetesPerFila, int[] EtiquetesPerColumna, int[] preparatsPerFila) {

		int i, j = zerosDesparellatsPrep[1];

		Set<int[]> zeroSeq = new LinkedHashSet<int[]>();
		zeroSeq.add(zerosDesparellatsPrep);

		boolean aparellat = false;
		do {
			i = EtiquetesPerColumna[j];
			aparellat = -1 != i && zeroSeq.add(new int[]{i,j});
			if (!aparellat) break;

			j = preparatsPerFila[i];
			aparellat = -1 != j && zeroSeq.add(new int[]{ i, j });

		} while (aparellat);

		for (int[] zero : zeroSeq) {
			if (EtiquetesPerColumna[zero[1]] == zero[0]) {
				EtiquetesPerColumna[zero[1]] = -1;
				EtiquetesPerFila[zero[0]] = -1;
			}
			if (preparatsPerFila[zero[0]] == zero[1]) {
				EtiquetesPerFila[zero[0]] = zero[1];
				EtiquetesPerColumna[zero[1]] = zero[0];
			}
		}

	}

	// pre: -
	// post: Afegeix zeros a la matriu
	private void ferMesZeros(double[][] mat, int[] FilesCobertes, int[] ColsCobertes) {

		// busca el valor minim descobert
		double minValorDescobert = Double.MAX_VALUE;
		for (int i = 0; i < mat.length; i++) {
			if (0 == FilesCobertes[i]) {
				for (int j = 0; j < mat[i].length; j++) {
					if (0 == ColsCobertes[j] && mat[i][j] < minValorDescobert) {
						minValorDescobert = mat[i][j];
					}
				}
			}
		}

		// Suma el minim valor a totes les files cobertes
		for (int i = 0; i < FilesCobertes.length; i++) {
			if (1 == FilesCobertes[i]) {
				for (int j = 0; j < mat[i].length; j++) {
						mat[i][j] += minValorDescobert;
				}
			}
		}

		// Resta el minimi valor de totes les columnes descobertess
		for (int i = 0; i < ColsCobertes.length; i++) {
			if (0 == ColsCobertes[i]) {
				for (int j = 0; j < mat.length; j++) {
					mat[j][i] -= minValorDescobert;
				}
			}
		}
	}
}