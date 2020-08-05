package co.edureka.selenium.webdriver.basic;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class launchbrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		////--------window show---
		final JFrame parent = new JFrame();
        JButton button = new JButton();

        button.setText("Click me to show dialog!");
        parent.add(button);
        parent.pack();
        parent.setVisible(true);

        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name = JOptionPane.showInputDialog(parent,
                        "Local Host Adress:", null);
                
                System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
        		WebDriver driver = new ChromeDriver(); //initiate using we driver
        		//driver.get("http://192.168.1.94:8084/tigerhrm-client"); //get this path; http must be written
        		driver.get(name);
        		
        		System.out.println(driver.getCurrentUrl()); //URL detail printed in console
        		System.out.println(driver.getTitle()); //will show up page title in console
        	
        		driver.manage().window().maximize(); //loads full sized window
        		
        		//----------------------------LOGIN TO HRMS--------------------------------
        		
        		//getWebElement(driver,"/html/body/div[2]/div[2]/form/div[1]/input").click();
        		//getWebElement(driver,"/html/body/div[2]/div[2]/form/div[1]/input").sendKeys("admin@tigerit.com"); //pass email/username
        		
        		//---------------------file read--------------
        		String line = null;
        		
        		Path path = Paths.get(".\\password.txt");
        		try {
        			line = Files.readAllLines(path).get(0);
        		} catch (IOException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        		}
        		
        		//void function
        		
        		//function1----------------------------------------------------------
        		//----------------random string---------------------------
        		firstname(driver);
        		gender(driver);
        		dobdate(driver);
        		dobmonth(driver);
        		dobyear(driver);
        		age(driver);
        		email(driver);
        		phone(driver);
        		nid(driver);
        		username(driver);
        		password(driver);
        		confirmpassword(driver);
        		//--------------------------------------------------------------------
        		
        		//function3------------------------------------------------
        		//file append
        		//---------------------------------------------------------
        		
        	    
        		//getWebElementByXpath(driver,"//*[@id=\"exampleInputPassword2\"]").click();
        		
        		
        		
        	    
        		getWebElementByXpath(driver,("//*[@id=\"exampleInputPassword2\"]")).sendKeys(line); //input password
        		getWebElementByXpath(driver,("/html/body/div[2]/div[2]/form/div[2]/div[2]/div[1]/button/i")).click(); //clicks the login button
            }
        });
        
		
		
		//--------------------------LOGOUT FROM HRMS------------------------------
		
		//getWebElementByXpath(driver,"/html/body/section[1]/header/div[2]/ul/li/a").click();
		
		//driver.findElement(By.xpath("/html/body/section[1]/header/div[2]/ul/li/ul/li[3]/a")).click();
		
		
		//...................***Forget Password***
		
		//	driver.findElement(By.xpath("html/body/div[2]/div[2]/form/div[2]/div[2]/div[2]/span/a/span")).click(); //Forget password
			//driver.quit();

	}
	
	private static void confirmpassword(WebDriver driver) {
		
		
		String name= "ABcd@fgh";
	    System.out.println(name);

		getWebElementByName(driver,"confirm_password").sendKeys(name);
		WebElement a=driver.findElement(By.className("help-block"));//capture response
		//System.out.println(a.getText());//print response
		//-----------check input-----------------
		if(a.getText().isEmpty())
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write("Confirm Password:\n");
					br.write(name+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}
		}
		
		//max-------
		byte[] array1 = new byte[16]; // length is bounded by max
	    new Random().nextBytes(array1);
	    String generatedString1 = new String(array1, Charset.forName("UTF-8"));
		String name1=generatedString1.replaceAll("[^[ A-Za-z0-9_@./#&+-]]", "y");
	    System.out.println(name1);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"confirm_password").sendKeys(name1);
		WebElement a1=driver.findElement(By.className("help-block"));//capture response
		
		if(a1.getCssValue("display")=="none")
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name1+" IS ACCEPTED \n\n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name1+" IS NOT ACCEPTED \n\n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
	}

	private static void password(WebDriver driver) {
		int min=0,max=0,avg=0;
		try {
		      File myObj = new File("password.txt");
		      Scanner myReader = new Scanner(myObj);
		      int i=0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(i==0)
		        	min=Integer.parseInt(data);
		        else if(i==1)
		        	max=Integer.parseInt(data);
		        i++;
		      }
		      System.out.println(min);
		      System.out.println(max);
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		byte[] array = new byte[min]; // length is bounded by min
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
		String name=generatedString.replaceAll("[^[ A-Za-z0-9_@./#&+-]]", "s");
	    System.out.println(name);

		getWebElementByName(driver,"user_password").sendKeys(name);
		WebElement a=driver.findElement(By.className("help-block"));//capture response
		//System.out.println(a.getText());//print response
		//-----------check input-----------------
		if(a.getText().isEmpty())
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write("Password:\n");
					br.write(name+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}
		}
		
		//max-------
		byte[] array1 = new byte[max]; // length is bounded by max
	    new Random().nextBytes(array1);
	    String generatedString1 = new String(array1, Charset.forName("UTF-8"));
		String name1=generatedString1.replaceAll("[^[ A-Za-z0-9_@./#&+-]]", "y");
	    System.out.println(name1);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"user_password").sendKeys(name1);
		WebElement a1=driver.findElement(By.className("help-block"));//capture response
		
		if(a1.getText().isEmpty())
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name1+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name1+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
		///-----min-1-----
		byte[] array2 = new byte[min-1]; // length is bounded by min-1
	    new Random().nextBytes(array2);
	    String generatedString2 = new String(array2, Charset.forName("UTF-8"));
		String name2=generatedString2.replaceAll("[^[ A-Za-z0-9_@./#&+-]]", "b");
	    System.out.println(name2);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"user_password").sendKeys(name2);
		WebElement a2=driver.findElement(By.className("help-block"));//capture response
		
		if(a2.getCssValue("display")=="none")
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name2+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name2+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
		///---max+1----
		byte[] array3 = new byte[max+1]; // length is bounded by max+1
	    new Random().nextBytes(array3);
	    String generatedString3 = new String(array3, Charset.forName("UTF-8"));
		String name3=generatedString3.replaceAll("[^[ A-Za-z0-9_@./#&+-]]", "c");
	    System.out.println(name3);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"user_password").sendKeys(name3);
		WebElement a3=driver.findElement(By.className("help-block"));//capture response
		
		if(a3.getCssValue("display")=="none")
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name3+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name3+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
		///----avg---
		
		String name4="ABcd@fgh";
	    System.out.println(name4);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"user_password").sendKeys(name4);
		WebElement a4=driver.findElement(By.className("help-block"));//capture response
		
		if(a4.getText().isEmpty())
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name4+" IS ACCEPTED \n\n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name4+" IS NOT ACCEPTED \n\n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
	}

	private static void username(WebDriver driver) {
		int min=0,max=0,avg=0;
		try {
		      File myObj = new File("username.txt");
		      Scanner myReader = new Scanner(myObj);
		      int i=0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(i==0)
		        	min=Integer.parseInt(data);
		        else if(i==1)
		        	max=Integer.parseInt(data);
		        i++;
		      }
		      System.out.println(min);
		      System.out.println(max);
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		byte[] array = new byte[min]; // length is bounded by min
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
		String name=generatedString.replaceAll("[^A-Za-z]", "s");
	    System.out.println(name);
		//-----------------------------------------------------------------
		
		
		//function 2----------------------------------------------------------
		//-----------------------------------------input name----------------------
		getWebElementByName(driver,"user_name").sendKeys(name);
		WebElement a=driver.findElement(By.className("help-block"));//capture response
		//System.out.println(a.getText());//print response
		//-----------check input-----------------
		if(a.getText().isEmpty())
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write("Username:\n");
					br.write(name+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}
		}
		
		//max-------
		byte[] array1 = new byte[max]; // length is bounded by max
	    new Random().nextBytes(array1);
	    String generatedString1 = new String(array1, Charset.forName("UTF-8"));
		String name1=generatedString1.replaceAll("[^A-Za-z]", "y");
	    System.out.println(name1);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"user_name").sendKeys(name1);
		WebElement a1=driver.findElement(By.className("help-block"));//capture response
		
		if(a1.getText().isEmpty())
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name1+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name1+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
		///-----min-1-----
		byte[] array2 = new byte[min-1]; // length is bounded by min-1
	    new Random().nextBytes(array2);
	    String generatedString2 = new String(array2, Charset.forName("UTF-8"));
		String name2=generatedString2.replaceAll("[^A-Za-z]", "b");
	    System.out.println(name2);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"user_name").sendKeys(name2);
		WebElement a2=driver.findElement(By.className("help-block"));//capture response
		
		if(a2.getCssValue("display")=="none")
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name2+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name2+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
		///---max+1----
		byte[] array3 = new byte[max+1]; // length is bounded by max+1
	    new Random().nextBytes(array3);
	    String generatedString3 = new String(array3, Charset.forName("UTF-8"));
		String name3=generatedString3.replaceAll("[^A-Za-z]", "c");
	    System.out.println(name3);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"user_name").sendKeys(name3);
		WebElement a3=driver.findElement(By.className("help-block"));//capture response
		
		if(a3.getCssValue("display")=="none")
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name3+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name3+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
		///----avg---
		avg = (min+max)/2;
		byte[] array4 = new byte[avg]; // length is bounded by avg
	    new Random().nextBytes(array4);
	    String generatedString4 = new String(array4, Charset.forName("UTF-8"));
		String name4=generatedString4.replaceAll("[^A-Za-z]", "D");
	    System.out.println(name4);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"user_name").sendKeys(name4);
		WebElement a4=driver.findElement(By.className("help-block"));//capture response
		
		if(a4.getText().isEmpty())
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name4+" IS ACCEPTED \n\n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name4+" IS NOT ACCEPTED \n\n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
	}

	private static void nid(WebDriver driver) {
		byte[] array = new byte[13]; // length is bounded by 13
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
		String name=generatedString.replaceAll("[^0-9]", "3");
	    System.out.println(name);
		//-----------------------------------------------------------------
		
		
		//function 2----------------------------------------------------------
		//-----------------------------------------input name----------------------
		getWebElementByName(driver,"nid").sendKeys(name);
		WebElement a=driver.findElement(By.className("help-block"));//capture response
		//System.out.println(a.getText());//print response
		//-----------check input-----------------
		if(a.getText().isEmpty())
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write("NID:\n");
					br.write(name+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}
		}
		
		byte[] array1 = new byte[10]; // length is bounded by 10
	    new Random().nextBytes(array1);
	    String generatedString1 = new String(array1, Charset.forName("UTF-8"));
		String name1=generatedString1.replaceAll("[^0-9]", "3");
	    System.out.println(name1);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"nid").sendKeys(name1);
		WebElement a1=driver.findElement(By.className("help-block"));//capture response
		
		if(a1.getText().isEmpty())
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name1+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name1+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
		byte[] array2 = new byte[17]; // length is bounded by 17
	    new Random().nextBytes(array2);
	    String generatedString2 = new String(array2, Charset.forName("UTF-8"));
		String name2=generatedString2.replaceAll("[^0-9]", "3");
	    System.out.println(name2);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"nid").sendKeys(name2);
		WebElement a2=driver.findElement(By.className("help-block"));//capture response
		
		if(a2.getText().isEmpty())
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name2+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name2+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
		byte[] array3 = new byte[18]; // length is bounded by 18
	    new Random().nextBytes(array3);
	    String generatedString3 = new String(array3, Charset.forName("UTF-8"));
		String name3=generatedString3.replaceAll("[^0-9]", "3");
	    System.out.println(name3);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"nid").sendKeys(name3);
		WebElement a3=driver.findElement(By.className("help-block"));//capture response
		
		if(a3.getCssValue("display")=="none")
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name3+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name3+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
		byte[] array4 = new byte[9]; // length is bounded by min-1
	    new Random().nextBytes(array4);
	    String generatedString4 = new String(array4, Charset.forName("UTF-8"));
		String name4=generatedString4.replaceAll("[^0-9]", "3");
	    System.out.println(name4);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"nid").sendKeys(name4);
		WebElement a4=driver.findElement(By.className("help-block"));//capture response
		
		if(a4.getCssValue("display")=="none")
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name4+" IS ACCEPTED \n\n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name4+" IS NOT ACCEPTED \n\n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
	}

	private static void phone(WebDriver driver) {
		int min=0,max=0,avg=0;
		try {
		      File myObj = new File("phone.txt");
		      Scanner myReader = new Scanner(myObj);
		      int i=0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(i==0)
		        	min=Integer.parseInt(data);
		        else if(i==1)
		        	max=Integer.parseInt(data);
		        i++;
		      }
		      System.out.println(min);
		      System.out.println(max);
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		byte[] array = new byte[min]; // length is bounded by min
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
		String name=generatedString.replaceAll("[^0-9]", "2");
	    System.out.println(name);
		//-----------------------------------------------------------------
		
		
		//function 2----------------------------------------------------------
		//-----------------------------------------input name----------------------
		getWebElementByName(driver,"contact_no").sendKeys(name);
		WebElement a=driver.findElement(By.className("help-block"));//capture response
		//System.out.println(a.getText());//print response
		//-----------check input-----------------
		if(a.getText().isEmpty())
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write("Phone:\n");
					br.write(name+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}
		}
		
		//max-------
		byte[] array1 = new byte[max]; // length is bounded by max
	    new Random().nextBytes(array1);
	    String generatedString1 = new String(array1, Charset.forName("UTF-8"));
		String name1=generatedString1.replaceAll("[^0-9]", "2");;
	    System.out.println(name1);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"contact_no").sendKeys(name1);
		WebElement a1=driver.findElement(By.className("help-block"));//capture response
		
		if(a1.getText().isEmpty())
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name1+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name1+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
		///-----min-1-----
		byte[] array2 = new byte[min-1]; // length is bounded by min-1
	    new Random().nextBytes(array2);
	    String generatedString2 = new String(array2, Charset.forName("UTF-8"));
		String name2=generatedString2.replaceAll("[^0-9]", "2");;
	    System.out.println(name2);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"contact_no").sendKeys(name2);
		WebElement a2=driver.findElement(By.className("help-block"));//capture response
		
		if(a2.getCssValue("display")=="none")
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name2+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name2+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
		///---max+1----
		byte[] array3 = new byte[max+1]; // length is bounded by max+1
	    new Random().nextBytes(array3);
	    String generatedString3 = new String(array3, Charset.forName("UTF-8"));
		String name3=generatedString3.replaceAll("[^0-9]", "2");;
	    System.out.println(name3);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"contact_no").sendKeys(name3);
		WebElement a3=driver.findElement(By.className("help-block"));//capture response
		
		if(a3.getCssValue("display")=="none")
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name3+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name3+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
		///----avg---
		avg = (min+max)/2;
		byte[] array4 = new byte[avg]; // length is bounded by avg
	    new Random().nextBytes(array4);
	    String generatedString4 = new String(array4, Charset.forName("UTF-8"));
		String name4=generatedString4.replaceAll("[^0-9]", "2");;
	    System.out.println(name4);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"contact_no").sendKeys(name4);
		WebElement a4=driver.findElement(By.className("help-block"));//capture response
		
		if(a4.getText().isEmpty())
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name4+" IS ACCEPTED \n\n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name4+" IS NOT ACCEPTED \n\n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
	}

	private static void email(WebDriver driver) {
		String name = "abcd@gmail.com";
	    System.out.println(name);
		
		getWebElementByName(driver,"email").sendKeys(name);
		WebElement a = driver.findElement(By.className("help-block"));
		if(a.getText().isEmpty())
		{
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write("Email:\n");
				br.write(name+" IS ACCEPTED \n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}      
	     
		}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name+" IS NOT ACCEPTED \n");
	
				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
		
		}
		
		
		////// -------
		String name1 = "abcdmailcom";
	    System.out.println(name1);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"email").sendKeys(name1);
		WebElement a1 = driver.findElement(By.className("help-block"));//capture response
	      // System.out.println(element.getText());
		//System.out.println(a1);//print response
		
		if(a1.getCssValue("display")=="none")
			{
				try{     
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name1+" IS ACCEPTED \n\n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}
				
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name1+" IS NOT ACCEPTED \n\n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
	    
		
	}

	private static void age(WebDriver driver) {
		int min=0, max=0, avg= 0;
		try {
		      File myObj = new File("age.txt");
		      Scanner myReader = new Scanner(myObj);
		      int i=0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(i==0)
		        	min=Integer.parseInt(data);
		        else if(i==1)
		        	max=Integer.parseInt(data);
		        i++;
		      }
		      System.out.println(min);
		      System.out.println(max);
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		String name = Integer.toString(min);
	    System.out.println(name);
		
		getWebElementByName(driver,"age").sendKeys(name);
		WebElement a=driver.findElement(By.className("help-block"));//capture response
		
		if(a.getText().isEmpty())
		{
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write("Age:\n");
				br.write(name+" IS ACCEPTED \n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}      
	     
		}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name+" IS NOT ACCEPTED \n");
	
				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
		
		}
		
		//max-------
				String name1 = Integer.toString(max);
			    System.out.println(name1);
				
			    driver.navigate().refresh();
				getWebElementByName(driver,"age").sendKeys(name1);
				WebElement a1=driver.findElement(By.className("help-block"));//capture response
				
				if(a1.getText().isEmpty())
					{
						try{    
							File file = new File("script.txt");
							FileWriter fr = new FileWriter(file, true);
							BufferedWriter br = new BufferedWriter(fr);
							br.write(name1+" IS ACCEPTED \n");

							br.close();
							fr.close();    
				          }catch(Exception e){System.out.println(e);}      
				     
					}
				else {
					try{    
						File file = new File("script.txt");
						FileWriter fr = new FileWriter(file, true);
						BufferedWriter br = new BufferedWriter(fr);
						br.write(name1+" IS NOT ACCEPTED \n");

						br.close();
						fr.close();    
				          }catch(Exception e){System.out.println(e);}
					
					}
				
				///-----min-1-----
				int min1=min-1;
				String name2 = Integer.toString(min1);
			    System.out.println(name2);
				
			    driver.navigate().refresh();
				getWebElementByName(driver,"age").sendKeys(name2);
				WebElement a2=driver.findElement(By.className("help-block"));//capture response
				
				if(a2.getCssValue("display")=="none")
					{
						try{    
							File file = new File("script.txt");
							FileWriter fr = new FileWriter(file, true);
							BufferedWriter br = new BufferedWriter(fr);
							br.write(name2+" IS ACCEPTED \n");

							br.close();
							fr.close();    
				          }catch(Exception e){System.out.println(e);}      
				     
					}
				else {
					try{    
						File file = new File("script.txt");
						FileWriter fr = new FileWriter(file, true);
						BufferedWriter br = new BufferedWriter(fr);
						br.write(name2+" IS NOT ACCEPTED \n");

						br.close();
						fr.close();    
				          }catch(Exception e){System.out.println(e);}
					
					}
				
				///---max+1----
				int max1 = max+1;
				String name3 = Integer.toString(max1);
			    System.out.println(name3);
				
			    driver.navigate().refresh();
				getWebElementByName(driver,"age").sendKeys(name3);
				WebElement a3=driver.findElement(By.className("help-block"));//capture response
				
				if(a3.getCssValue("display")=="none")
					{
						try{    
							File file = new File("script.txt");
							FileWriter fr = new FileWriter(file, true);
							BufferedWriter br = new BufferedWriter(fr);
							br.write(name3+" IS ACCEPTED \n");

							br.close();
							fr.close();    
				          }catch(Exception e){System.out.println(e);}      
				     
					}
				else {
					try{    
						File file = new File("script.txt");
						FileWriter fr = new FileWriter(file, true);
						BufferedWriter br = new BufferedWriter(fr);
						br.write(name3+" IS NOT ACCEPTED \n");

						br.close();
						fr.close();    
				          }catch(Exception e){System.out.println(e);}
					
					}
				
				///----avg---
				avg = (min+max)/2;
				String name4 = Integer.toString(avg);
			    System.out.println(name4);
				
			    driver.navigate().refresh();
				getWebElementByName(driver,"age").sendKeys(name4);
				WebElement a4=driver.findElement(By.className("help-block"));//capture response
				
				if(a4.getText().isEmpty())
					{
						try{    
							File file = new File("script.txt");
							FileWriter fr = new FileWriter(file, true);
							BufferedWriter br = new BufferedWriter(fr);
							br.write(name4+" IS ACCEPTED \n\n");

							br.close();
							fr.close();    
				          }catch(Exception e){System.out.println(e);}      
				     
					}
				else {
					try{    
						File file = new File("script.txt");
						FileWriter fr = new FileWriter(file, true);
						BufferedWriter br = new BufferedWriter(fr);
						br.write(name4+" IS NOT ACCEPTED \n\n");

						br.close();
						fr.close();    
				          }catch(Exception e){System.out.println(e);}
					
					}
		
	}

	private static void dobyear(WebDriver driver) {
		Random r = new Random();
	    int yer =  r.nextInt((2020 - 1800) + 1) + 1800;
	    String year = Integer.toString(yer);
	    System.out.println(year); 
		
		getWebElementByName(driver,"year").sendKeys(year);
		WebElement a=driver.findElement(By.className("help-block"));//capture response
		if(a.getText().isEmpty())
		{
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write("Year:\n");
				br.write(year+" IS ACCEPTED \n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}      
	     
		}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write("Year:\n");
				br.write(year+" IS NOT ACCEPTED \n");
	
				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
		
		}
		
		String year1 = "20214";
		driver.navigate().refresh();
		getWebElementByName(driver,"year").sendKeys(year1);
		WebElement a11=driver.findElement(By.className("help-block"));//capture response
		if(a11.getCssValue("display")=="none")
		{
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(year1+" IS ACCEPTED \n\n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}      
	     
		}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(year1+" IS NOT ACCEPTED \n\n");
				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
		
		}
		
	}

	private static void dobmonth(WebDriver driver) {
		String date = "1";
	    System.out.println(date);
		
		getWebElementByName(driver,"month").sendKeys(date);
		WebElement a=driver.findElement(By.className("help-block"));//capture response
		if(a.getText().isEmpty())
		{
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write("Month:\n");
				br.write(date+" IS ACCEPTED \n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}      
	     
		}
	else {
		try{    
			File file = new File("script.txt");
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(date+" IS NOT ACCEPTED \n");

			br.close();
			fr.close();    
	          }catch(Exception e){System.out.println(e);}
		
		}
		
		////---max----
		String date1 = "12";
	    System.out.println(date1);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"month").sendKeys(date1);
		WebElement a1=driver.findElement(By.className("help-block"));//capture response
		if(a1.getText().isEmpty())
		{
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(date1+" IS ACCEPTED \n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}      
	     
		}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(date1+" IS NOT ACCEPTED \n");
	
				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
		
		}
		
		///--min-1---
		String date2 = "0";
	    System.out.println(date2);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"month").sendKeys(date2);
		WebElement a2=driver.findElement(By.className("help-block"));//capture response
		if(a2.getCssValue("display")=="none")
		{
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(date2+" IS ACCEPTED \n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}      
	     
		}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(date2+" IS NOT ACCEPTED \n");
	
				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
		
		}
		
		///---max+1-----
		String date3 = "13";
	    System.out.println(date3);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"month").sendKeys(date3);
		WebElement a3=driver.findElement(By.className("help-block"));//capture response
		if(a3.getCssValue("display")=="none")
		{
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(date3+" IS ACCEPTED \n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}      
	     
		}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(date3+" IS NOT ACCEPTED \n");
	
				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
		
		}
		
		///----avg----
		String date4 = "6";
	    System.out.println(date4);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"month").sendKeys(date4);
		WebElement a4=driver.findElement(By.className("help-block"));//capture response
		if(a4.getText().isEmpty())
		{
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(date4+" IS ACCEPTED \n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}      
	     
		}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(date4+" IS NOT ACCEPTED \n");
	
				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
		
		}
		
	}

	private static void dobdate(WebDriver driver) {
		
	    String date = "1";
	    System.out.println(date);
		
		getWebElementByName(driver,"date").sendKeys(date);
		WebElement a=driver.findElement(By.className("help-block"));//capture response
		if(a.getText().isEmpty())
		{
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write("DOB: \n date:\n");
				br.write(date+" IS ACCEPTED \n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}      
	     
		}
	else {
		try{    
			File file = new File("script.txt");
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(date+" IS NOT ACCEPTED \n");

			br.close();
			fr.close();    
	          }catch(Exception e){System.out.println(e);}
		
		}
		
		////---max----
		String date1 = "31";
	    System.out.println(date1);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"date").sendKeys(date1);
		WebElement a1=driver.findElement(By.className("help-block"));//capture response
		if(a1.getText().isEmpty())
		{
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(date1+" IS ACCEPTED \n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}      
	     
		}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(date1+" IS NOT ACCEPTED \n");
	
				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
		
		}
		
		///--min-1---
		String date2 = "0";
	    System.out.println(date2);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"date").sendKeys(date2);
		WebElement a2=driver.findElement(By.className("help-block"));//capture response
		if(a2.getCssValue("display")=="none")
		{
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(date2+" IS ACCEPTED \n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}      
	     
		}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(date2+" IS NOT ACCEPTED \n");
	
				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
		
		}
		
		///---max+1-----
		String date3 = "32";
	    System.out.println(date3);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"date").sendKeys(date3);
		WebElement a3=driver.findElement(By.className("help-block"));//capture response
		if(a3.getCssValue("display")=="none")
		{
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(date3+" IS ACCEPTED \n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}      
	     
		}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(date3+" IS NOT ACCEPTED \n");
	
				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
		
		}
		
		///----avg----
		String date4 = "16";
	    System.out.println(date4);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"date").sendKeys(date4);
		WebElement a4=driver.findElement(By.className("help-block"));//capture response
		if(a4.getText().isEmpty())
		{
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(date4+" IS ACCEPTED \n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}      
	     
		}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(date4+" IS NOT ACCEPTED \n");
	
				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
		
		}
		
	}

	private static void gender(WebDriver driver) {
		WebElement radio1 = driver.findElement(By.id("male"));
		radio1.click();
		WebElement a=driver.findElement(By.className("help-block"));//capture response
		//System.out.println(a.getText());//print response
		//-----------check input-----------------
		if(a.getText().isEmpty())
		{
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write("Gender: \n");
				br.write("Male IS ACCEPTED \n\n");

				br.close();
				fr.close();    
	          }catch(Exception e){System.out.println(e);}      
	     
		}
	else {
		try{    
			File file = new File("script.txt");
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write("Male IS NOT ACCEPTED \n\n");

			br.close();
			fr.close();    
	          }catch(Exception e){System.out.println(e);}
		
		}
		
	}

	private static void firstname(WebDriver driver) {
		int min=0,max=0,avg=0;
		try {
		      File myObj = new File("firstname.txt");
		      Scanner myReader = new Scanner(myObj);
		      int i=0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(i==0)
		        	min=Integer.parseInt(data);
		        else if(i==1)
		        	max=Integer.parseInt(data);
		        i++;
		      }
		      System.out.println(min);
		      System.out.println(max);
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		byte[] array = new byte[min]; // length is bounded by min
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
		String name=generatedString.replaceAll("[^A-Za-z]", "z");
	    System.out.println(name);
		//-----------------------------------------------------------------
		
		
		//function 2----------------------------------------------------------
		//-----------------------------------------input name----------------------
		getWebElementByName(driver,"first_name").sendKeys(name);
		WebElement a=driver.findElement(By.className("help-block"));//capture response
		//System.out.println(a.getText());//print response
		//-----------check input-----------------
		if(a.getText().isEmpty())
			{
				try{    
		           FileWriter fw=new FileWriter("script.txt");    
		           fw.write(name+" IS ACCEPTED \n");    
		           fw.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
		           FileWriter fw=new FileWriter("script.txt");    
		           fw.write(name+" IS NOT ACCEPTED \n");    
		           fw.close();    
		          }catch(Exception e){System.out.println(e);}
		}
		
		//max-------
		byte[] array1 = new byte[max]; // length is bounded by max
	    new Random().nextBytes(array1);
	    String generatedString1 = new String(array1, Charset.forName("UTF-8"));
		String name1=generatedString1.replaceAll("[^A-Za-z]", "z");
	    System.out.println(name1);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"first_name").sendKeys(name1);
		WebElement a1=driver.findElement(By.className("help-block"));//capture response
		
		if(a1.getText().isEmpty())
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name1+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name1+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
		///-----min-1-----
		byte[] array2 = new byte[min-1]; // length is bounded by min-1
	    new Random().nextBytes(array2);
	    String generatedString2 = new String(array2, Charset.forName("UTF-8"));
		String name2=generatedString2.replaceAll("[^A-Za-z]", "z");
	    System.out.println(name2);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"first_name").sendKeys(name2);
		WebElement a2=driver.findElement(By.className("help-block"));//capture response
		
		if(a2.getText().isEmpty())
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name2+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name2+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
		///---max+1----
		byte[] array3 = new byte[max+1]; // length is bounded by max+1
	    new Random().nextBytes(array3);
	    String generatedString3 = new String(array3, Charset.forName("UTF-8"));
		String name3=generatedString3.replaceAll("[^A-Za-z]", "z");
	    System.out.println(name3);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"first_name").sendKeys(name3);
		WebElement a3=driver.findElement(By.className("help-block"));//capture response
		
		if(a3.getText().isEmpty())
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name3+" IS ACCEPTED \n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name3+" IS NOT ACCEPTED \n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
		///----avg---
		avg = (min+max)/2;
		byte[] array4 = new byte[avg]; // length is bounded by avg
	    new Random().nextBytes(array4);
	    String generatedString4 = new String(array4, Charset.forName("UTF-8"));
		String name4=generatedString4.replaceAll("[^A-Za-z]", "z");
	    System.out.println(name4);
		
	    driver.navigate().refresh();
		getWebElementByName(driver,"first_name").sendKeys(name4);
		WebElement a4=driver.findElement(By.className("help-block"));//capture response
		
		if(a4.getText().isEmpty())
			{
				try{    
					File file = new File("script.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(name4+" IS ACCEPTED \n\n");

					br.close();
					fr.close();    
		          }catch(Exception e){System.out.println(e);}      
		     
			}
		else {
			try{    
				File file = new File("script.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(name4+" IS NOT ACCEPTED \n\n");

				br.close();
				fr.close();    
		          }catch(Exception e){System.out.println(e);}
			
			}
		
	}

	private static WebElement getWebElementByXpath(WebDriver driver,String path)
	{
		return driver.findElement(By.xpath(path));
	}
	
	private static WebElement getWebElementByName(WebDriver driver,String fieldName)
	{
		return driver.findElement(By.name(fieldName));
	}
	
	@SuppressWarnings("unused")
	private static WebElement getWebElementByCSSField(WebDriver driver,String fieldName)
	{
		return driver.findElement(By.name(fieldName));
	}

}
