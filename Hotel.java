
import java.util.*;
import java.util.Hashtable;
import java.util.ArrayList;

public class Hotel {
	
	
	
	private int standardCounter = 1; //starts at 0 available rooms as standard room numbers start at 1
	private int deluxeCounter = 251; //starts at 0 available rooms as deluxe room numbers start at 251
	private int superiorCounter = 501; //starts at 0 available rooms as superior room numbers start at 501
	
	 private static final int maximumNumberStandardRooms = 250;
	 private static final int maximumNumberDeluxeRooms = 500;
	 private static final int maximumNumberSuperiorRooms = 530;
	 
	Hashtable<String, Room> roomDetailsHashTable = new Hashtable<>();
	Hashtable<String, RoomPrice> roomPriceHashTable = new Hashtable<>();
	
	
	Hashtable <String, Object> bookingDetails = new Hashtable<>();
	ArrayList<Hashtable<String, Object>> listOfAllReservations = new ArrayList<>();
	
	
	
	public Hotel() {
	
	
	roomDetailsHashTable.put("Standard room details", new Room("Comfortable and budget-friendly accommodation", "1-250", "Twin or Double"));
	roomDetailsHashTable.put("Deluxe room details", new Room("Enhanced comfort and additional space", "251-500", "Queen-size bed"));
	roomDetailsHashTable.put("Superior room details", new Room("Luxury and premium services", "501-530", "Queen or king-size bed"));
	
	roomPriceHashTable.put("Standard room rate per night", new RoomPrice(1000));
	roomPriceHashTable.put("Deluxe room rate per night", new RoomPrice(1200));
	roomPriceHashTable.put("Superior room rate per night", new RoomPrice(1800));
	
	}
	
	public int increaseRooms(String roomType) {
	
		int roomNumber = 0;
			switch(roomType) {
			case "standard":
				if (standardCounter < maximumNumberStandardRooms) {
					roomNumber = standardCounter;
					standardCounter++;
                } else {
                    System.out.println("Maximum limit for standard rooms reached.");
                }
				break;
			case "deluxe":
				if(deluxeCounter < maximumNumberDeluxeRooms) {
					roomNumber = deluxeCounter;
					deluxeCounter ++;
				} else {
					System.out.println("Maximum limit for deluxe rooms reached.");
				}
				break;
			case "superior":
				if (superiorCounter < maximumNumberSuperiorRooms) {
					roomNumber = superiorCounter;
					superiorCounter ++;
				} else {
					System.out.println("Maximum limit for superior rooms reached.");
				}
				break;
			} 
			return roomNumber;
	}
	
	public void reserveOneRoom(String roomType) {
		
		Scanner keyboard = new Scanner(System.in);
		
		
	    if (roomType.toLowerCase().equals("standard") || roomType.toLowerCase().equals("deluxe") || roomType.toLowerCase().equals("superior")) {
	    	Hashtable<String, Object> bookingDetails = new Hashtable<>();
	    	 if (roomType.toLowerCase().equals("standard")) {
	             System.out.println("Please select a bed type. To select a twin bed, please write 'twin'. To select a double bed, please write 'double'");
	             String bedType = keyboard.nextLine();
	             if (bedType.toLowerCase().equals("twin")) {
	                 bookingDetails.put("Bed Type", "twin bed");
	             } else if (bedType.toLowerCase().equals("double")) {
	                 bookingDetails.put("Bed Type", "double bed");
	             } else {
	                 System.out.println("The accepted bed types for standard room are 'twin' and 'double'.");
	                 return; // Exit the method if the bed type is invalid
	             }
	         } else if (roomType.toLowerCase().equals("deluxe")) {
	             bookingDetails.put("Bed Type", "queen bed");
	         } else if (roomType.toLowerCase().equals("superior")) {
	             System.out.println("Please select a bed type. To select a queen bed, please write 'queen'. To select a king bed, please write 'king'");
	             String bedType = keyboard.nextLine();
	             if (bedType.toLowerCase().equals("queen")) {
	                 bookingDetails.put("Bed Type", "queen bed");
	             } else if (bedType.toLowerCase().equals("king")) {
	                 bookingDetails.put("Bed Type", "king bed");
	             } else {
	                 System.out.println("The accepted bed types for superior room are 'queen' and 'king'.");
	                 return; // Exit the method if the bed type is invalid
	             }
	         }

	    	
	        
	    int roomNumber = increaseRooms(roomType);
		System.out.println("Please enter guest's first name: \n");
		String firstName = keyboard.nextLine();
		System.out.println("Please enter guest's last name: \n");
		String lastName = keyboard.nextLine();  
		
		System.out.println("Please enter guest's length of stay in integers: \n");
		int lengthOfStay = keyboard.nextInt();
		keyboard.nextLine(); //consume next line after integer entry
		
		
		if (lengthOfStay > 0 && lengthOfStay < 101) {
		
		bookingDetails.put("Length of Stay", lengthOfStay);
		bookingDetails.put("Room Type", roomType); 
		bookingDetails.put("Room Number", roomNumber);
		bookingDetails.put("First Name", firstName);
		bookingDetails.put("Last Name", lastName);
		listOfAllReservations.add(bookingDetails);
		
		
		System.out.println("You have successfully reserved a room. Your reservation details are as follows: ");
		System.out.println("Room number: " + bookingDetails.get("Room Number"));
		System.out.println("Room class: " + bookingDetails.get("Room Type"));
		System.out.println("First name: " + bookingDetails.get("First Name"));
		System.out.println("Last name: " + bookingDetails.get("Last Name"));
		System.out.println("Length of stay: " + bookingDetails.get("Length of Stay"));
		System.out.println("Bed type: " + bookingDetails.get("Bed Type"));
		
		} else {
				System.out.println("Incorrect value entered, value entered must be a positive integer between 1 and 100. Please start again.");
			}
		} else {
			System.out.println("Incorrect room type entered, return to main menu.");
		}
	    
	}
	
