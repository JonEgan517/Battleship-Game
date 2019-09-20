import java.util.Scanner;

public class Battleship 
{
    public static void main(String[] args)
    {
        Scanner intInput = new Scanner(System.in);
        int [][] board = new int [5][5];
        int [][] ship = new int [4][2];
        int [] shot = new int[2];
        boolean done = false;
        resetboard(board);
        System.out.println("Welcome to Battleship!");
        while(!done)
        {   
            displayBoard(board);
            displayMenu();
            
            for(int i = 0 ; i  < 4 ; i ++)
            {
                ship[i][0] = (int) Math.random() * 5 + 1;
                ship[i][1] = (int) Math.random() * 5 + 1;
            }
            
            int choice = getMenuInput(intInput);       
            
            if(choice == 1)
            {   
                getRow(shot);
                getColumn(shot);
                
                if(fireShot(shot,ship) == true)
                {
                    board[shot[0]][shot[1]] = 1;
                }
                
                else
                {
                    board[shot[0]][shot[1]] = 0;
                }
            }
            
            else if (choice == 2)
            {
                done = true;
                System.out.println("Thanks For Playing");
            }
        }

    }
    
    public static void displayBoard(int [][] board)
    {
        System.out.println("  A B C D E");
        
        for(int i = 0; i < 5; i++)
        { 
            System.out.print((i + 1) + "");
            
            for(int j = 0; j < 5; j++)
            {
            	if(board[i][j] == -1)
                {
                    System.out.print(" -");
                }
                
            	else if(board[i][j] == 0)
                {
                    System.out.print(" M");
                }
                
            	else if(board[i][j] == 1)
                {
                    System.out.print(" X");
                }
            }
            System.out.println("");
        }

    }
   
    public static void resetboard(int[][] board)
    {
        for(int row = 0 ; row < 5 ; row++ )
        {
            for(int col = 0 ; col < 5 ; col++ )
            {
                board[row][col] = -1;
            }
        }
    }
    
    public static void displayMenu()
    {
        System.out.println("\nMenu:");
        System.out.println("1. Fire Shot");
        System.out.println("2. Quit");
    }
    
    public static int getMenuInput(Scanner intInput)
    {
        int input = 0;
        
        if(intInput.hasNextInt())
        {
            input = intInput.nextInt();
            
            if(input > 0 && input < 4)
            {
                input = input;            
            }
            else 
            {
                System.out.println("Invalid Entry, Please Try Again.\n");
            }
        }
        else 
        {
            System.out.println("Invalid Entry, Please Try Again.\n");
            intInput.nextInt();
        }
        return input;
    }

    public static void getRow(int [] shot)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Row Number: ");
        shot[0] = shotValid(input);
        shot[0]--;
    }
    
    public static void getColumn(int [] shot)
    {
        Scanner intInput = new Scanner(System.in);
        int numb = 0;
        System.out.println("Enter a Column Letter: ");
        String choice = intInput.next();
        
        if (choice.equals("A"))
        {
            numb = 0;
        }
        
        else if(choice.equals("B"))
        {
            numb = 1;
        }
        
        else if( choice.equals("C"))
        {
            numb = 2;
        }
        
        else if(choice.equals("D"))
        {
            numb = 3;
        }
        
        else if(choice.equals("E"))
        {
            numb = 4;  
        }
        
        else
        {
            System.out.println("Invalid Entry, Please Try Again.\n");
            intInput.nextLine();
        }
        shot[1] = numb;
    }

    public static boolean fireShot(int [] shot, int [][]ship)
    {
        boolean result = false;
        
        for(int i = 0 ; i < ship.length ; i++)
        {
            if( shot[0] == ship[i][0] && shot[1] == ship[i][1])
            {
                result = true;
            }
            
            else
            {
                result = false;
            }
        }
        return result;
    }
    public static int shotValid(Scanner intInput)
    {
        int shot = 0;
        boolean done = false;
        while(!done)
        {
            if(intInput.hasNextInt())
            {
                shot = intInput.nextInt();
                
                if(shot > 0 && shot < 6)
                {   
                    shot = shot;
                    done = true;
                }
                
                else 
                {
                    System.out.println("Invalid Entry, Please Try Again.\n");
                }
            }
            
            else 
            {
                System.out.println("Invalid Entry, Please Try Again.\n");
                intInput.next();
            }
        }
        return shot;
    }
}