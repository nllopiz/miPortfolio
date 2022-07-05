export class Proyecto {
    id?: string;
    titulo: string;
    pathImagen: string;
    descripcion: string;
    link: string;
    github: string;

    constructor(titulo: string, pathImage: string, descripcion: string, link: string, github: string) {
        this.titulo = titulo;
        this.pathImagen = pathImage;
        this.descripcion = descripcion;
        this.link = link;
        this.github = github; 
    }
}
