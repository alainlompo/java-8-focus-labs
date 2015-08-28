package org.lompo.labs.java8.lambdas.streams.filtering;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Programmer {
	private boolean javaSkills;
	private boolean dotNetSkills;
	private boolean haxeSkills;
	
	private String geekName;

	public boolean hasJavaSkills() {
		return javaSkills;
	}

	public void setJavaSkills(boolean javaSkills) {
		this.javaSkills = javaSkills;
	}

	public boolean hasDotNetSkills() {
		return dotNetSkills;
	}

	public void setDotNetSkills(boolean dotNetSkills) {
		this.dotNetSkills = dotNetSkills;
	}

	public boolean hasHaxeSkills() {
		return haxeSkills;
	}

	public void setHaxeSkills(boolean haxeSkills) {
		this.haxeSkills = haxeSkills;
	}

	public String getGeekName() {
		return geekName;
	}

	public void setGeekName(String geekName) {
		this.geekName = geekName;
	}
	
	public static Programmer getJavaGeek(String geekName, boolean hasHaxeAlso, boolean hasDotNetAlso) {
		Programmer geek = new Programmer();
		geek.javaSkills = true;
		geek.haxeSkills = hasHaxeAlso;
		geek.dotNetSkills = hasDotNetAlso;
		geek.setGeekName(geekName);
		return geek;
	}
	
	public static Programmer getHaxeGeek(String geekName, boolean hasJavaAlso, boolean hasDotNetAlso) {
		Programmer geek = new Programmer();
		geek.haxeSkills = true;
		geek.javaSkills = hasJavaAlso;
		geek.dotNetSkills = hasDotNetAlso;
		geek.setGeekName(geekName);
		return geek;
	}
	
	public static List<Programmer> getDemoGeeks() {
		List<Programmer> list = new ArrayList<Programmer>();
		Random r = new Random();
		int number = r.nextInt(100);
		for (int i = 0; i <= number; i++) {
			int decider = r.nextInt();
			list.add((decider % 2==0)? getHaxeGeek("HaxeGeek" + decider, decider % 2 == 0, decider % 3 == 0)
					: getJavaGeek ("JavaGeek" + decider, decider% 2 == 0, decider %3 == 0));
			
		}
		
		return list;
		
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(geekName);
		if (hasJavaSkills()) {
			builder.append(" --- Java");
			
		}
		
		if (hasDotNetSkills() ) {
			builder.append(" *** Dotnet");
		}
		
		if (hasHaxeSkills()) {
			builder.append(" ^^^ Haxe");
		}
		
		return builder.toString();
	}
	
	

}
