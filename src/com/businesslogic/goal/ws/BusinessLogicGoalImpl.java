package com.businesslogic.goal.ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebService;

import com.businesslogic.goal.model.Goal;
import com.businesslogic.goal.model.Person;


@WebService(endpointInterface = "com.businesslogic.goal.ws.BusinessLogicGoal", serviceName = "businessLogicServiceGoal")
public class BusinessLogicGoalImpl implements BusinessLogicGoal {

	@Override
	public String ChangeStepsControl(int id, String access_token, String userId, String refresh, int diffGoal,String lifeStyle, int diffSteps, int steps) {

		
		int change = 0;
		String sentence = "Steps goal has not changed";
		
		if (diffSteps < 2000) {

			if (diffGoal < 5) {

			} else if (diffGoal < 10 && diffGoal > 5) {
				switch (lifeStyle) {
				case "Little to no activity":
					change = -1000;
					ChangeStepsGoalRequest(access_token,userId,refresh,Integer.toString(steps+change));
					sentence="Steps goal decreased by 1000";
					break;
				case "Light activity":
					change = -500;
					sentence="Steps goal decreased by 500";
					ChangeStepsGoalRequest(access_token,userId,refresh,Integer.toString(steps+change));
					break;
				case "Moderate activity":
					change = 0;
					break;
				case "Heavy activity":
					change = 500;
					sentence="Steps goal increased by 500";
					ChangeStepsGoalRequest(access_token,userId,refresh,Integer.toString(steps+change));
					break;
				case "Very heavy activity":
					change = 1000;
					sentence="Steps goal increased by 1000";
					ChangeStepsGoalRequest(access_token,userId,refresh,Integer.toString(steps+change));
					break;
				default:
					break;
				}
			} else if (diffGoal < 20 && diffGoal > 10) {
				change = -1000;
				sentence="Steps goal decreased by 1000";
				ChangeStepsGoalRequest(access_token,userId,refresh,Integer.toString(steps+change));
			}
		} else {
			switch (lifeStyle) {
			case "Little to no activity":
				change = -2000;
				sentence="Steps goal decreased by 2000";
				ChangeStepsGoalRequest(access_token,userId,refresh,Integer.toString(steps+change));
				break;
			case "Light activity":
				change = -1500;
				sentence="Steps goal decreased by 1500";
				ChangeStepsGoalRequest(access_token,userId,refresh,Integer.toString(steps+change));
				break;
			case "Moderate activity":
				change = -1000;
				sentence="Steps goal decreased by 1000";
				ChangeStepsGoalRequest(access_token,userId,refresh,Integer.toString(steps+change));
				break;
			case "Heavy activity":
				change = -500;
				sentence="Steps goal decreased by 500";
				ChangeStepsGoalRequest(access_token,userId,refresh,Integer.toString(steps+change));
				break;
			case "Very heavy activity":
				change = 0;
				break;
			default:
				break;
			}
		}
		return sentence;
	}

