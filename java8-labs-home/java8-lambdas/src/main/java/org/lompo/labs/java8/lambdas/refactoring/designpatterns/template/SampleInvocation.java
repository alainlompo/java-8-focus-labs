package org.lompo.labs.java8.lambdas.refactoring.designpatterns.template;

public class SampleInvocation {

	public static void main(String[] args) {
		Player Rawnhaldaw = new Player("Rhonehaldaw", PlayerClass.GALACTIC);
		Player PeyLew = new Player("PeyLew", PlayerClass.PRO);
		SoccerHub theHub = new SoccerHub();
		theHub.recruitPlayer(Rawnhaldaw, p -> {
			System.out.println("Hey ron, we will buy you a car also....");
			System.out.println("All your medical bills will be reimbursed....");
			System.out.println("Okay, you gonna have a plane too.");
		});
		
		theHub.recruitPlayer(PeyLew, p -> {
			System.out.println("Hi Pel, you have been the best player ever, so just ask and it will be yours");
		});
	}
}
