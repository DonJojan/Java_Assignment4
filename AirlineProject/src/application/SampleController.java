package application;

import java.io.BufferedReader;


import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javax.swing.JComboBox;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SampleController  implements Initializable{

    @FXML
    private Button b;

    @FXML
    private ListView<?> lv;   // declaring listview
    @FXML
    private ListView<?> lv1;
    @FXML
    private ComboBox  comb;
    
    @FXML
    private ComboBox comb1;
    @FXML
    private ComboBox comb2;

    @FXML
    private ComboBox comb3;

    @FXML
    private Label label;
    @FXML
    private RadioButton radio1;
    
    @FXML
    private ComboBox a;
    
    @FXML
    private RadioButton radio2;

    @FXML
    private RadioButton radio4;

    @FXML
    private RadioButton radio3;

    @FXML
    void airlineselect(ActionEvent event) {   // radio button function for airline 
    	if (radio2.isSelected() == true)
    		comb1.setDisable(false);
    	  comb2.setDisable(true);
 	     comb3.setDisable(true);
 	    
	     comb.setDisable(true);
	  
    	
    		ObservableList<String> list1 = FXCollections.observableArrayList("AC102","AC104","AC107","AC113","AI011");
    		comb1.setItems(list1);

    }

    @FXML
    void arrivalselect(ActionEvent event) {  // radio button function for arrival location
    	if (radio4.isSelected() == true)
    		comb3.setDisable(false);
    	 comb1.setDisable(true);
	     comb2.setDisable(true);
	     comb.setDisable(true);
    	
    		ObservableList<String> list2 = FXCollections.observableArrayList("YYZ","YVR","NRT");
    		comb3.setItems(list2);

    }
    
    @FXML
    private Button close;


    @FXML
    void closebtn(ActionEvent event) {
Platform.exit();
    }

    @FXML
    void depselect(ActionEvent event) {           // radio button function for depature location
    	if (radio3.isSelected() == true)
    		comb2.setDisable(false);
    	 comb1.setDisable(true);
	     comb.setDisable(true);
	     comb3.setDisable(true);
    	
    		ObservableList<String> list3 = FXCollections.observableArrayList("YVR","YYZ","YVR");
    		comb2.setItems(list3);

    }

    
  
    
    
  




    
    private ObservableList l = FXCollections.observableArrayList();  // declaring observable list
    private ObservableList l1 = FXCollections.observableArrayList();
    @FXML
    String Select(ActionEvent event) {                  // getting data from combo box
    	
    	String s ="";
    	s = comb.getSelectionModel().getSelectedItem().toString();
    
    	return s;
    }
    @FXML
    String Select1(ActionEvent event) {
    	String s1 = comb1.getSelectionModel().getSelectedItem().toString();
  
    	return s1;
    }

    @FXML
    String Select2(ActionEvent event) {
    	String s2 = comb2.getSelectionModel().getSelectedItem().toString();

    	return s2;

    }

    @FXML
    String Select3(ActionEvent event) {
    	
    	String s3 = comb3.getSelectionModel().getSelectedItem().toString();
   
    	return s3;
    

    }
   

    @FXML
    void radioselect(ActionEvent event) {
    	
    	if (radio1.isSelected() == true)
    		comb.setDisable(false);
    	     comb1.setDisable(true);
    	     comb2.setDisable(true);
    	     comb3.setDisable(true);
    
    		ObservableList<String> list = FXCollections.observableArrayList("Air Canada","Air India");
    		comb.setItems(list);
    		

    }
 


    @FXML
 void Click(MouseEvent event) {
    	
   	
	  System.out.println((String)lv.getSelectionModel().getSelectedItem());

    }
    
    
    
    @FXML
    void search(ActionEvent event) {

		String[] arr = new String[5]; 
		String str="";
		Path fp=Paths.get("p1.txt");
		
		try
		{
			//To open input stream
			FileReader fr=new FileReader("p1.txt");
			BufferedReader br=new BufferedReader(fr); // reading data from file
			String c;
	
	
			if(radio1.isSelected())       // checking if radio 1 is selected
			{
				lv.getItems().clear();
			
			 String a1=Select(event);
		
			int i=0,k=0;
			while((c=br.readLine())!=null)   // reading values from file and storing in array
			{
				
			    arr[i] = c;
			  
		
			    i++;
			}
			k=i;
			
			
			for(i=0;i<k;i++)
			{
	    
	    	if (arr[i].substring(0,10).equals("Air Canada"))
	    	{
	    		str = arr[i].substring(0,10);
	    		  arr[i]= arr[i].replace(",", "        ");  // formating array
	    		 
	    	
	    		 
	    	}
	    	else if (arr[i].substring(0,9).equals("Air India")){
	    	str = arr[i].substring(0,9);
	    	  arr[i]= arr[i].replace(",", "         ");
	  
	    	}
	    
	    
	    	 if(a1.equals(str))
	    	 {
	    		 
	    			l.add(arr[i]);
	    	    	lv.setItems(l);                     // writing into list view
	    	 }
			}
			
		
			
			}
			else 	if(radio2.isSelected())    // checking if radio 2 is selected
			{
				lv.getItems().clear();
				 String a2=Select1(event);
				  
				 
				  int i=0,k=0;
					while((c=br.readLine())!=null)
					{
					
					    arr[i] = c;
				
					    i++;
					}
					k=i;
				
					
					for(i=0;i<k;i++)
					{
						
			    
			    	if (arr[i].substring(0,10).equals("Air Canada"))
			    	{
			    		
			    		  arr[i]= arr[i].replace(",", "        ");
			  
			    		  str = arr[i].substring(18,23);
			    		  
			
			    	}
			    	else if (arr[i].substring(0,9).equals("Air India"))
			    			{
			    	
			    	  arr[i]= arr[i].replace(",", "         ");  // formatting array
			    
			    	 str = arr[i].substring(18,23);
			
			    	}
			 
			    	 
			    
			    	 if(a2.equals(str))
			    	 {
			    			l.add(arr[i]);
			    	    	lv.setItems(l);                // writing into list view
			    	 }
					}
					
				
			}
			else 	if(radio3.isSelected())
			{
				lv.getItems().clear();                   // clearing list view
				 String a3=Select2(event);
				  
				 
				  int i=0,k=0;
					while((c=br.readLine())!=null)
					{
					
					    arr[i] = c;
					  
					    i++;
					}
					k=i;
				
					
					for(i=0;i<k;i++)
					{
						
			    
			    	if (arr[i].substring(0,10).equals("Air Canada"))
			    	{
			    		 
			    		  arr[i]= arr[i].replace(",", "        ");  // formatting array
			  
			    		  str = arr[i].substring(31,34);
			   
			    	}
			    	else if (arr[i].substring(0,9).equals("Air India"))
			    			{
			    	
			    	  arr[i]= arr[i].replace(",", "          ");
			    	
			    
			    	 str = arr[i].substring(34,37);
			    	
			    	}
			    
			   
			    	 
			    
			    	 if(a3.equals(str))
			    	 {
			    			l.add(arr[i]);
			    	    	lv.setItems(l);           // writing into list view
			    	 }
					}
				
			}
			else if(radio4.isSelected())
			{
				lv.getItems().clear();
				 String a4=Select3(event);
				  
				 
				  int i=0,k=0;
					while((c=br.readLine())!=null)
					{
						
					    arr[i] = c;
				
					    i++;
					}
					k=i;
				
					
					for(i=0;i<k;i++)
					{
						
			    
			    	if (arr[i].substring(0,10).equals("Air Canada"))
			    	{
			    		
			    		  arr[i]= arr[i].replace(",", "        ");
			  
			    		  str = arr[i].substring(42,45);
			    		 
			    	
			    	}
			    	else if (arr[i].substring(0,9).equals("Air India"))
			    			{
			    	
			    	  arr[i]= arr[i].replace(",", "         ");
			    
			    	 str = arr[i].substring(44,47);
			    	
		
			    	}
			 
			    	 
			    
			    	 if(a4.equals(str))
			    	 {
			    			l.add(arr[i]);
			    	    	lv.setItems(l);            // writing into list view
			    	 }
					}
				
				
			}
			
	
			br.close();

		}
		catch(IOException e)
		{
			System.out.print("File is not there "+e);  // excemption if file not found
		}







    	

    }

    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String head= "Airline        Airline No   Departure    Arrival";
		l1.add(head);
    	lv1.setItems(l1);
		
		if (radio1.isSelected() == false)       // disabling radio button in the beginning
		comb.setDisable(true);
		
		ObservableList<String> list = FXCollections.observableArrayList("Air Canada","Air India");
		comb.setItems(list);
		
	
		if (radio2.isSelected() == false)
		comb1.setDisable(true);
	
		ObservableList<String> list1 = FXCollections.observableArrayList("AC102","AC104","AC107","AC113","AI011");
		comb1.setItems(list1);
		
		
		if (radio3.isSelected() == false)
		comb2.setDisable(true);
	
		ObservableList<String> list2 = FXCollections.observableArrayList("YVR","YYZ");
		comb2.setItems(list2);
		
		
		if (radio4.isSelected() == false)
		comb3.setDisable(true);
	
		ObservableList<String> list3 = FXCollections.observableArrayList("YYZ","YVR","NRT");
		comb3.setItems(list3);
		
		
		
	
		 
		
		
	}
	

}
