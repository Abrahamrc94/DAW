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

//EJ5
class Coche{

    constructor(marca, modelo, anyo){

        this.marca = marca;
        this.modelo = modelo;
        this.anyo = anyo;
    }
}

const uno = new Coche("Ferrari", "Pepino", 1456);
const dos = new Coche("Toyota", "Pepinaco", 23);
const tres = new Coche("Porche", "El mejor de los 4", 456);
const cuatro = new Coche("BMW", "Este es mejor que el tercero", 23145);

document.write('<table border="1px">'+ '<tr>' +'<td>' + 'Marca' + '<td>' + 'Modelo' + '<td>' + 'Anyo');
document.write('<tr>' + '<td>' + uno.marca + '<td>' + uno.modelo + '<td>' + uno.anyo);
document.write('<tr>' + '<td>' + dos.marca + '<td>' + dos.modelo + '<td>' + dos.anyo);
document.write('<tr>' + '<td>' + tres.marca + '<td>' + tres.modelo + '<td>' + tres.anyo);
document.write('<tr>' + '<td>' + cuatro.marca + '<td>' + cuatro.modelo + '<td>' + cuatro.anyo);

//EJ6

class Producto_alimenticio{

    constructor(codigo, nombre, precio){

        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    imprimeDatos(){
        return `Codigo: ${this.codigo}, Nombre: ${this.nombre}, Precio: ${this.precio}`;
    }
}

const uno = new Producto_alimenticio(1, "Zanahoria", 3);
const dos = new Producto_alimenticio(2, "Patata", 2);
const tres = new Producto_alimenticio(3, "Lechuga", 1);

var productos = [];

productos[0] = uno;
productos[1] = dos;
productos[2] = tres;

console.log(productos[0].imprimeDatos());
console.log(productos[1].imprimeDatos());
console.log(productos[2].imprimeDatos());
*/
//EJ7

class obj_articulo {

    constructor(desc, codigo, valor) {
        this.desc = desc;
        this.codigo = codigo;
        this.valor = valor;
    }

    iva() {
        return this.valor = this.valor + (this.valor * iva)/100;
    }

    total(reb){
        return this.valor = this.valor - (this.valor * reb)/100;
    }
}

var desc = document.getElementById("descripcion").value;
var cod = parseInt(document.getElementById("codigo").value);
var valor = parseInt(document.getElementById("valor").value);
var iva = parseInt(document.getElementById("iva").value);

const uno = new obj_articulo(desc, cod, valor);
console.log(`Descripcion: ${uno.desc}`);
console.log(`Codigo: ${uno.cod}`);
console.log(`Precio con IVA: ${uno.iva()}`);
console.log(`Precio con descuento: ${uno.total(15)}`);
