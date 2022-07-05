export class Habilidad {
    id?: string;
    nombre: string;
    porcentajes: string;
    
    constructor(nombre: string, porcentajes: string) {
        this.nombre = nombre;
        this.porcentajes = porcentajes;
    }
}
