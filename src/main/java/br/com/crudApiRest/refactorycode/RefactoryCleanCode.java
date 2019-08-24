package br.com.crudApiRest.refactorycode;

public class RefactoryCleanCode {

	public Double sum(Double firtsNumber, Double secondNumber) {
		return firtsNumber + secondNumber;
	}
	
	public Double subtract(Double firtsNumber, Double secondNumber) {
		return firtsNumber - secondNumber;
	}
	public Double multiplication(Double firtsNumber, Double secondNumber) {
		return firtsNumber * secondNumber;
	}
	public Double division(Double firtsNumber, Double secondNumber) {
		return firtsNumber / secondNumber;
	}
	public Double mean(Double firtsNumber, Double secondNumber) {
		return (firtsNumber + secondNumber)/2;
	}
	public Double squareRoot(Double number) {
		return (Double) Math.sqrt(number);
	}

}
