export class Habilidad {
    id?: string;
    nombre: string;
    porcentajeDominio: number;
    
    constructor(nombre: string, porcentajeDominio: number) {
        this.nombre = nombre;
        this.porcentajeDominio = porcentajeDominio;
    }
}
