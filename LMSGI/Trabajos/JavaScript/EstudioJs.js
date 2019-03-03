
function a(){
class Juego{

    constructor(nombre, horas, tipo){

        this.nombre = nombre;
        this.horas = horas;
        this.tipo = tipo;
    }

    mostrar(){

        return `Nombre: ${this.nombre}, Horas: ${this.horas}, Tipo: ${this.tipo}`;
    }
}

//const uno = new Juego('Pam', 25, 'Shooter');

//document.write('<table border = "1">' + '<tr>' + '<td>' + 'Nombre' + '<td>' + 'Horas' + '<td>' + 'Tipo');
//document.write('<tr>' + '<td>' + uno.nombre + '<td>' + uno.horas + '<td>' + uno.tipo);
var nombre = document.getElementById("nombre").value;
var horas = document.getElementById("horas").value;
var tipo = document.getElementById("tipo").value;

const dos = new Juego(nombre, horas, tipo);

var miTabla = document.getElementById("tabla");
var miTr = document.createElement("tr");
var miTd = document.createElement("td");
var miNombre = document.createTextNode(nombre);
var miHoras = document.createTextNode(horas);
var miTipo = document.createTextNode(tipo);

miTabla.appendChild(miTr);
miTr.appendChild(miTd);
miTd.appendChild(miNombre);

}