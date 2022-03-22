function cambiarSobreMi() {
    //alert("Editar Sobre mí")
    //mostrar input
    document.getElementById('editarSobreMi').classList = 'd-block'
    document.getElementById('textAreaSobreMi').value = document.getElementById('textoSobreMi').innerText;
    
}

function cambiarSobreMi(nuevoTexto) {
    document.getElementById('textoSobreMi').innerText = nuevoTexto;
}

function ocultarEditarSobreMi (){
    document.getElementById('editarSobreMi').classList = 'd-none'
}


function editar(elemento) {
    //mostrar
    console.log(elemento);
    elemento.classList = 'd-block';
    document.getElementsByTagName('textArea').value = document.getElementById('textoSobreMi').innerText;
    
}






function editarExperiencia() {

}

function editarFormacion() {

}

function editarSkills() {

}

function editarProyectos() {

}