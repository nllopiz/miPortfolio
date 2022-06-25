import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AutenticacionService } from './autenticacion.service';

@Injectable({
  providedIn: 'root'
})
export class GuardGuard implements CanActivate {

  constructor (private autenticacionServicio:AutenticacionService,
    private rutas: Router
  ) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      let currentUser = this.autenticacionServicio.usuarioAutenticado;
      /*console.log("CanActivate...<br>");
      console.log(currentUser);
      console.log(currentUser.tokenDeAcceso);*/
      if (currentUser && currentUser.tokenDeAcceso) {
        console.log(currentUser.tokenDeAcceso);
        return true;
      }
      else {
        console.log(currentUser);
        this.rutas.navigate(['/iniciar-sesion']);
        return false;
      }
      
  }
  
}