	public void reserveMultipleRooms() {
		
		
		System.out.println("You can book up to 3 rooms in the same room class.\n");
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please write the name of the type of room you would like to book. The options are 'Standard', 'Deluxe', and 'Superior': \n");
	    String roomType = keyboard.nextLine();
	        
	    
	    if (roomType.equalsIgnoreCase("standard") || roomType.equalsIgnoreCase("deluxe") || roomType.equalsIgnoreCase("superior")) {
	        int counter = 0;
	        while (counter < 3) {
	            reserveOneRoom(roomType); 
	            counter++;
	            
	            if (counter < 3) {
	                System.out.println("To book more rooms, please select 'y'. To return to the menu, please select 'n'");
	                String selection = keyboard.nextLine();
	                if (!selection.equalsIgnoreCase("y")) {
	                    break;
	                }
	            } else {
	                System.out.println("Maximum number of rooms booked.");
	                break;
	            }
	        }
	        
		} else {
			System.out.println("Incorrect room type entered, return to main menu.");
		}
		} 
		
	
	public String getReservationDetails() {
		
		StringBuilder reservationString = new StringBuilder();
		
		if (listOfAllReservations.isEmpty()) {
			reservationString.append("No reservations found.");
        } else {
		int reservation = 1;
        	for (Hashtable<String, Object> bookingDetails : listOfAllReservations) {
        		reservationString.append("Room number: ").append(bookingDetails.get("Room Number")).append("\t");
        		reservationString.append("Room class: ").append(bookingDetails.get("Room Type")).append("\t");
        		reservationString.append("First name: ").append(bookingDetails.get("First Name")).append("\t");
        		reservationString.append("Last name: ").append(bookingDetails.get("Last Name")).append("\t");
        		reservationString.append("Length of stay: ").append(bookingDetails.get("Length of Stay")).append("\t\n");
	            reservation++;
	            }
	        }
		return reservationString.toString();
	}
		
	
	public void searchReservationByLastName() {
	    Scanner keyboard = new Scanner(System.in);
	    System.out.println("Please enter the last name you would like to search for:");
	    String lastName = keyboard.nextLine().trim();

	    boolean foundReservation = false;
	    for (Hashtable<String, Object> reservation : listOfAllReservations) {
	        String lastNameFromReservation = (String) reservation.get("Last Name");
	        if (lastNameFromReservation.equalsIgnoreCase(lastName)) {
	            foundReservation = true;
	            System.out.println("Reservation details for " + lastName + ":");
	            System.out.println("Room number: " + reservation.get("Room Number"));
	            System.out.println("Room class: " + reservation.get("Room Type"));
	            System.out.println("First name: " + reservation.get("First Name"));
	            System.out.println("Last name: " + reservation.get("Last Name"));
	            System.out.println("Length of stay: " + reservation.get("Length of Stay"));
	            System.out.println("Bed type: " + reservation.get("Bed Type"));
	            System.out.println();	           	        

	    if (!foundReservation) {
	        System.out.println("No reservations found for " + lastName + ".");
	    }}}
	}




	
	
	public void sortReservationsByLastName() {
	    // Sort the reservations by last name
	    Collections.sort(listOfAllReservations, new Comparator<Hashtable<String, Object>>() {
	        @Override
	        public int compare(Hashtable<String, Object> reservation1, Hashtable<String, Object> reservation2) {
	            String lastName1 = (String) reservation1.get("Last Name");
	            String lastName2 = (String) reservation2.get("Last Name");
	            return lastName1.compareToIgnoreCase(lastName2);
	        }
	    });

	    // Print the sorted reservations
	    System.out.println("Sorted reservations by last name:");
	    System.out.println("First name\tLast name\tLength of stay (nights)\tRoom reserved\tClass\tType");
	    for (Hashtable<String, Object> reservation : listOfAllReservations) {
	        String firstName = (String) reservation.get("First Name");
	        String lastName = (String) reservation.get("Last Name");
	        Integer lengthOfStay = (Integer) reservation.get("Length of Stay");
	        Integer roomNumber = (Integer) reservation.get("Room Number");
	        String roomClass = (String) reservation.get("Room Type");
	        String bedType = (String) reservation.get("Bed Type");

	        // Print the reservation details
	        System.out.println(firstName + "\t" + lastName + "\t" + (lengthOfStay != null ? lengthOfStay : "") + "\t\t\t" + (roomNumber != null ? roomNumber : "") + "\t\t" + (roomClass != null ? roomClass : "") + "\t" + (bedType != null ? bedType : ""));
	    }
	}

	
	public void viewRoomAvailability() { //
		  System.out.println("Number of standard rooms available: " + (250 - standardCounter));
		  System.out.println("Number of deluxe rooms available: " + (500 - deluxeCounter));
		  System.out.println("Number of standard rooms available: " + (530 - superiorCounter));
	}
	
