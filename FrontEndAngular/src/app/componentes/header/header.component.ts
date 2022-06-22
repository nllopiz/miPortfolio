import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  usuarioAutenticado: any;

  constructor(
    private autenticacionServicio:AutenticacionService,
    private rutas:Router
  ) { }

  ngOnInit(): void {
    this.usuarioAutenticado = this.autenticacionServicio.UsuarioAutenticado.tokenDeAcceso;
  }

  cerrarSesion():void {
    sessionStorage.clear();
    this.rutas.navigate(['/acerca-de']);
  }

  

}
