import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DatosPorfolioService {

  constructor(private http: HttpClient) { }

  obtenerDatos():Observable<any> {
    //console.log("Servicio de datos");
    return this.http.get('../../assets/data/data.json')
  }
}
