function addElemento(){

    var miLista = document.getElementById("lista");
    var miPunto = document.createElement("li");
    var valor = document.getElementById("texto").value;
    var miTexto = document.createTextNode(valor);
    miPunto.appendChild(miTexto);
    miLista.appendChild(miPunto);
}

function eliminarElemento(){

    var miLista = document.getElementById("lista");
    var elementBorrar = document.getElementsByTagName("li")[0]
    miLista.removeChild(elementBorrar);
}