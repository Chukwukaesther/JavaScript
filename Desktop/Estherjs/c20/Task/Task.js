const number = [10,20,34,44,50,6,77,80,90,15];
const score = number.filter(function(number)
{return number >= 70;
})
console.log(score);




const digit = [85,92,78,88,95];
const newDigit = digit.map(function(number)
{return number + 5;
})
 console.log(newDigit);



const numeric = [2,4,6,8,10];
const numerics = numeric.map(function(number)
{return number ** 2;
})
console.log(numerics);



const namesArray = ["emily","Jack","sophia","daniel"];
const books = ["maths","biology","english","crs"];
for(let words of namesArray){
    let student = books.shift();
    console.log(`${words} ${student}`);
}


const classTiming = ["9:00am","11:00am","1:00pm","3:00pm","5:00pm",]
const afternoonTimimg = classTiming.filter(timing => timing.includes("pm"))

console.log(afternoonTimimg);



const expenses = {"groceries": 150,"dining out": 100,"transportation": 50,"entertainment": 80}























