package com.example.gtfsdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	ArrayList<Agency> mAgencyList = new ArrayList<Agency> ();
	ArrayList<Calendar> mCalendarList = new ArrayList<Calendar> ();
	private final String TAG = "GtfsDemo";
	TextView mAgencyContent;
	TextView mCalendarContent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mAgencyContent = (TextView) findViewById(R.id.agency_content);
		mCalendarContent = (TextView) findViewById(R.id.calendar_content);
		
		parseAgency(R.raw.agency);
		printAgency();
		String line = "";		
		for (Agency agency : mAgencyList)
			line += agency.agency_id + " " + agency.agency_name + " " + agency.agency_url
			+ " " + agency.agency_timezone + " " + agency.agency_phone + " " + agency.agency_lang + "\n";
		mAgencyContent.setText(line);
		
		parseCalendar(R.raw.calendar);
		printCalendar();
		
		for (Calendar calendar : mCalendarList)
			line += calendar.service_id + " " + calendar.monday + " "
					+ calendar.tuesday + " " + calendar.wednesday + " "
					+ calendar.thursday + " " + calendar.friday + " "
					+ calendar.saturday + " " + calendar.sunday + " "
					+ calendar.start_date + " " + calendar.end_date + "\n";
		mCalendarContent.setText(line);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private void parseAgency(int rid) {
		BufferedReader rawReader = new BufferedReader(new InputStreamReader(this.getResources().openRawResource(rid)));
		String line = "";
		try {
			while((line = rawReader.readLine()) != null) {
				mAgencyList.add(new Agency(line));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private void printAgency() {
		for (Agency agency : mAgencyList)
			Log.i(TAG, "id " + agency.agency_id + "\n"
					+ "name " + agency.agency_lang + "\n"
					+ "url " + agency.agency_url + "\n"
					+ "time zone " + agency.agency_timezone);
	}
	
	private void parseCalendar(int rid) {
		BufferedReader rawReader = new BufferedReader(new InputStreamReader(this.getResources().openRawResource(rid)));
		String line = "";
		try {
			while((line = rawReader.readLine()) != null) {
				mCalendarList.add(new Calendar(line));
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void printCalendar() {
		for (Calendar calendar : mCalendarList)
			Log.i(TAG, "service_id " + calendar.service_id + "\n"
					+ "monday " + calendar.monday + "\n"
					+ "tuesday " + calendar.tuesday + "\n"
					+ "wednesday " + calendar.wednesday + "\n"
					+ "thursday " + calendar.thursday + "\n"
					+ "friday " + calendar.friday + "\n"
					+ "saturday " + calendar.saturday + "\n"
					+ "sunday " + calendar.sunday + "\n"
					+ "start_date " + calendar.start_date + "\n"
					+ "end_date" + calendar.end_date);
	}

}
