let right_operand = 10;
let left_operand = 5;
let operator = "-";
let ans = 0;
  
if (operator == "+"){
    ans = right_operand + left_operand;

}if(operator == "*"){
    ans = right_operand * left_operand;

}if(operator == "-"){
    ans = right_operand - left_operand;

}else if(operator == "/"){
    ans = right_operand / left_operand;

}else{
  ans = NaN;
	}
    console.log(ans);




