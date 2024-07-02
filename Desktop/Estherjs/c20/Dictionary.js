// let input = [2,3,5,3,3,2,5];

// let digit = {} 

// function ListOfNumbers(){
// digit[2] = 2;
// digit[3] = 3;
// digit[5] = 2;

// console.log(digit);

// }

// ListOfNumbers();

function listOfNumbers(array){
    let digit = {};

    for (let index = 0; index < array.length; index++) {
        let number = array[index];
        if(digit[number]){
            digit[number] += 1;
        }else{
            digit[number] = 1;
        }        
    }   
    return digit;
}
const input = [2,3,5,3,3,2,5];
console.log((listOfNumbers(input)))

// const listOfNumbers = {2,3,4,5,1}
// const user = {
//     "fistName":"chinedu",
//     "lastName": "ugo"

//     int result = listOfNumbers.map((details)=>{
//         return details * 2;
//     });
//     console.log(details)

//     }   
