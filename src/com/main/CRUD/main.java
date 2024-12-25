package com.main.CRUD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class main {
	String url="jdbc:postgresql://localhost:5432/shopme";
	String username="postgres";
	String password="sanket";
	static int srno;
	static int empid;
	static String fname;
	static String lname;
	static int salary;
	static String dept;
	static Scanner sc=new Scanner(System.in);
	public void INSERT() throws Exception {
		try {
			System.out.println("Enter the Details correctly : ");
			srno=sc.nextInt();
			empid=sc.nextInt();
			fname=sc.next();
			lname=sc.next();
			salary=sc.nextInt();
			dept=sc.next();
			String query="INSERT INTO employee VALUES ("+srno+","+empid+",'"+fname+"','"+lname+"',"+salary+",'"+dept+"');";

			Connection cn=DriverManager.getConnection(url, username, password);
			Statement st=cn.createStatement();
			int count=st.executeUpdate(query);
			System.out.println(count+"Done.....");
			st.close();
			cn.close();
		}
		catch(Exception e) {
			System.out.println("Enter the details correctly");
		}
	}
	public void RECORD() throws SQLException {
		try {
			Connection cn=DriverManager.getConnection(url, username, password);
			String query1="SELECT * FROM employee;";
			Statement st=cn.createStatement();
			ResultSet rs1=st.executeQuery(query1);
			while(rs1.next()) {
				String userdata=rs1.getInt(1)+" : "+rs1.getString(2)+" : "+rs1.getString(3)+" : "+rs1.getString(4);
				System.out.println(userdata);
			}
			st.close();
			cn.close();
		}
		catch(Exception e) {
			System.out.println("Database Error");
		}
	}
	public void SEARCH() throws SQLException {
		try {
			System.out.println("Enter the empid : ");
			empid=sc.nextInt();
			String query2="SELECT fname,lname FROM employee WHERE empid="+empid;
			Connection cn=DriverManager.getConnection(url, username, password);
			Statement st=cn.createStatement();
			ResultSet rs2=st.executeQuery(query2);
			rs2.next();
			String name=rs2.getString("fname");
			String name2=rs2.getString("lname");
			System.out.println(name+" : "+name2);
			st.close();
			cn.close();
		}
		catch(Exception e) {
			System.out.println("Incorrext Employee id!");
		}
	}
	public void UPDATE() {
		int ch = 0;
		try {
			
			Connection con=DriverManager.getConnection(url, username, password);
			String query1="UPDATE employee SET fname=? WHERE empid=?";
			String query2="UPDATE employee SET lname=? WHERE empid=?";
			String query3="UPDATE employee SET salary=? WHERE empid=?";
			String query4="UPDATE employee SET dept=? WHERE empid=?";
			String query5="UPDATE employee SET fname=?, lname=?, salary=?, dept=? WHERE empid=?";
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
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
	public void DELETE() {
		try {
			Connection con=DriverManager.getConnection(url, username, password);
			String query="DELETE FROM employee WHERE empid=?";
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the id : ");
			int empid=Integer.parseInt(br.readLine());
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, empid);
			ps.executeUpdate();
			System.out.println("Done.....");
			con.close();
			
		} catch (Exception e) {
			System.out.println("Employee id doesn't exist!");
		}
	}
	public static void main(String[] args) throws Exception {
		Class.forName("org.postgresql.Driver");
		System.out.println("********CRUD Operation********"+"\n");
		System.out.println("\\\\\\\\Employee Management////////"+"\n");
		System.out.println("coulmn details");
		System.out.println("1.srno");
		System.out.println("2.Employee ID");
		System.out.println("3.First name");
		System.out.println("4.Last name");
		System.out.println("5.Salary");
		System.out.println("6.Department"+"\n");
		do {
			System.out.println("1.ADD employee record");
			System.out.println("2.READ employee record");
			System.out.println("3.UPDATE employee record");
			System.out.println("4.DELETE employee record");
			System.out.println("Enter the choice : ");
			int ch=sc.nextInt();
			main m=new main();
			switch (ch) {
			case 1: {
				m.INSERT();
				break;
			}
			case 2: {
				System.out.println("1.See the records");
				System.out.println("2.Search by employee id");
				System.out.println("Enter the choice");
				int r=sc.nextInt();
				if(r==1) {
					m.RECORD();
				}
				else if(r==2) {
					m.SEARCH();
				}
				else {
					System.out.println("Wrong choice!");
				}
				break;
			}
			case 3: {
				m.UPDATE();
				break;
			}
			case 4: {
				m.DELETE();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + ch);
			}
		} while(true);
	}
}
