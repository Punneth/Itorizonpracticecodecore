package com.assignment.java.collection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Scanner;

public class ImplementedReservation implements ReservationInterfaces {
	Scanner scan3 = new Scanner(System.in);
	int adult,child,reservationId;
	double subTotalAmount,discountAmount,taxAmount,totalAmount;
	String status,customerName,reservationDescription;
	LocalDate reservationDate;
	ArrayList<ReservationPojo> ararylist = new ArrayList<>();
	ListIterator<ReservationPojo> listiterator=null;
	
	public void fileOperation() {
		try {
			
			String path = "C:\\Users\\Puneeth_SB\\Desktop\\tablereservation.txt";
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
				oos.writeObject(ararylist);
				oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void fileOperation2() {
		try {
			String path = "C:\\Users\\Puneeth_SB\\Desktop\\tablereservation.txt";
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
			
			ararylist = (ArrayList<ReservationPojo>)ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	@Override
	public void createAReservation() {
		fileOperation2();//read
		boolean flag = true;
	main:	do {
			Scanner scan = new Scanner(System.in);
			boolean name=true;
			CN: while(name) {
				System.out.print("Enter Customer Name: ");
					customerName = scan.nextLine();
					if(isStringOnlyAlphabet(customerName)==true) {
						customerName = customerName;
						break;
					}
					else if(isStringOnlyAlphabet(customerName) == false) {
							System.out.println("Enter a String");
							continue CN;
						}
				}
			boolean desc=true;
			RD: while(desc) {
				System.out.print("Reservation Description: ");
					reservationDescription = scan.nextLine();
					if(isStringOnlyAlphabet(reservationDescription)==true) {
						this.reservationDescription = reservationDescription;
						break;
					}
					else {
					System.out.println("Enter a String");
					continue RD;
				}
			}
			
			reservationDate = LocalDate.now();
			int year = reservationDate.getYear();
			if(DayOfWeek.WEDNESDAY == reservationDate.getDayOfWeek()) {
				discountAmount=0.25*subTotalAmount;
			}
			boolean id = true;
			RI:while(id) {
				try {
					System.out.print("Reservation Id: ");
					reservationId = scan.nextInt();
					if(reservationId<=9999 && reservationId>=1000) {
//					if(String.valueOf(reservationId).length()==4) {
						id=false;
					}
					else {
						System.out.println("Please enter 4 digit number");
						continue RI;
					}
				}
				catch(Exception e) {
					System.out.println("Enter a number not an String");
					scan.nextLine();
					continue RI;
				}
			}
			Boolean numAdult = true;
			NA:while(numAdult) {
				try {
					System.out.print("No of Adult: ");
					adult = scan.nextInt();
					if(adult>0 && adult<=10) {
						numAdult=false;						
					}
					else {
						System.out.println("For every Customer 10 Adults will allowed.. Please enter within range");
					}
				}
				catch(Exception e1) {
					scan.nextLine();
					System.out.println("Enter a number not an String");
					numAdult=true;
				}
			}
			Boolean numChild = true;
			NC:while(numChild) {
				try {
					System.out.print("No of Children: ");
					child = scan.nextInt();
					if(child>0 && child<=10) {
						numChild=false;						
					}
					else {
						System.out.println("For every Customer 5 Childrens will allowed.. Please enter within range");
					}
				}
				catch(Exception e1) {
					scan.nextLine();
					System.out.println("Enter a number not an String");
					continue NC;
				}
			}		

			calculation();
			reservationId=Integer.valueOf(String.valueOf(year)+String.valueOf(reservationId));
			System.out.println();
			System.out.println("Reservation Id: "+reservationId);
			System.out.println("Reservation Date: "+reservationDate);
			System.out.println("Booked Status: "+ status);
			System.out.println("Sub Total Amount: "+subTotalAmount+" Rupees");
			System.out.println("Discount Amount: "+discountAmount+" Rupees");
			System.out.println("Tax Amount: "+taxAmount+" Rupees");
			System.out.println("Total Amount: "+totalAmount+"Rupees");
			ararylist.add(new ReservationPojo(reservationId, customerName, reservationDescription, reservationDate, adult, child, status, 
					subTotalAmount, discountAmount, taxAmount, totalAmount));
			fileOperation();
			System.out.println("Do you want to enter more Reservation details(Y/N)");
			scan.nextLine();
			boolean condition = true;
			while(condition){
				String str = scan.nextLine();
				if(str.equalsIgnoreCase("Y") ||str.equalsIgnoreCase("N") ) {
					if(str.equalsIgnoreCase("Y")) {
						System.out.println();
						continue main;
					}else {
						flag = false;
						break;
					}
				} 
				else {
					System.out.println("Enter correct choice:");
					scan.nextLine();
					condition = true;
				}	
			}
		}while(flag);
		
	}
	public void calculation() {
		subTotalAmount =(adult*500) + (child*300) ;				
		status = "Booked";
		taxAmount = (subTotalAmount-discountAmount)*0.05;
		totalAmount = (subTotalAmount-discountAmount)+taxAmount;
		System.out.println("--------------------------Reservation Created Successfully---------------------------");
	}
	
	public static boolean isStringOnlyAlphabet(String customerName)
    {
 
        return ((customerName != null) && (!customerName.equals(""))
                && (customerName.matches("^[a-zA-Z]*$")));
    }
		
		
	@Override
	public void viewReservation() {
		fileOperation2();
		for(ReservationPojo array : ararylist) {
			System.out.println(array);
		}
	}
	

	@Override
	public void viewByRervationId() {
		Scanner scan1 = new Scanner(System.in);
		fileOperation2();	
		boolean found=false;
		System.out.println("Enter Reservation Id");
		int reservationId=scan1.nextInt();
		listiterator = ararylist.listIterator();
		while(listiterator.hasNext()) {
			ReservationPojo rp = (ReservationPojo)listiterator.next();
			if(rp.getReservationId()==reservationId) {
				System.out.println("--------------------------------------------------------------------------");
				System.out.println("Reservation Details");
				System.out.println(rp);
				found = true;
			}
		}
		if(!found) 
			System.out.println("Record not found");
		
	}
	

	@Override
	public void sortReservation() {
		fileOperation2();
		int choice=0;
		do {
			System.out.println("*********Choose Sort Reservation Property*********");
			System.out.println("1.Sort based on Reservation Id");
			System.out.println("2.Sort based on Reservation Description");
			System.out.println("3.Sort based on Reservation Date");
			System.out.println("4.Sort based on Total Amount");
			System.out.println("5.Exit");
			System.out.println("Choose option to sort");
			choice =scan3.nextInt();
			switch(choice) {
			case 1:
				sortByReservationId();
				break;
			case 2:
				sortByReservationDescription();
				break;
			case 3:
				sortByReservationDate();
				break;
			case 4:
				sortByTotalAmount();
				break;
			case 5:
				return;
			default:
				System.out.println("Enter a valid number");
				break;
			}
		}
		while(choice!=5);
		}
		
	public void sortByReservationId() {
		boolean flag = false;
		int choice=0;
		do {
			System.out.println("*********Choose Sort Order*********");
			System.out.println("1.Ascending");
			System.out.println("2.Descending");
			System.out.println("Enter your choice to sort"+"\n");
			choice = scan3.nextInt();
			switch(choice) {
			case 1 :
				fileOperation2();
				Collections.sort(ararylist, new Comparator<ReservationPojo>(){
					public int compare(ReservationPojo rp1,ReservationPojo rp2) {
						return rp1.getReservationId() - rp2.getReservationId();
					}
				});
				fileOperation();
				System.out.println("---------------------------------------------------------------");
				listiterator = ararylist.listIterator();
				while(listiterator.hasNext()) {
					System.out.println(listiterator.next());
					System.out.println("-----------------------------------------------------------");
				}
				break;
			case 2 :
					fileOperation2();
					Collections.sort(ararylist, new Comparator<ReservationPojo>(){
						public int compare(ReservationPojo rp1,ReservationPojo rp2) {
							return rp2.getReservationId() - rp1.getReservationId();
						}
					});
					fileOperation();
					System.out.println("---------------------------------------------------------------");
					listiterator = ararylist.listIterator();
					while(listiterator.hasNext()) {
						System.out.println(listiterator.next());
						System.out.println("-----------------------------------------------------------");
					}
					break;
			case 3 :
				break;
			default :
				System.out.println("Enter a valid choice");
				break;
				}
			}
		while(flag);
		}
	
		

	public void sortByReservationDescription() {
		boolean flag = false;
		int choice=0;
		do {
			System.out.println("*********Choose Sort Order*********");
			System.out.println("1.Ascending");
			System.out.println("2.Descending");
			System.out.println("3.Exist");
			System.out.println("Enter your choice to sort");
			choice = scan3.nextInt();
			switch(choice) {
			case 1 :
				fileOperation2();
				Collections.sort(ararylist, new Comparator<ReservationPojo>(){
					public int compare(ReservationPojo rp1,ReservationPojo rp2) {
						return rp1.getReservationDescription().compareTo(rp2.getReservationDescription());
					}
				});
				fileOperation();
				System.out.println("---------------------------------------------------------------");
				listiterator = ararylist.listIterator();
				while(listiterator.hasNext()) {
					System.out.println(listiterator.next());
					System.out.println("-----------------------------------------------------------");
				}
				break;
			case 2 :
					fileOperation2();
					Collections.sort(ararylist, new Comparator<ReservationPojo>(){
						public int compare(ReservationPojo rp1,ReservationPojo rp2) {
							return rp2.getReservationDescription().compareTo(rp1.getReservationDescription());
						}
					});
					fileOperation();
					System.out.println("---------------------------------------------------------------");
					listiterator = ararylist.listIterator();
					while(listiterator.hasNext()) {
						System.out.println(listiterator.next());
						System.out.println("-----------------------------------------------------------");
					}
					break;
			case 3:
				break;
			default :
				System.out.println("Enter valid choice");
				break;
			}
		}
		while(flag);
	}
	
	public void sortByReservationDate() {
		boolean flag = false;
		int choice=0;
		do {
			System.out.println("*********Choose Sort Order*********");
			System.out.println("1.Ascending");
			System.out.println("2.Descending");
			System.out.println("3.Exist");
			System.out.println("Enter your choice to sort");
			choice = scan3.nextInt();
			switch(choice) {
			case 1 :
				fileOperation2();
				Collections.sort(ararylist, new Comparator<ReservationPojo>(){
					public int compare(ReservationPojo rp1,ReservationPojo rp2) {
						return rp1.getReservationDate().compareTo(rp2.getReservationDate());
					}
				});
				fileOperation();
				System.out.println("---------------------------------------------------------------");
				listiterator = ararylist.listIterator();
				while(listiterator.hasNext()) {
					System.out.println(listiterator.next());
					System.out.println("-----------------------------------------------------------");
				}
				break;
			case 2 :
					fileOperation2();
					Collections.sort(ararylist, new Comparator<ReservationPojo>(){
						public int compare(ReservationPojo rp1,ReservationPojo rp2) {
							return rp2.getReservationDate().compareTo(rp1.getReservationDate());
						}
					});
					fileOperation();
					System.out.println("---------------------------------------------------------------");
					listiterator = ararylist.listIterator();
					while(listiterator.hasNext()) {
						System.out.println(listiterator.next());
						System.out.println("-----------------------------------------------------------");
					}
			case 3:
				break;
			default :
				System.out.println("Enter valid choice");
				break;			}
		}
		while(flag);
	}
	

	public void sortByTotalAmount() {
		boolean flag = false;
		int choice=0;
		do {
			System.out.println("*********Choose Sort Order*********");
			System.out.println("Ascending");
			System.out.println("Descending");
			System.out.println("Enter your choice to sort");
			choice = scan3.nextInt();
			switch(choice) {
			case 1 :
				fileOperation2();
				Collections.sort(ararylist, new Comparator<ReservationPojo>(){
					public int compare(ReservationPojo rp1,ReservationPojo rp2) {
						return (int) (rp1.getTotalAmount() - rp2.getTotalAmount());
					}
				});
				fileOperation();
				System.out.println("---------------------------------------------------------------");
				listiterator = ararylist.listIterator();
				while(listiterator.hasNext()) {
					System.out.println(listiterator.next());
					System.out.println("-----------------------------------------------------------");
				}
				break;
			case 2 :
					fileOperation2();
					Collections.sort(ararylist, new Comparator<ReservationPojo>(){
						public int compare(ReservationPojo rp1,ReservationPojo rp2) {
							return (int) (rp2.getTotalAmount() - rp1.getTotalAmount());
						}
					});
					fileOperation();
					System.out.println("---------------------------------------------------------------");
					listiterator = ararylist.listIterator();
					while(listiterator.hasNext()) {
						System.out.println(listiterator.next());
						System.out.println("-----------------------------------------------------------");
					}
				break;
			case 3:
				break;
			default :
				System.out.println("Enter valid choice");
				break;
			}
		}
		while(flag);
	}
	
	
	@Override
	public void deleteReservationById() {
		Scanner scan1 = new Scanner(System.in);
		fileOperation2();
		boolean found=false;
		System.out.print("Enter Reservation Id to Delete");
		int reservationId=scan1.nextInt();
		listiterator = ararylist.listIterator();
		while(listiterator.hasNext()) {
			ReservationPojo rp = (ReservationPojo)listiterator.next();
			if(rp.getReservationId()==reservationId) {
				System.out.println("Deleted Successfully");
				listiterator.remove();
				found = true;
			}
		}
		if(!found) {
			System.out.println("Record Not Found");
		}
		else {
			fileOperation();			
		}
	}
	
	
	
	@Override
	public void cancelReservationById() {
		fileOperation2();
		boolean found = false;
		System.out.println("Enter Reservation Id to Cancel");
		int reservationId=scan3.nextInt();
		listiterator = ararylist.listIterator();
		while(listiterator.hasNext()) {
			ReservationPojo rp = (ReservationPojo)listiterator.next();
			if(rp.getReservationId()==reservationId) {
				rp.setStatus("Cancelled");
				found = true;
			}
		}
		if(found) {
			System.out.println("Reservation "+reservationId+" "+"Cancelled Successfully");
			System.out.println();
			fileOperation();
		}
		else {
			System.out.println("Enter a valid Reservation Id to Cancel");
		}
		System.out.println("Do you want to cancel other reservation (Y/N)");
		scan3.nextLine();
		String str = scan3.nextLine();
		if(str.equalsIgnoreCase("Y")) {
			cancelReservationById();
		}
		else {
			return;	
		}		
	}

	@Override
	public void confirmReservationById() {
		fileOperation2();
		boolean found = false;
		System.out.println("Enter Reservation Id to Cancel");
		int reservationId=scan3.nextInt();
		listiterator = ararylist.listIterator();
		while(listiterator.hasNext()) {
			ReservationPojo rp = (ReservationPojo)listiterator.next();
			if(rp.getReservationId()==reservationId) {
				rp.setStatus("Confirmed");
				found = true;
			}
		}
		if(found) {
			System.out.println("Reservation "+reservationId+" "+"Confirmed Successfully");
			System.out.println();
			fileOperation();
		}
		else {
			System.out.println("Enter a valid Reservation Id to Cancel");
		}
		System.out.println("Do you want to cancel other reservation (Y/N)");
		scan3.nextLine();
		String str = scan3.nextLine();
		if(str.equalsIgnoreCase("Y")) {
			cancelReservationById();
		}
		else {
			return;	
		}
		
	}

	@Override
	public void generateReservationReport() {
		String path3 = "C:\\Users\\Puneeth_SB\\Desktop\\Reservation _Report.txt";
		File file = new File(path3);
		FileWriter writer =null;
		BufferedWriter out = null;
		int choice = 0;
		do {
			System.out.println("******** Choose Report Type*********"); 
			System.out.println("1.Export All");
			System.out.println("2.Export By Status");
			System.out.println("3.Exit");
			System.out.println("Enter your choice");
			choice = scan3.nextInt();
			switch(choice) {
			case 1:
				fileOperation2();
//				/listiterator = ararylist.listIterator();
				for(ReservationPojo array : ararylist) {
					System.out.println(String.valueOf(array));
						try {
							writer = new FileWriter(file);
							out = new BufferedWriter(writer);
//							out.write(array);
							out.write(String.valueOf(array));
							out.flush();
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				break;
			case 2:
				boolean bl = false;
				int option = 0;
				do {
					System.out.println("******** Choose Status*********");
					System.out.println("1.Booked");
					System.out.println("2.Cancelled");
					System.out.println("3.Confirmed");
					System.out.println("Choose an option based on Status");
					option = scan3.nextInt();
					switch(option) {
					case 1:
						fileOperation2();
						listiterator = ararylist.listIterator();
						while(listiterator.hasNext()) {
							ReservationPojo rp = (ReservationPojo)listiterator.next();
							if(rp.getStatus().equalsIgnoreCase("Booked")) {
								try {
									writer = new FileWriter(path3);
									writer.write(String.valueOf(rp));;
									writer.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
						break;
					case 2:
						fileOperation2();
						listiterator = ararylist.listIterator();
						while(listiterator.hasNext()) {
							ReservationPojo rp = (ReservationPojo)listiterator.next();
							if(rp.getStatus().equalsIgnoreCase("Cancelled")) {
								try {
									writer = new FileWriter(path3);
									writer.write(String.valueOf(rp));;
									writer.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
						break;
					case 3:
						fileOperation2();
						listiterator = ararylist.listIterator();
						while(listiterator.hasNext()) {
							ReservationPojo rp = (ReservationPojo)listiterator.next();
							if(rp.getStatus().equalsIgnoreCase("Confirmed")) {
								try {
									writer = new FileWriter(path3);
									writer.write(String.valueOf(rp));;
									writer.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
						break;
					}
				}
				while(bl);
				break;
			case 3:
				break;
			}
		}while(choice!=3);
	}

	@Override
	public void exit() {
		System.exit(0);
	}
	

}
