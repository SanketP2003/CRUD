package com.main.CRUD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update {
	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/shopme";
		String username="postgres";
		String password="sanket";	
		int ch = 0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		System.out.println("Empid :");
		try {
			Connection con=DriverManager.getConnection(url, username, password);
			String query1="UPDATE employee SET fname=? WHERE empid=?";
			String query2="UPDATE employee SET lname=? WHERE empid=?";
			String query3="UPDATE employee SET salary=? WHERE empid=?";
			String query4="UPDATE employee SET dept=? WHERE empid=?";
			String query5="UPDATE employee SET fname=?, lname=?, salary=?, dept=? WHERE empid=?";
			System.out.println("1.Update fname");
			System.out.println("2.Update lname");
			System.out.println("3.Update salary");
			System.out.println("4.Update dept");
			System.out.println("5.Update whole record");
			while(true) {
				System.out.print("Enter the choice : ");
				ch=sc.nextInt();
				switch (ch) {
				case 1: {
					System.out.println("Enter the fname : ");
					String fname=br.readLine();
					System.out.println("Enter the id : ");
					int empid=Integer.parseInt(br.readLine());
					PreparedStatement ps=con.prepareStatement(query1);
					ps.setString(1, fname);
					ps.setInt(2, empid);
					ps.executeUpdate();
					System.out.println("Done.....");
					con.close();
					break;
				}
				case 2: {
					System.out.println("Enter the lname : ");
					String lname=br.readLine();
					System.out.println("Enter the id : ");
					int empid=Integer.parseInt(br.readLine());
					PreparedStatement ps=con.prepareStatement(query2);
					ps.setString(1, lname);
					ps.setInt(2, empid);
					ps.executeUpdate();
					System.out.println("Done.....");
					con.close();
					break;
				}
				case 3: {
					System.out.println("Enter the salary : ");
					int salary=Integer.parseInt(br.readLine());
					System.out.println("Enter the id : ");
					int empid=Integer.parseInt(br.readLine());
					PreparedStatement ps=con.prepareStatement(query3);
					ps.setInt(1, salary);
					ps.setInt(2, empid);
					ps.executeUpdate();
					System.out.println("Done.....");
					con.close();
					break;
				}
				case 4: {
					System.out.println("Enter the Department : ");
					String fname=br.readLine();
					System.out.println("Enter the id : ");
					int empid=Integer.parseInt(br.readLine());
					PreparedStatement ps=con.prepareStatement(query4);
					String dept = null;
					ps.setString(1, dept);
					ps.setInt(2, empid);
					ps.executeUpdate();
					System.out.println("Done.....");
					con.close();
					break;
				}
				case 5: {
					System.out.println("Enter the fname : ");
					String fname=br.readLine();
					System.out.println("Enter the lname : ");
					String lname=br.readLine();
					System.out.println("Enter the salary : ");
					int salary=Integer.parseInt(br.readLine());
					System.out.println("Enter the department : ");
					String dept=br.readLine();
					System.out.println("Enter the id : ");
					int empid=Integer.parseInt(br.readLine());
					PreparedStatement ps=con.prepareStatement(query5);
					ps.setString(1, fname);
					ps.setString(2, lname);
					ps.setInt(3, salary);
					ps.setString(4, dept);
					ps.setInt(5, empid);
					ps.executeUpdate();
					System.out.println("Done.....");
					con.close();
					break;
				}
	
				default:
					throw new IllegalArgumentException("Unexpected value: " + ch);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
