export class Persona {
    id?: number;
    email: string;
    apellido: string;
    nombre: string;
    pathFoto?: string;
    titulo: string;
    ubicacion: string;
    sobreMi: string;

    constructor(email: string, apellido: string, nombre: string, pathFoto: string, titulo: string, ubicacion: string, sobreMi: string) {
        this.email = email;
        this.apellido = apellido;
        this.nombre = nombre;
        this.pathFoto = pathFoto;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.sobreMi = sobreMi;
    }

}
