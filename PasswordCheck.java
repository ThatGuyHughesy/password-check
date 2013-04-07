import java.io.*;
import java.util.*;

class PasswordCheck
{
	public static void main (String [] args)
	{
		System.out.println("Please Enter Password: ");
		Password p = new Password();
		Check c = new Check();
		
		p.getPassword();
		c.length(p);
		//set required length
		c.specialCharacters(p);
		//check if password contains any special character or a number of special characters
		c.digits(p);
		//check if password contains a digit or a number of digits
		c.alphabet(p);
		//check if password contains specific letter or letters
		//check if password begins with uppercase
		c.result(p);
	}
}

class Password
{
	String password;
	Scanner in = new Scanner(System.in);
	
	void getPassword()
	{
		try 
		{
			password = in.nextLine();
		} catch(Exception e) 
		{
			System.out.println("Input Error");
			e.printStackTrace();
		}
	}
}

class Check
{
	boolean length, special, digit, letter;
	
	void length(Password p)
	{
		if(p.password.length() == 5) //enter required length
		{
			length = true;
		}
	}
	
	void specialCharacters(Password p)
	{
		char [] characters = {'@'}; //enter special characters here 
		for(int i = 0; i < p.password.length(); i++)
		{
			for(int j = 0; j < characters.length; j++)
			{
				if(p.password.charAt(i) == characters[j])
				{
					special = true;
				}
			}
		}
		//if you require more than one special character in password
		/*
		int charCount;
		for(int i = 0; i < p.password.length(); i++)
		{
			for(int j = 0; j < characters.length; j++)
			{
				if(p.password.charAt(i) == characters[j])
				{
					charCount++;
				}
			}
		}
		if(charCount >= 0)//insert required amount
		{
			special = true;
		}
		*/
	}
	
	void digits(Password p)
	{
		for(int k = 0; k < p.password.length(); k++)
		{
				if(Character.isDigit(p.password.charAt(k)))
				{
					digit= true;
				}
		}
		//if you require more than one number in password
		/*
		int digitCount;
		for(int k = 0; k < p.password.length(); k++)
		{
				if(Character.isDigit(p.password.charAt(k)))
				{
					digitCount++;
				}
			}
		}
		if(digitCount >= 0)//insert required amount
		{
			digit = true;
		}
		*/
	}
	
	void alphabet(Password p)
	{
		char [] letters = {'D'}; //enter letters here 
		for(int l = 0; l < p.password.length(); l++)
		{
			for(int m = 0; m < letters.length; m++) //&& Character.isUpperCase(p.password.charAt(0)) //if first character should be uppercase
			{
				if(p.password.charAt(l) == letters[m])
				{
					letter = true;
				}
			}
		}
		//if you require more than one specific letter
		/*
		int letterCount;
		for(int l = 0; l < p.password.length(); l++)
		{
			for(int m = 0; m < letters.length; m++) //&& Character.isUpperCase(p.password.charAt(0)) //if first character should be uppercase
			{
				if(p.password.charAt(l) == letters[m])
				{
					letterCount++;
				}
			}
		}
		if(letterCount > 0)//insert required amount
		{
			letter = true;
		}
		*/
	}
	
	void result(Password p)
	{
		if(length == true && special == true && digit == true && letter == true)
		{
			System.out.println("Password Is Valid");
		}
		
		else
		{
			System.out.println("Password Is Invalid");
		}
	}
}