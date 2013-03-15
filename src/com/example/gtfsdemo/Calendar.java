package com.example.gtfsdemo;

public class Calendar {

	public String service_id;
	public String monday;
	public String tuesday;
	public String wednesday;
	public String thursday;
	public String friday;
	public String saturday;
	public String sunday;
	public String start_date;
	public String end_date;

	public Calendar(String str) {
		String[] temp = str.split(",");

		this.service_id = temp[0];
		this.monday = temp[1];
		this.tuesday = temp[2];
		this.wednesday = temp[3];
		this.thursday = temp[4];
		this.friday = temp[5];
		this.saturday = temp[6];
		this.sunday = temp[7];
		this.start_date = temp[8];
		this.end_date = temp[9];

	}
}