	public void incomeGeneratedPerClass() {
		
		 int standardRoomsBooked = standardCounter - 1;
		    int deluxeRoomsBooked = deluxeCounter - 251;
		    int superiorRoomsBooked = superiorCounter - 501;

		    int standardRoomRate = roomPriceHashTable.getOrDefault("Standard room rate per night", new RoomPrice(0)).roomPrice;
		    int deluxeRoomRate = roomPriceHashTable.getOrDefault("Deluxe room rate per night", new RoomPrice(0)).roomPrice;
		    int superiorRoomRate = roomPriceHashTable.getOrDefault("Superior room rate per night", new RoomPrice(0)).roomPrice;

		    int standardRoomRevenue = 0;
		    int deluxeRoomRevenue = 0;
		    int superiorRoomRevenue = 0;

		    for (Hashtable<String, Object> reservation : listOfAllReservations) {
		        int lengthOfStay = (int) reservation.get("Length of Stay");
		        String roomType = (String) reservation.get("Room Type");
		        int roomRate = 0;
		        switch (roomType) {
		            case "standard":
		                roomRate = standardRoomRate;
		                standardRoomRevenue += (standardRoomsBooked * roomRate) * lengthOfStay;
		                break;
		            case "deluxe":
		                roomRate = deluxeRoomRate;
		                deluxeRoomRevenue += (deluxeRoomsBooked * roomRate) * lengthOfStay;
		                break;
		            case "superior":
		                roomRate = superiorRoomRate;
		                superiorRoomRevenue += (superiorRoomsBooked * roomRate) * lengthOfStay;
		                break;
		        }
		    }

		    System.out.println("Class\tNumber of rooms\tTotal revenue");
		    System.out.printf("Superior\t%d\t\t£%d%n", superiorRoomsBooked, superiorRoomRevenue);
		    System.out.printf("Standard\t%d\t\t£%d%n", standardRoomsBooked, standardRoomRevenue);
		    System.out.printf("Deluxe\t\t%d\t\t£%d%n", deluxeRoomsBooked, deluxeRoomRevenue);
		
	
}

	public static void main(String[] args) {
		
	
		Hotel hotelReservation = new Hotel();
		System.out.println("Welcome to the Hotel reservation programme. You are able to reserve, search, sort, and cancel rooms in this programme.");
		
		boolean exit = false;
		
		while(exit != true) {
		System.out.println("\nTo reserve one room, please select 1.\nTo reserve group of rooms in the same class, please select 2. \nTo search for a reservation by last name, please select 3.\nTo sort rooms by last name, please select 4. \nTo view room availability, please select 5.\nTo exit the programme, please select 6.");
		Scanner keyboard = new Scanner(System.in);
		int selection = keyboard.nextInt();
		
	
		switch(selection) {
		case 1:			
			
			String roomType;

			while (true) {
			    System.out.println("Please write the name of the type of room you would like to book. The options are 'Standard', 'Deluxe', and 'Superior': ");
			    roomType = keyboard.nextLine().toLowerCase();
			    
			    if (roomType.equals("standard") || roomType.equals("deluxe") || roomType.equals("superior")) {
			        break; // Valid room type provided, exit the loop
			    } else {
			        System.out.println("Invalid room type. Please try again.");
			    }
			}

			hotelReservation.reserveOneRoom(roomType);
			break;
		case 2:
			hotelReservation.reserveMultipleRooms();
			break;
		case 3:
			hotelReservation.searchReservationByLastName();
			break;
		case 4:
			hotelReservation.sortReservationsByLastName();
			break;
		case 5: 
			hotelReservation.viewRoomAvailability();
			break;
		case 6:
			System.out.println("Thank you for visiting the Hotel reservation programme. To exit, please click on the 'x' in the upper right hand corner.\n");		
			exit = true;
			break;
			
		}}
		hotelReservation.incomeGeneratedPerClass();

	}}

class Room {
	public String roomClass;
	public String description;
	public String roomNumbers;
	public String bedType;
	


	public Room(String description, String roomNumbers, String bedType){
	this.description = description;
	this.roomNumbers = roomNumbers;
	this.bedType = bedType;
	
}
}

class RoomPrice {
	public int roomPrice;
	
	public RoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
}

class Customer {
	public String firstName;
	public String lastName;
	public int lengthOfStay;
	public int roomNumber;
	
	public Customer(String firstName, String lastName, int lengthOfStay, int roomNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.lengthOfStay = lengthOfStay;
		this.roomNumber = roomNumber;
	}
}








