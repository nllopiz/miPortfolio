import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable, ObservedValueOf } from 'rxjs';
import { Experiencia } from '../modelos/experiencia';
import { AutenticacionService } from './autenticacion.service';
import { Formacion } from '../modelos/formacion';
import { Proyecto } from '../modelos/proyecto';
import { Persona } from '../modelos/persona';
import { Habilidad } from '../modelos/habilidad';

@Injectable({
  providedIn: 'root'
})
export class DatosPorfolioService {
  idPersona: number = 1;
  url:string=`http://localhost:8080/api/personas/${this.idPersona}`
  
  constructor(
    private httpClient: HttpClient,
    private autenticacionService: AutenticacionService
    ) { }

  verPersona():Observable<any> {
    //console.log("Servicio de datos");
    //return this.http.get('../../assets/data/data.json')
    return this.httpClient.get<any>(this.url);
  }

  editarPersona(persona: Persona): Observable<any> {
    return this.httpClient.put<any>(this.url, persona);
  }

  nuevaExperiencia(experiencia: Experiencia):Observable<any> {
    return this.httpClient.post<any>(this.url + '/experiencias/', experiencia);
  }

  verExperiencias():Observable<any> {
    return this.httpClient.get<any>(this.url + '/experiencias/');
  }

  verExperiencia(id: number):Observable<any> {
    return this.httpClient.get<any>(this.url + '/experiencias/' + id);
  }

  editarExperiencia(id: number, experiencia: Experiencia):Observable<any> {
    return this.httpClient.put<any>(this.url + '/experiencias/' + id, experiencia);
  }

  eliminarExperiencia(id: number):Observable<any> {
    console.log('Eliminando');    
    return this.httpClient.delete<any>(this.url + '/experiencias/' + id);
  }

  verFormaciones():Observable<any> {
    return this.httpClient.get<any>(this.url + '/formaciones');
  }
  
  nuevaFormacion(formacion: Formacion):Observable<any> {
    return this.httpClient.post<any>(this.url + "/formaciones/", formacion);
  }

  verFormacion(id: number):Observable<any> {
    return this.httpClient.get<any>(this.url + '/formaciones/' + id);
  }

  editarFormacion(id: number, formacion: Formacion):Observable<any> {
    return this.httpClient.put<any>(this.url + '/formaciones/' + id, formacion);
  }

  eliminarFormacion(id: number):Observable<any> {
    console.log('Eliminando');    
    return this.httpClient.delete<any>(this.url + '/formaciones/' + id);
  }

  nuevoProyecto(proyecto: Proyecto):Observable<any> {
    return this.httpClient.post<any>(this.url + "/proyectos", proyecto);
  }

  verProyectos():Observable<any> {
    return this.httpClient.get<any>(this.url + '/proyectos');
  }

  verProyecto(id: number):Observable<any> {
    return this.httpClient.get<any>(this.url + '/proyectos/' + id);
  }

  editarProyecto(id: number, proyecto: Proyecto):Observable<any> {
    return this.httpClient.put<any>(this.url + '/proyectos/' + id, proyecto);
  }

  eliminarProyecto(id: number):Observable<any> {
    console.log('Eliminando');    
    return this.httpClient.delete<any>(this.url + '/proyectos/' + id);
  }

  nuevaHabilidad(habilidad: Habilidad):Observable<any> {
    return this.httpClient.post<any>(this.url + "/habilidad", habilidad);
  }

  verHabilidades():Observable<any> {
    return this.httpClient.get<any>(this.url + '/habilidades');
  }

  verHabilidad(id: number):Observable<any> {
    return this.httpClient.get<any>(this.url + '/habilidades/' + id);
  }

  editarHabilidad(id: number, habilidad: Habilidad):Observable<any> {
    return this.httpClient.put<any>(this.url + '/habilidades/' + id, Habilidad);
  }

  eliminarHabilidad(id: number):Observable<any> {
    console.log('Eliminando');    
    return this.httpClient.delete<any>(this.url + '/habilidades/' + id);
  }

}
