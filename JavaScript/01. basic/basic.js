var a = 10 

const b = 20
//b = 99 // da error

let c = b - a

let str = 'hola'

let str2 = "chau"

let str3 = `${str} y ${str2}`
//let str3 = str + " y " + str2

a += 5
//a = a + 5

let bool = a < b

let bool2 = str == str2

if(a < b){
	console.log("es menor")
} else if ( a == b){
	console.log("es igual")
} else {
	console.log("es mayor")
}

let comp = a <= b ?  "es menor o igual" : "es mayor"

let miArray = [2,4,6,55,78,32,15,4]

console.log(miArray[0])
console.log(miArray[3])
console.log(miArray[miArray.length - 1])

const myPet = {
	species: "dog",
	name: "Bruce",
	age: 1,
	color: "black",
	dangerous: false,
	vaccines: {
		parainfluenza: true,
		distemper: true,
		rabies: true
	},
	relatives: ['Maia', 'Lizzy', 'Blaky']
}

const myPet2 = {
	species: "dog",
	name: "Maia",
	age: 5,
	color: "black",
	dangerous: false,
	vaccines: {
		parainfluenza: true,
		distemper: true,
		rabies: true
	},
	relatives: ['Bruce', 'Lizzy', 'Blaky']
}

let pets = [myPet,myPet2]

//console.log(JSON.stringify(myPet))
//console.log(JSON.stringify(pets))


function myFnc(n1, n2){
		return n1 + n2
}

var sum = myFnc(4,8)


const myFn = function(){

	let z = 1 //variable local para el primer bloque
	var n = "a" //variable local para todo el bloque, incluido los bloques nesteados

	if(true){
		let z = 0 //variable local para el segundo bloque, igual nombre diferente variable
		var n = "b" //se sobrescribe la variable anterior
		console.log('first print: ' + z) 
		console.log('first print: ' + n) 
	}

	console.log('second print: ' + z)
	console.log('second print: ' + n)

}


myFn()




for(let i = 0; i < 10; i++){
	console.log(i)
}

let array2 = [56,43,90,3,22,67,105,67]

for(let i = 0; i < array2.length; i++){
	console.log(array2[i])
}

let i = 0

while(array2[i] < 100){
	console.log(array2[i])
	i++
}