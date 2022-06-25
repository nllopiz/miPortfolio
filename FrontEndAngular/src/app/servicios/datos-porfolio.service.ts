import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable, ObservedValueOf } from 'rxjs';
import { Experiencia } from '../modelos/experiencia';
import { AutenticacionService } from './autenticacion.service';

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

  obtenerDatos():Observable<any> {
    //console.log("Servicio de datos");
    //return this.http.get('../../assets/data/data.json')
    return this.httpClient.get<any>(this.url);
  }

  nuevaExperiencia(experiencia: Experiencia):Observable<any> {
    return this.httpClient.post<any>(this.url + "experiencias", experiencia);
  }

  verExperiencia(id: number):Observable<any> {
    return this.httpClient.get<any>(this.url + '/experiencias/' + id);
  }

  editarExperiencia(id: number, experiencia: Experiencia):Observable<any> {
    return this.httpClient.put<any>(this.url + '/experiencias/' + id, experiencia);
  }

  eliminarExperiencia(id: number):Observable<any> {
    return this.httpClient.delete<any>(this.url + '/experiencias/' + id);
  }


}
