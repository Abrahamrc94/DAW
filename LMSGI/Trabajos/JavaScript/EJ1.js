/*
//EJ1
var resultado;

function ej1(num1, num2, num3, num4, num5){

    resultado = (num1+num2+num3+num4+num5)/5;
    return resultado;
}

//EJ2
function ej2(num1, num2, num3){

    var resultado;
    var media;
    media = (parseInt(num1) + parseInt(num2) + parseInt(num3))/parseInt(3);
    
    if(media >= 5){
        resultado = "Aprobado";
    }else{
        resultado = "Suspenso";
    }
    return resultado;
}

//EJ3
var numAlto;
var numBajo;
var numeros = [10,1,2,3,4,5,6,22,8,9,11,12,15,13,14];

numAlto = Math.max(...numeros);

numBajo = Math.min(...numeros);

console.log("Numero mas alto: " + numAlto + "\nPosicion: " + numeros.indexOf(numAlto));
console.log("Numero mas bajo: " + numBajo + "\nPosicion: " + numeros.indexOf(numBajo));

//EJ4
var palabras = [];

for(var i = 0; i < 5; i++){
    palabras[i] = prompt("Ingrese una palabra");
}

console.log(palabras[0]);
console.log(palabras[4]);
console.log(palabras.length);
console.log(palabras.sort());
*/
//EJ5
class Coche{

    constructor(marca, modelo, anyo){
        this.marca = marca;
        this.modelo = modelo;
        this.anyo = anyo;


    }
    mostrar(){
        return `Marca: ${this.marca}, Modelo: ${this.modelo}, Anyo: ${this.anyo}`;
    }
}

const uno = new Coche("Ferrari", "Pepino", 1456);
const dos = new Coche("Toyota", "Pepinaco", 23);
const tres = new Coche("Audi", "Mas pepino aun", 2316514);
const cuatro = new Coche("Porche", "El mejor de los 5", 456);
const cinco = new Coche("BMW", "Este es mejor que el cuatro", 23145);

console.log(uno.mostrar());
console.log(dos.mostrar());
console.log(tres.mostrar());
console.log(cuatro.mostrar());
console.log(cinco.mostrar());
