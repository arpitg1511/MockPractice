package FitnessTrackerApplication;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			String input = sc.nextLine();
			String[] fields = input.split(":");
			
			if(fields.length != 3) throw new Error("Invalid activity data fromat");
			
			String activityName = fields[0];
			
			int caloriesPerMin = 0;
			
			switch(activityName) {
				case "Walking" :
					caloriesPerMin = 3;
					break;
				case "Running" :
					caloriesPerMin = 7;
					break;
				case "Cycling" :
					caloriesPerMin = 5;
					break;
				default :
					throw new Error("Invalid activity name");
			}
			
			
			int durationInHours = Integer.parseInt(fields[1]);
			if(durationInHours <= 0) 
				throw new Error("Invalid duration or intensity");
			
			
			
			int intensty = Integer.parseInt(fields[2]);
			if(intensty < 1 || intensty > 9)
				throw new Error("Invalid duration or intensity");
			
			
			
			System.out.print("Enter your weight : ");
			double weight = sc.nextDouble();
			if(weight <= 0)
				throw new Error("User weight is invalid");
			
			
			
			double totalCalories = (caloriesPerMin * durationInHours
					* intensty * 60) / weight;
			
			System.out.println("Total Calories are : " + totalCalories);
		} catch(Error e) {
			
			System.out.println(e);
		}
	}
}