	public void ChangeStepsGoalRequest(String access_token, String userId, String refresh, String change) {
		String url = "https://api.fitbit.com/1/user/" + userId + "/activities/goals/daily.json";

		try {
			// new http request and set parameters
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", "Bearer " + access_token);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			// set and send body of the request
			String str = "steps=" + change;
			byte[] outputInBytes = str.getBytes("UTF-8");
			OutputStream os = con.getOutputStream();
			os.write(outputInBytes);
			os.close();

			// get the response
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public String ChangeCaloriesControl(int id, String access_token, String userId, String refresh,  int diffGoal,String lifeStyle, int diffCalories, int calories) {
	

		
		int change = 0;
		String sentence = "Calories goal has not changed";
		
		if (diffCalories < 1000) {

			if (diffGoal < 5) {

			} else if (diffGoal < 10 && diffGoal > 5) {
				switch (lifeStyle) {
				case "Little to no activity":
					change = -500;
					ChangeCaloriesGoalRequest(access_token,userId,refresh,Integer.toString(calories+change));
					sentence="Calories goal decreased by 500";
					break;
				case "Light activity":
					change = -250;
					sentence="Calories goal decreased by 250";
					ChangeCaloriesGoalRequest(access_token,userId,refresh,Integer.toString(calories+change));
					break;
				case "Moderate activity":
					change = 0;
					break;
				case "Heavy activity":
					change = 250;
					sentence="Calories goal increased by 250";
					ChangeCaloriesGoalRequest(access_token,userId,refresh,Integer.toString(calories+change));
					break;
				case "Very heavy activity":
					change = 500;
					sentence="Calories goal increased by 500";
					ChangeCaloriesGoalRequest(access_token,userId,refresh,Integer.toString(calories+change));
					break;
				default:
					break;
				}
			} else if (diffGoal < 20 && diffGoal > 10) {
				change = -500;
				sentence="Calories goal decreased by 500";
				ChangeCaloriesGoalRequest(access_token,userId,refresh,Integer.toString(calories+change));
			}
		} else {
			switch (lifeStyle) {
			case "Little to no activity":
				change = -1000;
				sentence="Calories goal decreased by 1000";
				ChangeCaloriesGoalRequest(access_token,userId,refresh,Integer.toString(calories+change));
				break;
			case "Light activity":
				change = -750;
				sentence="Calories goal decreased by 750";
				ChangeCaloriesGoalRequest(access_token,userId,refresh,Integer.toString(calories+change));
				break;
			case "Moderate activity":
				change = -500;
				sentence="Calories goal decreased by 500";
				ChangeCaloriesGoalRequest(access_token,userId,refresh,Integer.toString(calories+change));
				break;
			case "Heavy activity":
				change = -250;
				sentence="Calories goal decreased by 250";
				ChangeCaloriesGoalRequest(access_token,userId,refresh,Integer.toString(calories+change));
				break;
			case "Very heavy activity":
				change = 0;
				break;
			default:
				break;
			}
		}
		return sentence;
	}
	
	public void ChangeCaloriesGoalRequest(String access_token, String userId, String refresh, String change) {
		String url = "https://api.fitbit.com/1/user/" + userId + "/activities/goals/daily.json";

		try {
			// new http request and set parameters
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", "Bearer " + access_token);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			// set and send body of the request
			String str = "caloriesOut=" + change;
			byte[] outputInBytes = str.getBytes("UTF-8");
			OutputStream os = con.getOutputStream();
			os.write(outputInBytes);
			os.close();

			// get the response
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public String ChangeDistanceControl(int id, String access_token, String userId, String refresh,  int diffGoal,String lifeStyle, double diffDistance, double distance) {


		
		double change = 0.0;
		String sentence = "Distance goal has not changed";
		
		if (diffDistance < 10.0) {

			if (diffGoal < 5) {

			} else if (diffGoal < 10 && diffGoal > 5) {
				switch (lifeStyle) {
				case "Little to no activity":
					change = -1;
					ChangeDistanceGoalRequest(access_token,userId,refresh,Double.toString(distance+change));
					sentence="Distance goal decreased by 1km";
					break;
				case "Light activity":
					change = -0.5;
					sentence="Distance goal decreased by 0.5km";
					ChangeDistanceGoalRequest(access_token,userId,refresh,Double.toString(distance+change));
					break;
				case "Moderate activity":
					change = 0;
					break;
				case "Heavy activity":
					change = 0.5;
					sentence="Distance goal increased by 0.5km";
					ChangeDistanceGoalRequest(access_token,userId,refresh,Double.toString(distance+change));
					break;
				case "Very heavy activity":
					change = 1;
					sentence="Distance goal increased by 1km";
					ChangeDistanceGoalRequest(access_token,userId,refresh,Double.toString(distance+change));
					break;
				default:
					break;
				}
			} else if (diffGoal < 20 && diffGoal > 10) {
				change = -1;
				sentence="Distance goal decreased by 1km";
				ChangeDistanceGoalRequest(access_token,userId,refresh,Double.toString(distance+change));
			}
		} else {
			switch (lifeStyle) {
			case "Little to no activity":
				change = -2;
				sentence="Distance goal decreased by 2km";
				ChangeDistanceGoalRequest(access_token,userId,refresh,Double.toString(distance+change));
				break;
			case "Light activity":
				change = -1.5;
				sentence="Distance goal decreased by 1.5km";
				ChangeDistanceGoalRequest(access_token,userId,refresh,Double.toString(distance+change));
				break;
			case "Moderate activity":
				change = -1;
				sentence="Distance goal decreased by 1km";
				ChangeDistanceGoalRequest(access_token,userId,refresh,Double.toString(distance+change));
				break;
			case "Heavy activity":
				change = -0.5;
				sentence="Distance goal decreased by 0.5km";
				ChangeDistanceGoalRequest(access_token,userId,refresh,Double.toString(distance+change));
				break;
			case "Very heavy activity":
				change = 0;
				break;
			default:
				break;
			}
		}
		return sentence;
	}
	
	public void ChangeDistanceGoalRequest(String access_token, String userId, String refresh, String change) {
		String url = "https://api.fitbit.com/1/user/" + userId + "/activities/goals/daily.json";

		try {
			// new http request and set parameters
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", "Bearer " + access_token);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			// set and send body of the request
			String str = "distance=" + change;
			byte[] outputInBytes = str.getBytes("UTF-8");
			OutputStream os = con.getOutputStream();
			os.write(outputInBytes);
			os.close();

			// get the response
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public String ChangeWeightControl(int id, String access_token, String userId, String refresh, String status, double startWeight) {		
		String sentence = "Weight goal has not changed";
		double change = 0;

		switch (status) {
		case "Normal":
			break;
		case "Overweight":
			change = -3;
			sentence = "Weight goal decreased by 3kg";
			ChangeWeightGoalRequest(access_token,userId,refresh,Double.toString(startWeight), Double.toString(startWeight+change));
			break;
		case "Underweight":
			change = 3;
			sentence = "Weight goal increased by 3kg";
			ChangeWeightGoalRequest(access_token,userId,refresh,Double.toString(startWeight), Double.toString(startWeight+change));
			break;
		case "Severly Underweight":
			change = 8;
			sentence = "Weight goal decreased by 8kg";
			ChangeWeightGoalRequest(access_token,userId,refresh,Double.toString(startWeight), Double.toString(startWeight+change));
			break;
		case "Obese Class I (Moderately obese)":
			change = -8;
			sentence = "Weight goal decreased by 8kg";
			ChangeWeightGoalRequest(access_token,userId,refresh,Double.toString(startWeight), Double.toString(startWeight+change));
			break;
		case "Obese Class II (Severely obese)":
			change = -14;
			sentence = "Weight goal decreased by 14kg";
			ChangeWeightGoalRequest(access_token,userId,refresh,Double.toString(startWeight), Double.toString(startWeight+change));
			break;
		case "Obese Class III (Very severely obese)":
			change = -20;
			sentence = "Weight goal decreased by 20kg";
			ChangeWeightGoalRequest(access_token,userId,refresh,Double.toString(startWeight), Double.toString(startWeight+change));
			break;
		}
		
		return sentence;
	}
	
	public void ChangeWeightGoalRequest(String access_token, String userId, String refresh, String startWeight,String weight) {
		String url = "https://api.fitbit.com/1/user/"+ userId+"/body/log/weight/goal.json";

		try {
			// new http request and set parameters
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", "Bearer " + access_token);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			Date date = new Date();
			String sdate = new SimpleDateFormat("yyyy-MM-dd").format(date);
			
			// set and send body of the request
			String str = "startDate="+sdate+"&startWeight="+startWeight+"&weight="+weight;
			byte[] outputInBytes = str.getBytes("UTF-8");
			OutputStream os = con.getOutputStream();
			os.write(outputInBytes);
			os.close();

			// get the response
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}


}