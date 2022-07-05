export class Formacion {
    id?: string;
    titulo: string;
    periodo: string;
    pathLogo: string;
    descripcion: string;

    constructor(titulo: string, periodo: string, pathLogo: string, descripcion: string) {
        this.titulo = titulo;
        this.periodo = periodo;
        this.pathLogo = pathLogo;
        this.descripcion = descripcion;
    }
}
