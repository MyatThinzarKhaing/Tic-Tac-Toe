import java.util.Scanner;
public class TicTacPlayerModeAdv{
	public static void main(String[] args){
		char arr[][]=new char[3][3];

		//Initializing with space
		for(int i=0; i<3 ; i++){
			for(int j=0 ;j<3;j++){
				arr[i][j] = ' ';
			}
		}
		Display(arr);

		int result=-1;
		for(int i=0; i<5 ;i++){
			result = WinLose(arr);
			//System.out.println("result = "+result);
			if(result==1 || result == 0)
				break;
			if(!InitialLeft(arr))
				break;

			ComputerMove(arr);
			Display(arr);

			result = WinLose(arr);
			if(result==1 || result == 0)
				break;
			if(!InitialLeft(arr))
				break;

			PlayerMove(arr);
			Display(arr);
		}
		if(result == 1)
			System.out.println("You Win");
		else if(result == 0)
			System.out.println("You Lose");
	}
	public static void Display(char[][] arr){
		for(int i=0; i<3 ; i++){
			for(int j=0 ;j<3;j++){
				System.out.printf("%2c |",arr[i][j]);
			}
			System.out.println();
		}
		System.out.println("................");
	}
	public static boolean Check(char[] arr){
		int temp = 1;
		for(int i=0;i<2;i++){
			if(arr[i]!=' ' && arr[i]==arr[i+1])
				continue;
			else
				temp = 0;
		}
		if(temp==1)
			return true;
		else
			return false;
	}
	public static char[][] ComputerMove(char[][] arr){
		int index1 = (int)(Math.random()*3);
		int index2 = (int)(Math.random()*3);
		if(arr[index1][index2]!=' ')
			ComputerMove(arr);
		else
			arr[index1][index2] = 'O';
		return arr;
	}
	public static char[][] PlayerMove(char[][] arr){
		Scanner input = new Scanner(System.in);
		System.out.println("Your Turn!! Please Enter the indexes, first one is for row index");
		int index1 = input.nextInt();
		int index2 = input.nextInt();
		//arr[index1][index2] = 'X';
		if(arr[index1][index2]!=' '){
			System.out.println("That place is already chosen");
			PlayerMove(arr);
		}
		else
			arr[index1][index2] = 'X';
		return arr;
	}
	public static int WinLose(char[][] arr){
		//Checking form rows
		for(int i=0; i<3 ; i++){
			char rowArr[] = new char[3];
			for(int j=0 ;j<3;j++){
				rowArr[j] = arr[i][j];
			}
			//System.out.println("check "+Check(rowArr));
			if(Check(rowArr)){
				return( (rowArr[0]=='X')? 1:0);
			}
		}

		//Checking form columns
		for(int i=0; i<3 ; i++){
			char colArr[] = new char[3];
			for(int j=0 ;j<3;j++){
				colArr[j] = arr[j][i];
			}
			if(Check(colArr)){
				return( (colArr[0]=='X')? 1:0);
			}
		}

		//Checking form main diagonal and other diagonal
		char subDarr[] = new char[3];
		char mainDarr[] = new char[3];
		int k=0,l=0;
		for(int i=0; i<3 ; i++){
			for(int j=0 ;j<3;j++){
				if(i==j)
					mainDarr[k++] = arr[i][j];
				if(i+j==2)
					subDarr[l++] = arr[i][j];
			}
		}
		if(Check(mainDarr)){
				return( (mainDarr[0]=='X')? 1:0);
			}
		if(Check(subDarr)){
				return( (subDarr[0]=='X')? 1:0);
			}

		return -1;
	}
	public static boolean InitialLeft(char[][] arr){
		for(int i=0; i<3 ; i++){
			for(int j=0 ;j<3;j++){
				if(arr[i][j]==' ')
					return true;
			}
		}
		return false;
	}
}