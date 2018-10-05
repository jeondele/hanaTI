/**
 * 학생개체 추상화
 */
var kosta = {};
kosta.school = {};
kosta.school.Student = function(name, korean, math, english, science){
	this.name = name;
	this.korean = korean;
	this.math = math;
	this.english = english;
	this.science = science;
}

/* 사용자 정의 객체 (생성자) */
//function Student(name, korean, math, english, science) {
	//프로퍼티	
	/*
	this.getSum = function(){
		return this.korean + this.math + this.english + this.science;
	}
	
	this.getAvg = function(){
		return (this.getSum())/4;
	}
	
	this.toString = function() {
		return this.name+"\t"+this.korean+"\t"+this.math+"\t"+this.english+"\t"+this.science;
	}
	*/


//프로토타입에 메소드 저장
kosta.school.Student.prototype.getSum = function(){return this.korean + this.math + this.english + this.science;};
kosta.school.Student.prototype.getAvg = function(){return (this.getSum())/4;};
kosta.school.Student.prototype.toString = function(){return this.name+"\t"+this.korean+"\t"+this.math+"\t"+this.english+"\t"+this.science;};

kosta.school.Student.schoolName = "kosta 대학교";