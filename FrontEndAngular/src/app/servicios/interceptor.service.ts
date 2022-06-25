import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AutenticacionService } from './autenticacion.service';

@Injectable({
  providedIn: 'root'
})
export class InterceptorService implements HttpInterceptor{

  constructor(private autenticacionServicio: AutenticacionService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let intreq = req;
    const currentUser = this.autenticacionServicio.usuarioAutenticado;
    
    if(currentUser && currentUser.tokenDeAcceso) {
      //console.log(currentUser.tokenDeAcceso);
      intreq = req.clone({ headers: req.headers.set('Authorization', 'Bearer ' + currentUser.tokenDeAcceso)});
      console.log(intreq);
    }
    console.log("Interceptor está corriendo" + JSON.stringify(currentUser));
    return next.handle(intreq);
  }
}

export const interceptorProvider = [{provide: HTTP_INTERCEPTORS, useClass: InterceptorService, multi: true}];
